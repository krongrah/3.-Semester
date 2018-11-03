/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverdomain;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IServerDomain;
import ProjectInterfaces.IServerPersistence;
import ProjectInterfaces.IUser;
import commondata.Applicant;
import commondata.Company;
import commondata.JobPost;
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
        //return new Applicant("",1,"",false,"",1,"",1,"","","","","");
        try {
            ResultSet set = persistence.getUser(username, password);
            if (set.getBoolean("iscompany")) {
                return new Company(set);
            } else {
                return new Applicant(set);
            }
        } catch (SQLException ex) {
            System.out.println("Didnt login (server Domain error)");
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        //Missing return value: No User found (To be specified)
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
    public void applyForJob(IJobPost jobpost, IUser applicant) {
        try {
            persistence.applyForJob(jobpost.getId(), applicant.getUserId());
        } catch (SQLException ex) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void applyForJob(IJobPost job, IUser user, IQuestionSet questionSet) {
        try {
            //todo save personality answers in persistence
            persistence.applyForJob(job.getId(), user.getUserId());
        } catch (SQLException ex) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        //todo, has yet to be implemented, and is not yet necessary;
        //int[] i = personal.calculateScore(u);
        return null;
        
    }

    @Override
    public List<IJobPost> getAllJobs() {
        List<IJobPost> ijps = new ArrayList<>();
        
        try {
            ResultSet rs = persistence.getAllJobs();
            
            while (rs.next()) {
                ijps.add(new JobPost(rs.getInt("jobs.id"), rs.getString("jobs.title"), rs.getString("jobs.description"), rs.getString("companyinfo.companyname"), rs.getString("companyinfo.website"))); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(ijps.size());
        return ijps;

    }

    }


