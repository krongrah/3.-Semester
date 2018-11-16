/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author mikkellarsen
 */
public interface IQueryHandler {

    public Connection connect();

    public ResultSet getUser(String username, String password);

    public ResultSet getQuestionSet();

    public ResultSet getAllJobs();

    public void applyForJob(int jobPostId, int applicantId, double jobScore);
    
    public ResultSet getJobPrefScore(int jobPostId);
    
    public ResultSet getApplicants(int jobPostId);
    
    public void setPersonalityAssessment(IUser user, String score);
    
    public ResultSet getPersonalityAssessment(IUser user);
    
    public void setUserExp(int uExperience, int jobPostId, int userId);
    
    public ResultSet getPrefExp(int jobPostId);
    
    public ResultSet getUserExp(int userId, int jobPostId);
    
    public ResultSet getExpWeight(int jobPostId);

}
