/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

import ProjectInterfaces.IQuestion;
import ProjectInterfaces.IQuestionSet;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmadhamid
 */
public class QuestionSet implements IQuestionSet, Serializable {

    private PersonalityFacade pf;
    private List<IQuestion> questions = new ArrayList();

    public QuestionSet(PersonalityFacade pf) {
        this.pf = pf;
    }
    
    public QuestionSet(ResultSet rs) throws SQLException {
        while(rs.next()) {
            addToList(new Question(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getBoolean(4)));
        }
    }

    public QuestionSet() {
    }
    
    @Override
    public List<IQuestion> getQuestionSet() {
        return this.questions;
    }
    
    @Override
    public void addToList(IQuestion q) {
        questions.add(q);
    }

    @Override
    public List<Integer> getAnswers() {
        List<Integer> answers = new ArrayList();
        for (IQuestion question : questions) {
            answers.add(question.getQuestionAnswer());
        }
        return answers;
    }

    @Override
    public IQuestion getQuestion(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
