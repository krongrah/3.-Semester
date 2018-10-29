/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

import ProjectInterfaces.IQuestionSet;
import java.io.Serializable;

/**
 *
 * @author ahmadhamid
 */
public class QuestionSet implements IQuestionSet, Serializable {

    private PersonalityFacade pf;
    private Question q1;

    public QuestionSet(PersonalityFacade pf) {
        this.pf = pf;

        importQuestions();
    }

    @Override
    public void importQuestions() {
        //TODO import downloading questions from database.
        String[] ses;
    }
    
    public void importQuestions2() {
        
    }

    @Override
    public String[] getQuestions() {
        return questions;
    }

    @Override
    public int[] getQuestionFactors() {
        return questionsfactor;
    }

    @Override
    public boolean[] getQuestionDirections() {
        return questionDirection;
    }

    @Override
    public int[] getAnswers() {
        return questionsAnswer;
    }

    @Override
    public void setAnswers(int questionNumber, int answer) {
        questionsAnswer[questionNumber] = answer;
    }

}
