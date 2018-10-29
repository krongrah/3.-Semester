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
public class Question {
    private final String questions;
    private final int questionsfactor;
    private final boolean questionDirection;
    private int questionsAnswer;

    public Question(String questions, int questionsfactor, boolean questionDirection, int questionsAnswer) {
        this.questions = questions;
        this.questionsfactor = questionsfactor;
        this.questionDirection = questionDirection;
        this.questionsAnswer = questionsAnswer;
    }

    public String getQuestions() {
        return questions;
    }

    public int getQuestionsfactor() {
        return questionsfactor;
    }

    public boolean isQuestionDirection() {
        return questionDirection;
    }

    public int getQuestionsAnswer() {
        return questionsAnswer;
    }
    
    
}
