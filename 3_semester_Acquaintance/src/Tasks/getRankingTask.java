/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IUser;

/**
 *
 * @author ahmadhamid
 */
public class getRankingTask extends Task {

    private IJobPost jobPost;
    private IUser user;

    public getRankingTask(IJobPost jobPost, IUser user) {
        super(TaskTypes.RANKING);
        this.jobPost = jobPost;
        this.user = user;
    }

    public IJobPost getJobPost() {
        return jobPost;
    }

    public IUser getUser() {
        return user;
    }

}
