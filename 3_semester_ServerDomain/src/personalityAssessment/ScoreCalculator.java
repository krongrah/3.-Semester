package personalityAssessment;

import ProjectInterfaces.IQuestion;
import ProjectInterfaces.IQuestionSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmadhamid
 */
public class ScoreCalculator {

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
