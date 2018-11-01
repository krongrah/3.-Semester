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
    public ResultSet getUser(String username, String password) throws SQLException {
        Connection con = connect();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM \"Users\" WHERE \"Users\".Username = ? AND \"Users\".Password = ?");

        statement.setString(1, username);

        statement.setString(2, password);

        return statement.executeQuery();

    }

    @Override
    public ResultSet getQuestionSet() throws SQLException {
        Connection con = connect();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM PQuestionSet");
        
        return statement.executeQuery();
       
    }

    @Override
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);

    }
    
    @Override
    public ResultSet getCompanyUser(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void applyForJob(IJobPost jobpost, IUser applicant) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
