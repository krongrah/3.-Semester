/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

import ProjectInterfaces.IQuestion;

/**
 *
 * @author ahmadhamid
 */
public class Question implements IQuestion {

    private final String question;
    private final int questionFactor;
    private final boolean questionDirection;
    private int questionAnswer;

    public Question(String question, int questionsfactor, boolean questionDirection) {
        this.question = question;
        this.questionFactor = questionsfactor;
        this.questionDirection = questionDirection;
    }

    public Question(IQuestion q) {
        this.question = q.getQuestion();
        this.questionFactor = q.getQuestionsfactor();
        this.questionDirection = q.getQuestionDirection();
        this.questionAnswer = q.getQuestionAnswer();
    }
    
    

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public int getQuestionsfactor() {
        return questionFactor;
    }

    @Override
    public boolean getQuestionDirection() {
        return questionDirection;
    }

    @Override
    public int getQuestionAnswer() {
        return questionAnswer;
    }

    @Override
    public void setQuestionAnswer(int ans) {
        this.questionAnswer = ans;
    }

}
