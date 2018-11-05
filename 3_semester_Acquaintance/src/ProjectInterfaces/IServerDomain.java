/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.util.List;

/**
 * The interface for the Server Domain
 * @author Krongrah
 */
public interface IServerDomain {

    
    /**
     * The method for injecting the Server Persistence interface
     * @param persistence 
     */
    public void injectPersistence(IServerPersistence persistence);
        
    public IUser getUser(String username, String password);
    
    public IQuestionSet getQuestionSet();
    
    public void applyForJob(IJobPost jobpost, IUser applicant);
    
    public List<Integer> calculateScore(IUser user, IQuestionSet set);

    public List<IJobPost> getAllJobs();

    public void applyForJob(IJobPost job, IUser user, IQuestionSet questionSet);

}
