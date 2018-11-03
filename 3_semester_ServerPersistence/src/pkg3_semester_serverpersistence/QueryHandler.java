/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverpersistence;

import ProjectInterfaces.IJobPost;
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

    public static void main(String[] args) {
        try {
            System.out.println("Trying");
            new QueryHandler("jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk/si3_2018_group_5_db", "si3_2018_group_5", "taint76;perl").getAllJobs();
        } catch (SQLException ex) {
            Logger.getLogger(QueryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String url;
    private String user;
    private String password;

    public QueryHandler(String URL, String user, String password) {

        this.url = URL;
        this.user = user;
        this.password = password;
    }

    @Override
    public ResultSet getUser(String username, String password) throws SQLException {
        Connection con = connect();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Users, LogIn WHERE Users.Username = ? AND LogIn.hPassword = ?"); //Users.Username, Users.IsCompany, Users.Email, Users.Phonenr, Users.Address, Users.Zipcode, Users.City, Users.Country, Users.Region, Users.UserId FROM Users, LogIn WHERE Users.Username = ? AND LogIn.hPassword = ?;");

        statement.setString(1, username);

        statement.setString(2, password);

        return statement.executeQuery();

    }

    @Override
    public ResultSet getQuestionSet() throws SQLException {
        Connection con = connect();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM Questions");

        return statement.executeQuery();

    }

    @Override
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);

    }

    @Override
    public ResultSet getCompanyUser(int id) throws SQLException {
        Connection con = connect();
        PreparedStatement statement;

        statement = con.prepareStatement("SELECT Users.Username, Users.UserId, companyinfo.companyname, companyinfo.website, Users.Email, Users.Phonenr, Users.Address, Users.Zipcode, Users.City, Users.Country, Users.Region FROM Users, companyinfo WHERE IsCompany = TRUE AND Users.Username = companyinfo.username AND Users.UserId = ?;");
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    @Override
    public void applyForJob(int jobPostId, int applicantId) throws SQLException {
        Connection con = connect();
        PreparedStatement statement;

        String job = "Job" + jobPostId + "_applicants";

        statement = con.prepareStatement("INSERT INTO " + job + " VALUES (?)");
        statement.setInt(1, applicantId);
        statement.executeQuery();
    }

    @Override
    public ResultSet getApplicants(int id) throws SQLException {

        Connection con = connect();
        PreparedStatement statement;

        String job = "job" + id + "_applicants";

        statement = con.prepareStatement("SELECT * FROM " + job);

        return statement.executeQuery();
    }

    @Override
    public ResultSet getAllJobs() throws SQLException {
        Connection con = connect();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM jobs");

        ResultSet rs = statement.executeQuery();

        System.out.println(rs.getInt(0));
        System.out.println(rs.getString(1));
        System.out.println(rs.getString(2));
        System.out.println("");

        return rs;
    }

}
