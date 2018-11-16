/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import commondata.JobPost;
import java.util.List;

/**
 * The interface for the Client communication
 *
 * @author Krongrah
 */
public interface IClientComm {

    public IUser login(String username, String hashedPwd);

    /**
     * Connects the client to the server
     */
    public void connectToServer();

    public List<JobPost> getAllJobs();

    public IQuestionSet getQuestionSet();

    /**
     * Calculates the personality score 
     * @param user
     * @param set
     * @return list of integer.
     */
    public List<Integer> calculateScore(IUser user, IQuestionSet set);
    
    /**
     * Adds a user to job post
     * @param user
     * @param job
     */
    public void applyForJob(IUser user, IJobPost job);

    /**
     * 
     * @param user
     * @param job
     * @param questionSet
     */
    public void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet);

    public void logout();
    
    public List<Integer> getPersonalityAssessment(IUser user);
    
    public int getRanking(IJobPost jobPost, IUser user);
}
