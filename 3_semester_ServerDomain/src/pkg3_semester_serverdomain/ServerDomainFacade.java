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
import jobCalculation.*;
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
    
    private JobCalFacade jobCal;

    public ServerDomainFacade() {
        personal = new PersonalityFacade();
        jobCal = new JobCalFacade();
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
            //double score = jobCal.calculateScore(applicant, jobpost);
            persistence.applyForJob(jobpost.getId(), applicant.getUserId(), 0.0);
            getRankings(0, applicant, persistence);
            
    }

    @Override
    public void applyForJob(IJobPost job, IUser user, IQuestionSet questionSet) {
            //todo save personality answers in persistence
            persistence.applyForJob(job.getId(), user.getUserId(), 3.2);
    }

    @Override
    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        //todo, has yet to be implemented, and is not yet necessary;
        List<Integer> list = personal.calculateScore(set);
        setPersonalityAssessment(user, list);
        return list;
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

    @Override
    public List<Integer> getJobPrefScore(int jobPostId) {
        List<Integer> prefScore = new ArrayList<>();
        
        try {
            ResultSet rs = persistence.getJobPrefScore(jobPostId);
            
            while (rs.next()) {
                for (int i = 1; i < 11; i++) {
                    prefScore.add(rs.getInt(i));
                } 
            }
        } catch (SQLException e) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return prefScore;
    }

    @Override
    public void setPersonalityAssessment(IUser user, List<Integer> list) {
        StringBuilder score = new StringBuilder();
        int i;
        
        for (i = 0; i < (list.size() - 1); i++) {
            score.append(list.get(i) + ",");
        }
        score.append(list.get(i));
        
        persistence.setPersonalityAssessment(user, score.toString());
    }

    @Override
    public List<Integer> getPersonalityAssessment(IUser user) {
        List<Integer> list = new ArrayList<>();
        
        try {
            
            ResultSet rs = persistence.getPersonalityAssessment(user);
            while (rs.next()) {
                String[] ses = rs.getString(1).split(",");
                
                for (int i = 0; i < ses.length; i++) {
                    System.out.println(ses[i]);
                    list.add(Integer.parseInt(ses[i]));
                }
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getRankings(int jobPostId, IUser user, IServerPersistence isp) {
        return jobCal.getRankings(jobPostId, user, isp);
    }
}