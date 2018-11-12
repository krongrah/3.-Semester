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
        this.user=user;
        this.job=job;
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
