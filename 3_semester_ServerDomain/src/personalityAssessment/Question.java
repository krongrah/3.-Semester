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
