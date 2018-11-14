/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import commondata.JobPost;
import java.sql.ResultSet;
import java.util.List;

/**
 * The interface for the Server Domain
 *
 * @author Krongrah
 */
public interface IServerDomain {

    /**
     * The method for injecting the Server Persistence interface
     *
     * @param persistence
     */
    public void injectPersistence(IServerPersistence persistence);

    public IUser getUser(String username, String password);

    public IQuestionSet getQuestionSet();

    public void applyForJob(IJobPost jobpost, IUser applicant);

    public void applyForJob(IJobPost job, IUser user, IQuestionSet questionSet);

    public IUser login(String username, String hashedPwd);

    public List<Integer> calculateScore(IUser user, IQuestionSet set);

    public List<JobPost> getAllJobs();
    
    public List<Integer> getJobPrefScore(int jobPostId);
    
    public void setPersonalityAssessment(IUser user, List<Integer> list);
    
    public List<Integer> getPersonalityAssessment(IUser user);
    
    public int getRankings(int jobPostId, IUser user);

}
