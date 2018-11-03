/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

import commondata.Question;
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
    
    public PersonalityFacade(){
    sc=new ScoreCalculator();
    }

    public IQuestionSet getQuestionSet(ResultSet rs) {
        List<IQuestion> q = new ArrayList();
        IQuestionSet qs = new QuestionSet(q);
        try {
            while (rs.next()) {
                q.add(new Question(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4)));
                return qs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonalityFacade.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
    public int[] calculateScore(IQuestionSet questionSet) {
        return sc.calculateScore(questionSet);
    }

}

