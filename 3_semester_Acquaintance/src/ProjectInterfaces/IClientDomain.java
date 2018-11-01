/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.util.List;

/**
 * The interface for the Client domain
 * @author Krongrah
 */
public interface IClientDomain {

    
    /**
     * Method for injecting Client communication
     * @param comm 
     */
    public void injectClientComm(IClientComm comm);
    
    /**
     * Methods to login a given user
     * @param username
     * @param password
     * @return true if successful login, else false.
     */
    public boolean login(String username, String password);
    
    public IUser getActiveUser();
    
    public boolean isLoggedIn();
    
    /**
     * Logs out the active user
     */
    public void logout();
    
    public List<IJobPost> getAllJobs();
    public boolean connectToServer();

}
