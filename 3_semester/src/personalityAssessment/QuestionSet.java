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
    private final String[] questions;
    private final int[] questionsfactor;
    private final boolean[] questionDirection;
    private int[] questionsAnswer;

    public QuestionSet(PersonalityFacade pf) {
        this.pf = pf;
        this.questions = new String[100];
        this.questionsfactor = new int[100];
        this.questionDirection = new boolean[100];
        this.questionsAnswer = new int[100];

        importQuestions();
    }

    @Override
    public void importQuestions() {
        //TODO import downloading questions from database.
        String data = "SPG;3;0";

        for (int i = 0; i < 50; i++) {
            String[] split = data.split(":");

            questions[i] = split[0];
            questionsfactor[i] = Integer.parseInt(split[1]);
            questionDirection[i] = Boolean.parseBoolean(split[2]);
        }
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
