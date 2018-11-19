package personalityAssessment;

import ProjectInterfaces.IQuestion;
import ProjectInterfaces.IQuestionSet;
import commondata.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmadhamid
 */
public class ScoreCalculator {

    /**
     * Returns a List<{@link QuestionSet}>, containing the users total results.
     * An calculator that calculates personality asessment results by running through all answers to {@link Question} in the {@link IQuestionSet}.
     * It returns a List<{@link QuestionSet}>, that can be used as a representation of the test-results.
     * The {@link IQuestionSet} argument must specify a concrete implementation of IQuestionSet.
     * 
     * @param iqs a concrete implementation of the interface {@link iQuestionSet}.
     * @return a list af integers, representing the archived score in the  10 (5) categories of Big Five.
     */
    public List<Integer> calculateScore(IQuestionSet iqs) {
        List<Integer> list = new ArrayList();
        int aTotal = 0, bTotal = 0, cTotal = 0, dTotal = 0, eTotal = 0, fTotal = 0, gTotal = 0, hTotal = 0, iTotal = 0, jTotal = 0;
        List<IQuestion> questionList = iqs.getQuestionSet();
        
        for (IQuestion q : questionList) {
            int scorePoint = getPoint(q);

            switch (q.getQuestionsfactor()) {
                case 1:
                    aTotal += scorePoint;
                    break;
                case 2:
                    bTotal += scorePoint;
                    break;
                case 3:
                    cTotal += scorePoint;
                    break;
                case 4:
                    dTotal += scorePoint;
                    break;
                case 5:
                    eTotal += scorePoint;
                    break;
                case 6:
                    fTotal += scorePoint;
                    break;
                case 7:
                    gTotal += scorePoint;
                    break;
                case 8:
                    hTotal += scorePoint;
                    break;
                case 9:
                    iTotal += scorePoint;
                    break;
                case 10:
                    jTotal += scorePoint;
                    break;
            }
        }
        
        list.add(aTotal);
        list.add(bTotal);
        list.add(cTotal);
        list.add(dTotal);
        list.add(eTotal);
        list.add(fTotal);
        list.add(gTotal);
        list.add(hTotal);
        list.add(iTotal);
        list.add(jTotal);

        return list;
    }

    /**
     * Returns an int, containing the point-weight for the specified {@link IQuestion} object.
     * Based oon the direction of the question, the answer is given a weight, which is calculated.
     * @param iq a concrete implementation of the interface {@link iQuestion}.
     * @return  the integer value of the answer given to the question {@link iq}.
     */
    public int getPoint(IQuestion iq) {
        int scorePoint = 0;
        if (!iq.getQuestionDirection()) {
            switch (iq.getQuestionAnswer()) {
                case 1:
                    scorePoint += 5;
                    break;
                case 2:
                    scorePoint += 4;
                    break;
                case 3:
                    scorePoint += 3;
                    break;
                case 4:
                    scorePoint += 2;
                    break;
                case 5:
                    scorePoint += 1;
                    break;
            }
        } else {
            switch (iq.getQuestionAnswer()) {
                case 1:
                    scorePoint += 1;
                    break;
                case 2:
                    scorePoint += 2;
                    break;
                case 3:
                    scorePoint += 3;
                    break;
                case 4:
                    scorePoint += 4;
                    break;
                case 5:
                    scorePoint += 5;
                    break;
            }
        }
        return scorePoint;
    }
    
    /**
     * Returns an int, containing the point-weight for the specified {@link IQuestion} object.
     * Based oon the direction of the question, the answer is given a weight, which is calculated.
     * 
     * @param iqs
     * @param i
     * @return the integer value of the answer given to the question.
     * @deprecated replaced by {@link #getPoint(ProjectInterfaces.IQuestion)}
     */
    public int getPoint(IQuestionSet iqs, int i) {
        int scorePoint = 0;
        if (!iqs.getQuestionSet().get(i).getQuestionDirection()) {
            switch (iqs.getQuestion(i).getQuestionAnswer()) {
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
            switch (iqs.getQuestion(i).getQuestionAnswer()) {
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
        return scorePoint;
    }

}
