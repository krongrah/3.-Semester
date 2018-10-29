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
public class QuestionSet {

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

    public String[] getQuestions() {
        return questions;
    }

    public int[] getQuestionFactors() {
        return questionsfactor;
    }

    public boolean[] getQuestionDirections() {
        return questionDirection;
    }

    public int[] getAnswers() {
        return questionsAnswer;
    }

    public void setAnswers(int questionNumber, int answer) {
        questionsAnswer[questionNumber] = answer;
    }

}
