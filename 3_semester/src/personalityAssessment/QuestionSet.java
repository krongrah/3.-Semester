/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalityAssessment;

import ProjectInterfaces.IQuestion;
import ProjectInterfaces.IQuestionSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmadhamid
 */
public class QuestionSet implements IQuestionSet, Serializable {

    private List<IQuestion> questions = new ArrayList();

    public QuestionSet() {
    }

    public QuestionSet(List<Question> ql) {
        int i = 0;
        while (!(ql.size() == (i + 1))) {
            addToList(new Question(ql.get(i)));
            i++;
        }
    }

    @Override
    public List<IQuestion> getQuestionSet() {
        return questions;
    }

    @Override
    public void addToList(IQuestion q) {
        questions.add(q);
    }

    @Override
    public List<Integer> getAnswers() {
        //shouldn't be a thing.
        return null;
    }

    

}
