package pkg3_semester_clientcomm;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import commondata.JobPost;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static commondata.Constants.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Tasks.*;

/**
 * A connection to the server.
 *
 * @author Krongrah
 */
public class Connection {

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    /**
     * connects the connection to the server.
     */
    public void Connect() {
        try {
            Socket socket = new Socket(IP, PORT);
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public IQuestionSet getQuestionSet() {
        try {
            outputStream.writeObject(new QuestionSetTask());
            return (IQuestionSet) inputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public IUser login(String username, String hashedPwd) {
        try {
            outputStream.writeObject(new LoginTask(username, hashedPwd));
            return (IUser) inputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        try {
            outputStream.writeObject(new CalculateScoreTask(user, set));
            return (List<Integer>) inputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<JobPost> getJobAllPosts() {
        try {
            outputStream.writeObject(new AllJobsTask());
            return (List<JobPost>) inputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void applyForJob(IUser user, IJobPost job) {
        try {
            outputStream.writeObject(new JobApplyTask(user, job));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet) {
        try {
            outputStream.writeObject(new JobApplyPersTask(user, job, questionSet));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
