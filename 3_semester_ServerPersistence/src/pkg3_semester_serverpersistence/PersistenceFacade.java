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
            //ResultSet rs = pf.getQuestionSet();
            //ResultSet rs = pf.getUser("Test", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");

            ResultSet rs = pf.getUser("Test", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
            //IUser user = pf.login("Test", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4");
            System.out.println();
            //System.out.println(user.getUsername() + " " + user.getEmail());
            
//            while(rs.next()) {
//                System.out.println(rs.getString(1) + " " + rs.getBoolean(2));
//        }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    

}
