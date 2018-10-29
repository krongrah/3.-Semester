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
public class PersonalityFacade {
    private QuestionSet qs;
    private ScoreCalculator sc;

    public PersonalityFacade() {
        this.qs = new QuestionSet(this);
        this.sc = new ScoreCalculator(this);
    }
    
    public QuestionSet getQuestionSet(/*IUser*/) {
        return qs;
    }
    
    public void setAnswer(int questionNumber, int answer) {
        qs.setAnswers(questionNumber, answer);
    }
    
    public int[] calculateScore(QuestionSet qs) {
        return sc.calculateScore(qs);
    }
    
}
