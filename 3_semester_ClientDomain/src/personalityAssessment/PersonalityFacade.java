/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

import ProjectInterfaces.IQuestionSet;

/**
 *
 * @author ahmadhamid
 */
public class PersonalityFacade {
    private IQuestionSet iqs;
    private ScoreCalculator sc;

    public PersonalityFacade() {
        this.iqs = new QuestionSet(this);
        this.sc = new ScoreCalculator(this);
    }
    
    public IQuestionSet getQuestionSet(/*IUser - står i UML class diagram*/) {
        return iqs;
    }
    
    public void setAnswer(int questionNumber, int answer) {
        iqs.getQuestionSet().get(questionNumber).setQuestionAnswer(answer);
    }
    
    public int[] calculateScore(QuestionSet qs) {
        return sc.calculateScore(qs);
    }
 
    /*Main-method to test the functionality*/
    public static void main(String[] args) {
        
    }
}
