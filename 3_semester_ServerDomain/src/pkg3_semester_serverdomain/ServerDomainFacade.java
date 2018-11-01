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
import UserSystem.Applicant;
import UserSystem.Company;
import UserSystem.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import personalityAssessment.*;

/**
 *Facade for the ServerDomain
 * @author Krongrah
 */
public class ServerDomainFacade implements IServerDomain {

    ServerDomainFacade serverdomain;
    /**
     * The interface for the server persistence
     */
    IServerPersistence persistence;

    
    /**
     * Inject method for persistence 
     * Injects ServerPersistence into ServerDomainFacade
     * @param persistence 
     */
    @Override
    public void injectPersistence(IServerPersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public IUser getUser(String username, String password) {
        try {
            ResultSet set = persistence.getUser(username, password);
            
            if(set.getBoolean("IsCompany")){
                return new Company(set);
            }else{
                return new Applicant(set);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        //Missing return value: No User found (To be specified)
    }

    @Override
    public IQuestionSet getQuestionSet() {
        
        try {
            return new QuestionSet(persistence.getQuestionSet());
        } catch (Exception e) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

@Override
    public IUser getCompanyUser(int i) {
        try {
            return new User(persistence.getComapnyUser(i));
        } catch (SQLException ex) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public IServerDomain getInstance() {
        if(this.serverdomain==null){
            serverdomain = new ServerDomainFacade();
        }
        return serverdomain;
    }


    @Override
    public void applyForJob(IJobPost jobpost, IUser applicant) {
        try {
            persistence.applyForJob(jobpost, applicant);
        } catch (SQLException ex) {
            Logger.getLogger(ServerDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public IUser login(String username, String hashedPwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] calculateScore(IUser user, IQuestionSet set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IJobPost> getAllJobs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
