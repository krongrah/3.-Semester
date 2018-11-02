/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverpersistence;

import ProjectInterfaces.IQueryHandler;
import ProjectInterfaces.IServerPersistence;
import ProjectInterfaces.IUser;
import commondata.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The facade of the server persistence
 *
 * @author Krongrah
 */
public class PersistenceFacade implements IServerPersistence {

    private String url = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk/si3_2018_group_5_db";
    private String user = "si3_2018_group_5";
    private String password = "taint76;perl";

    private IQueryHandler handler = new QueryHandler(url, user, password);

    @Override
    public ResultSet getUser(String username, String password) throws SQLException {
        return handler.getUser(username, password);
    }

    @Override
    public ResultSet getQuestionSet() throws SQLException {
        return handler.getQuestionSet();
    }

    @Override
    public ResultSet getApplicants(int id) throws SQLException {
        return handler.getApplicants(id);
    }

    @Override
    public ResultSet getAllJobs() throws SQLException {
        return handler.getAllJobs();
    }

    @Override
    public ResultSet getCompanyUser(int i) throws SQLException {
        return handler.getCompanyUser(i);
    }

    /**
     *
     * @param jobpost
     * @param applicant
     * @throws SQLException
     */
    @Override
    public void applyForJob(int jobPostId, int applicantId) throws SQLException {
        handler.applyForJob(jobPostId, applicantId);
    }

    //Database tester
    public static void main(String[] args) {
        PersistenceFacade pf = new PersistenceFacade();

        try {
            ResultSet rs = pf.getQuestionSet();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public IUser login(String username, String hashedPwd) {
        try {
            IUser user = new User(handler.getUser(username, hashedPwd));
            return user;

        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
