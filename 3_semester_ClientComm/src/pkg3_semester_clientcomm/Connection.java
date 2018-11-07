package pkg3_semester_clientcomm;

import ProjectInterfaces.IComm;
import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import commondata.JobPost;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SealedObject;

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
    //private String address = "10.123.3.31";
    private String address = "localhost";

    /**
     * connects the connection to the server.
     */
    public void Connect() {

        try {
            icomm = (IComm) LocateRegistry.getRegistry(address, port).lookup("theJobConnect");
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public IQuestionSet getQuestionSet() {
        try {
            return icomm.getQuestionSet();
        } catch (RemoteException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public SealedObject login(String username, String hashedPwd) {
        SealedObject seal = null;
        try {
            seal = icomm.login(username, hashedPwd);
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seal;
    }

    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        try {
            return icomm.calculateScore(user, set);
        } catch (RemoteException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<JobPost> getJobAllPosts() {

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
