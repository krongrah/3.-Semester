/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The interface for Server Persistence
 * @author Krongrah
 */
public interface IServerPersistence {

    public ResultSet getUser(String username, String password) throws SQLException;
    
    public ResultSet getQuestionSet() throws SQLException;
    
    public ResultSet getApplicants() throws SQLException;
    
    public ResultSet getJobs() throws SQLException;
    
    public ResultSet getCompanyUser(int i) throws SQLException;
    
    public void applyForJob(int jobPostId, int applicantId) throws SQLException;
}
