package personalityAssessment;

import ProjectInterfaces.IQuestion;
import ProjectInterfaces.IQuestionSet;
import commondata.QuestionSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmadhamid
 */
public class PersonalityFacade {

    ScoreCalculator sc;

    public PersonalityFacade() {
        sc = new ScoreCalculator();
    }

    public IQuestionSet getQuestionSet(ResultSet rs) {
        List<IQuestion> q = new ArrayList();
        IQuestionSet qs;
        try {
            while (rs.next()) {
                q.add(new Question(rs.getString(2), rs.getInt(3), rs.getBoolean(4)));
            }
            qs = new QuestionSet(q);
            return qs;
        } catch (SQLException ex) {
            Logger.getLogger(PersonalityFacade.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public List<Integer> calculateScore(IQuestionSet questionSet) {
        return sc.calculateScore(questionSet);
    }

}
