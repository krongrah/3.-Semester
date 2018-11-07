package pkg3_semester_serverdomain;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IServerDomain;
import ProjectInterfaces.IServerPersistence;
import ProjectInterfaces.IUser;
import commondata.JobPost;
import commondata.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import personalityAssessment.*;

/**
 * Facade for the ServerDomain
 *
 * @author Krongrah
 */
public class ServerDomainFacade implements IServerDomain {

    //private ServerDomainFacade serverdomain;
    /**
     * The interface for the server persistence
     */
    private IServerPersistence persistence;

    private PersonalityFacade personal;

    public ServerDomainFacade() {
        personal = new PersonalityFacade();
    }

    /**
     * Inject method for persistence Injects ServerPersistence into
     * ServerDomainFacade
     *
     * @param persistence
     */
    @Override
    public void injectPersistence(IServerPersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public IUser getUser(String username, String password) {
        try {
                return new User(persistence.getUser(username, password));
        } catch (SQLException ex) {
            System.out.println("Didnt login (server Domain error)");
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public IQuestionSet getQuestionSet() {
        try {
            return personal.getQuestionSet(persistence.getQuestionSet());
        } catch (Exception e) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public IUser login(String username, String hashedPwd) {
        return persistence.login(username, hashedPwd);
    }

    @Override
    public void applyForJob(IJobPost jobpost, IUser applicant) {
            persistence.applyForJob(jobpost.getId(), applicant.getUserId());
    }

    @Override
    public void applyForJob(IJobPost job, IUser user, IQuestionSet questionSet) {
            //todo save personality answers in persistence
            persistence.applyForJob(job.getId(), user.getUserId());
    }

    @Override
    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        //todo, has yet to be implemented, and is not yet necessary;
        return personal.calculateScore(set);
    }

    @Override
    public List<JobPost> getAllJobs() {
        List<JobPost> jobs = new ArrayList();
        try {
            ResultSet rs = persistence.getAllJobs();
            while (rs.next()) {
                jobs.add(new JobPost(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jobs;
    }
}