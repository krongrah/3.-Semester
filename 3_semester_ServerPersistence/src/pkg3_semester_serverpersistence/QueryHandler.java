/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverpersistence;

import ProjectInterfaces.IQueryHandler;
import ProjectInterfaces.IUser;
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
    public synchronized void applyForJob(int jobPostId, int applicantId, double jobScore) {
        try {
            Connection con = connect();
            PreparedStatement statement;

            String job = "Job" + jobPostId + "_applicants";
            String jobUserId = "job" + jobPostId + "_user_id";

            //statement = con.prepareStatement("INSERT INTO " + job + " VALUES (?, ?)");
            statement = con.prepareStatement("UPDATE " + job + " SET \"pscore\" = ? WHERE " + jobUserId + " = ?");
            
            statement.setDouble(1, jobScore);
            statement.setInt(2, applicantId);
            statement.execute();
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

    @Override
    public ResultSet getJobPrefScore(int jobPostId) {
        try {
            Connection con = connect();
            PreparedStatement statement = con.prepareStatement("SELECT prefscore1, prefscore2, prefscore3, prefscore4, prefscore5, prefscore6, prefscore7, prefscore8, prefscore9, prefscore10 FROM jobs WHERE id = ?");
            statement.setInt(1, jobPostId);
            
            return statement.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public ResultSet getApplicants(int jobPostId) {
        try {
            Connection con = connect();
            
            String job = "Job" + jobPostId + "_applicants";
            
            PreparedStatement statement = con.prepareStatement("SELECT * FROM " + job + " ORDER BY pscore;");
            
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public synchronized void setPersonalityAssessment(IUser user, String score) {        
        try {
            Connection con = connect();
            
            PreparedStatement statement = con.prepareStatement("UPDATE Users SET \"personalityassessment\" = ? WHERE UserId = ?;");
            
            statement.setString(1, score);
            statement.setInt(2, user.getUserId());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ResultSet getPersonalityAssessment(IUser user) {
        try {
            Connection con = connect();
            
            PreparedStatement statement = con.prepareStatement("SELECT personalityAssessment FROM Users WHERE userid = ?");
            
            statement.setInt(1, user.getUserId());
            
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getPrefExp(int jobPostId) {
        try {
            Connection con = connect();
            
            PreparedStatement statement = con.prepareStatement("SELECT prefexperience FROM jobs WHERE id = ?;");
            
            statement.setInt(1, jobPostId);
            
            return statement.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getUserExp(int userId, int jobPostId) {
        try {
            Connection con = connect();
            
            String job = "Job" + jobPostId + "_applicants";
            String jobUserId = "job" + jobPostId + "_user_id";
            
            PreparedStatement statement = con.prepareStatement("SELECT uexperience FROM " + job + " WHERE " + jobUserId + " = ?;");
            
            statement.setInt(1, userId);
            
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setUserExp(int experience, int jobPostId, int userId) {
        try {
            Connection con = connect();
            
            String job = "Job" + jobPostId + "_applicants";
            String jobUserId = "job" + jobPostId + "_user_id";
            
            PreparedStatement statement = con.prepareStatement("UPDATE " + job + " SET \"uexperience\" = ? WHERE " + jobUserId + " = ?;");
            
            statement.setInt(1, experience);
            statement.setInt(2, userId);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet getExpWeight(int jobPostId) {
        try {
            Connection con = connect();
            
            PreparedStatement statement = con.prepareStatement("SELECT experienceweight FROM jobs WHERE id = ?;");
            
            statement.setInt(1, jobPostId);
            
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setUser(String fullName, String mail, int phonenr, String address, String country, String region, String city, String zipCode, String gender, String username, String password) {
        try {
            Connection con = connect();
            
            PreparedStatement statement = con.prepareStatement("INSERT INTO Users (Username, IsCompany, Email, Phonenr, Address, Zipcode, Country, Region, City) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); INSERT INTO LogIn VALUES (?, ?);");
            
            statement.setString(1, username);
            statement.setBoolean(2, false);
            statement.setString(3, mail);
            statement.setInt(4, phonenr);
            statement.setString(5, address);
            statement.setString(6, zipCode);
            statement.setString(7, country);
            statement.setString(8, region);
            statement.setString(9, city);
            statement.setString(10, username);
            statement.setString(11, password);
            
            statement.execute();    
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
