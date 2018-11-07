package commondata;

import ProjectInterfaces.IQuestion;
import ProjectInterfaces.IQuestionSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Krongrah
 */
public class QuestionSet implements IQuestionSet, Serializable {

    private List<IQuestion> questions = new ArrayList();

    public QuestionSet(List<IQuestion> ql) {
        questions = ql;
    }

    @Override
    public List<IQuestion> getQuestionSet() {
        return questions;
    }

    @Override
    public IQuestion getQuestion(int i) {
        return questions.get(i);
    }

}
