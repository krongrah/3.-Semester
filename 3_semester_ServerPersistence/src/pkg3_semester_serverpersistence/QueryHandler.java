/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverpersistence;

import ProjectInterfaces.IQueryHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikkellarsen
 */
public class QueryHandler implements IQueryHandler {

    private String url;
    private String user;
    private String password;

    public QueryHandler(String URL, String user, String password) {

        this.url = URL;
        this.user = user;
        this.password = password;
    }

    @Override
    public ResultSet getUser(String username, String password) {
        try {
            Connection con = connect();
            PreparedStatement statement = con.prepareStatement("SELECT Users.Username, Users.IsCompany, Users.Email, Users.Phonenr, Users.Address, Users.Zipcode, Users.City, Users.Country, Users.Region, Users.UserId FROM Users, LogIn WHERE Users.Username = ? AND LogIn.hPassword = ?;");

            statement.setString(1, username);

            statement.setString(2, password);

            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getQuestionSet() {
        try {
            Connection con = connect();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Questions");

            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void applyForJob(int jobPostId, int applicantId) {
        try {
            Connection con = connect();
            PreparedStatement statement;

            String job = "Job" + jobPostId + "_applicants";

            statement = con.prepareStatement("INSERT INTO " + job + " VALUES (?)");
            statement.setInt(1, applicantId);
            statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet getAllJobs() {
        try {
            Connection con = connect();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM jobs, companyjobs, companyinfo WHERE jobs.id = companyjobs.job AND companyjobs.company = companyinfo.username");
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
