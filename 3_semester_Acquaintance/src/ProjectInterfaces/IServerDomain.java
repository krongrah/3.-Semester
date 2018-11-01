/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

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
    
    public IUser getCompanyUser(int i);
    
    public IUser getUser(String username, String password);
    
    public IQuestionSet getQuestionSet();
    
    public IServerDomain getInstance();
    
    public void applyForJob(IJobPost jobpost, IUser applicant);
}
