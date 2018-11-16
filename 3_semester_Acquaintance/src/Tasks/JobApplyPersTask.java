/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;

/**
 *
 * @author Sebas
 */
public class JobApplyPersTask extends Task {

    private IUser user;
    private IJobPost job;
    private IQuestionSet set;

    public JobApplyPersTask(IUser user, IJobPost job, IQuestionSet set) {
        super(TaskTypes.APPLYPERS);
        this.user = user;
        this.job = job;
        this.set = set;
    }

    public IUser getUser() {
        return user;
    }

    public IJobPost getJob() {
        return job;
    }

    public IQuestionSet getSet() {
        return set;
    }

}
