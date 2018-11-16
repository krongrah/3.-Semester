package pkg3_semester_serverpersistence;

import ProjectInterfaces.IQueryHandler;
import ProjectInterfaces.IServerPersistence;
import ProjectInterfaces.IUser;
import commondata.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
    public ResultSet getUser(String username, String password) {
        return handler.getUser(username, password);
    }

    @Override
    public ResultSet getQuestionSet() {
        return handler.getQuestionSet();
    }

    @Override
    public ResultSet getAllJobs() {
        return handler.getAllJobs();
    }

    /**
     *
     * @param jobPostId
     * @param applicantId
     */
    @Override
    public void applyForJob(int jobPostId, int applicantId, double jobScore) {
        handler.applyForJob(jobPostId, applicantId, jobScore);
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

    @Override
    public ResultSet getJobPrefScore(int jobPostId) {
        return handler.getJobPrefScore(jobPostId);
    }
    
    @Override
    public void setPersonalityAssessment(IUser user, String score) {
        handler.setPersonalityAssessment(user, score);
    }

    @Override
    public ResultSet getPersonalityAssessment(IUser user) {
        return handler.getPersonalityAssessment(user);
    }

    @Override
    public ResultSet getApplicants(int jobPostId) {
        return handler.getApplicants(jobPostId);
    }

    @Override
    public void setUserExp(int uExperience, int jobPostId) {
        handler.setUserExp(uExperience, jobPostId);
    }

    @Override
    public int getPrefExp(int jobPostId) {
        try {
            ResultSet rs = handler.getPrefExp(jobPostId);
            
            while (rs.next()) {
                return rs.getInt(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getExpWeight(int jobPostId) {
        try {
            ResultSet rs = handler.getExpWeight(jobPostId);
            
            while (rs.next()) {
                return  rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
