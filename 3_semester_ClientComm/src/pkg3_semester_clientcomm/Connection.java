/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_clientcomm;

import ProjectInterfaces.IComm;
import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import commondata.JobPost;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 * A connection to the server.
 *
 * @author Krongrah
 */
public class Connection {

    IComm icomm;
    /**
     * Port of the server.
     */
    private int port = 9001;
    /**
     * The IP of the server.
     */
    private String address = "10.123.3.31";

    /**
     * connects the connection to the server.
     *
     * @return returns true if the connection was successful.
     */
    public boolean Connect() {

        try {
            Registry r = LocateRegistry.getRegistry("localhost", port);
            icomm = (IComm) r.lookup("theJobConnect");
            return true;
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public IQuestionSet getQuestionSet() {
        try {
            return icomm.getQuestionSet();
        } catch (RemoteException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public IUser login(String username, String hashedPwd) {
        try {
            return icomm.login(username, hashedPwd);
        } catch (RemoteException ex) {
            System.out.println("Didnt log in");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        try {
            return icomm.calculateScore(user, set);
        } catch (RemoteException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<JobPost> getJobAllPosts(){

        try {
            return icomm.getJobAllPosts();
        } catch (RemoteException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void applyForJob(IUser user, IJobPost job) {
        try {
            icomm.applyForJob(user, job);
        } catch (RemoteException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet) {
        try {
            icomm.applyForJob(user, job, questionSet);
        } catch (RemoteException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}