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
        List<IQuestion>questionList=iqs.getQuestionSet();
        for (IQuestion q : iqs.getQuestionSet()) {
            int scorePoint = getPoint(iqs, questionList.indexOf(q) );
            
            switch (q.getQuestionAnswer()) {
                case 1:
                    aTotal += scorePoint;
                case 2:
                    bTotal += scorePoint;
                case 3:
                    cTotal += scorePoint;
                case 4:
                    dTotal += scorePoint;
                case 5:
                    eTotal += scorePoint;
                case 6:
                    fTotal += scorePoint;
                case 7:
                    gTotal += scorePoint;
                case 8:
                    hTotal += scorePoint;
                case 9:
                    iTotal += scorePoint;
                case 10:
                    jTotal += scorePoint;
            }
        }

        return list;
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
