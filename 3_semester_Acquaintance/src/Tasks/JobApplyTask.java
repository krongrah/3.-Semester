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
 * @author Sebas
 */
public class JobApplyTask extends Task{
    
    private IUser user;
    private IJobPost job;

    public JobApplyTask(IUser user, IJobPost job){
        super(TaskTypes.APPLY);
        this.user=user;
        this.job=job;
    }

    public IUser getUser() {
        return user;
    }

    public IJobPost getJob() {
        return job;
    }
    
    
    
}
