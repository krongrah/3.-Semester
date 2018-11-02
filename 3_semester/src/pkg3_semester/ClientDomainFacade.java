/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientSecurity;
import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import ProjectInterfaces.IUserManager;
import SecuritySystem.SecuritySystemFacade;
import UserSystem.Applicant;
import UserSystem.UserManager;
import java.util.List;

/**
 * Communication between the other 2 layers, which are the GUI and the
 * ClientComm
 *
 */
public class ClientDomainFacade implements IClientDomain {

    private IClientComm comm;
    private IUserManager userManager;
    private IClientSecurity security;

    public ClientDomainFacade() {
        userManager = new UserManager(security, comm);
        security = new SecuritySystemFacade();
    }

    /**
     * Injects an instance of the Client Communication facade
     *
     * @param comm
     */
    @Override
    public void injectClientComm(IClientComm comm) {
        this.comm = comm;
    }

    @Override
    public boolean connectToServer() {
        return comm.connectToServer();
    }

    /**
     * Logs in the user, with a username and a password, the password is first
     * hashed using SHA-256.
     *
     * @param username
     * @param password
     * @return True if successful login, else returns false
     */
    @Override
    public boolean login(String username, String password) {
        return userManager.login(username, password);
    }

    /**
     * Logs out the active user
     */
    @Override
    public void logout() {
        userManager.logout();
    }

    /**
     * Gets the active user in the system
     *
     * @return a IUser object
     */
    @Override
    public IUser getActiveUser() {
        return userManager.getActiveUser();
    }

    private Applicant getActiveApplicant(){
        return (Applicant) userManager.getActiveUser();
    }
    /**
     * Gets a boolean value of whether a user is logged in already
     *
     * @return true if a user is logged in, false if not.
     */
    @Override
    public boolean isLoggedIn() {
        return userManager.hasActiveUser();
    }

    @Override
    public List<IJobPost> getAllJobs() {
        return comm.getAllJobs();
    }

    @Override
    public IQuestionSet getAllQuestions() {
        return comm.getQuestionSet();
    }

    @Override
    public void setExperience(int exp) {
        getActiveApplicant().setExperience(exp);
    }

    @Override
    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        return comm.calculateScore(user, set);
    }

    /**
     * Used for the first application of a job. This is because, a user is required to fill a personality assessment the fist time, not any other times
     * @param user
     * @param job
     * @param set 
     */
    @Override
    public void saveApplication(IUser user, IJobPost job, IQuestionSet set) {
        comm.applyForJob(user, job, set);
    }

    /**
     * Used for any applications after the first one
     * @param user
     * @param job 
     */
    @Override
    public void saveApplication(IUser user, IJobPost job) {
        comm.applyForJob(user, job);
    }

    
    

}
