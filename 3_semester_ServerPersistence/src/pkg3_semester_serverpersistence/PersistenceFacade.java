/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverpersistence;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQueryHandler;
import ProjectInterfaces.IServerPersistence;
import ProjectInterfaces.IUser;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The facade of the server persistence
 * @author Krongrah
 */
public class PersistenceFacade implements IServerPersistence {

    private String url = "si3_2018_group_5_db";
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
    public ResultSet getComapnyUser(int i) throws SQLException {
        return handler.getCompanyUser(i);
    }

    /**
     *
     * @param jobpost
     * @param applicant
     * @throws SQLException
     */
    @Override
    public void applyForJob(IJobPost jobpost, IUser applicant) throws SQLException {
        handler.applyForJob(jobpost, applicant);
    }




    


}
