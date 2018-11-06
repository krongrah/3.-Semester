/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mikkellarsen
 */
public interface IQueryHandler {

    public Connection connect();

    public ResultSet getUser(String username, String password);

    public ResultSet getQuestionSet();

    public ResultSet getApplicants(int id);

    public ResultSet getAllJobs();

    public void applyForJob(int jobPostId, int applicantId);

}
