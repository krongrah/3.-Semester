/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSystems;

import UserSystem.Applicant;
import ProjectInterfaces.IServerDomain;
import ProjectInterfaces.IUser;

/**
 *Communicates with the UserSystem package to make it possible for the user to
 * call the applicant
 * @author Naik
 */
public class JobsManager {
    private static JobsManager jobmanager;
    private static IServerDomain serverdomain;

    public JobsManager getInstance() {
        if(jobmanager==null){
            jobmanager = new JobsManager();
            
        }
        return jobmanager;
    }
    

 public IUser getCompanyUser(int i){
        return serverdomain.getInstance().getCompanyUser(i);
    }
}
