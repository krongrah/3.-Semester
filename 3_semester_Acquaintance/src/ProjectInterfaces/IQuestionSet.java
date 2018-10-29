/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 *
 * @author mikkellarsen
 */
public interface IQuestionSet {
    
    /**
     * Method which imports the questions
     */
    public void importQuestions();

    /**
     * Method that gets questions
     * @return 
     */
    public String[] getQuestions();

    public int[] getQuestionFactors();

    public boolean[] getQuestionDirections();

    public int[] getAnswers();

    public void setAnswers(int questionNumber, int answer);

}
