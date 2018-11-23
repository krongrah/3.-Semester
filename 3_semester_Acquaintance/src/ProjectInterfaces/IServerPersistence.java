/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.sql.ResultSet;
import java.util.List;

/**
 * The interface for Server Persistence
 *
 * @author Krongrah
 */
public interface IServerPersistence {

    public ResultSet getUser(String username, String password);

    public ResultSet getQuestionSet();

    public ResultSet getAllJobs();

    public void applyForJob(int jobPostId, int applicantId, double jobScore);

    public IUser login(String username, String hashedPwd);
    
    public ResultSet getJobPrefScore(int jobPostId);
    
    public void setPersonalityAssessment(IUser user, String score);
    
    public ResultSet getPersonalityAssessment(IUser user);

    public ResultSet getApplicants(int jobPostId);
        
    public void setUserExp(int uExperience, int jobPostId, int userId);
    
    public int getPrefExp(int jobPostId);
    
    public int getExpWeight(int jobPostId);
    
    public void setUser(String fullName, String mail, String phonenr, String address, String country, String region, String city, String zipCode, String gender, String username, String password);

}
