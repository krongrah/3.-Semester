/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

/**
 *
 * @author ahmadhamid
 */
public class ScoreCalculator {
    private PersonalityFacade pf;

    public ScoreCalculator(PersonalityFacade pf) {
        this.pf = pf;
    }
    
    public int[] calculateScore(QuestionSet qs) {
        int[] score = new int[5];
        int aTotal = 0;
        int bTotal = 0;
        int cTotal = 0;
        int dTotal = 0;
        int eTotal = 0;
        
        for (int i = 0; i < 50; i++) {
            int scorePoint = 0;
            
            if (qs.getQuestionDirections()[i] == false) {
                switch(qs.getAnswers()[i]) {
                    case 1:
                        scorePoint += 5;
                    case 2:
                        scorePoint += 4;
                    case 3:
                        scorePoint += 3;
                    case 4:
                        scorePoint += 2;
                    case 5:
                        scorePoint += 1;
                }
            } else {
                switch(qs.getAnswers()[i]) {
                    case 1:
                        scorePoint += 1;
                    case 2:
                        scorePoint += 2;
                    case 3:
                        scorePoint += 3;
                    case 4:
                        scorePoint += 3;
                    case 5:
                        scorePoint += 4;
                }
            }
            
            switch(qs.getQuestionFactors()[i]) {
                case 1:
                    aTotal += scorePoint;
                case 2:
                    bTotal += scorePoint;
                case 3:
                    cTotal += scorePoint;
                case 4:
                    dTotal += scorePoint;
                case 5:
                    eTotal += scorePoint;
            }
        }
        
        return score;
    }
    
}
