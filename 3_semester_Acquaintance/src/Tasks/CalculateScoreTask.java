/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;

/**
 *
 * @author Sebas
 */
public class CalculateScoreTask extends Task {

    private IUser user;
    private IQuestionSet set;

    public CalculateScoreTask(IUser user, IQuestionSet set) {
        super(TaskTypes.CALC);
        this.user = user;
        this.set = set;
    }

    public IUser getUser() {
        return user;
    }

    public IQuestionSet getSet() {
        return set;
    }

}
