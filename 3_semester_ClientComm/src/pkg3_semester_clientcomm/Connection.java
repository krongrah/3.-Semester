package pkg3_semester_clientcomm;

import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import commondata.JobPost;
import java.net.Socket;
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
class Connection {

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    /**
     * connects the client to the server and creates an object input and output
     * stream.
     */
    void Connect() throws InterruptedException {
        try {
            Socket socket = new Socket(IP, PORT);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sends the appropriate task object to the server, along with the relevant
     * arguments, and then waits for a response containing the expected return
     * object.
     * This pattern is repeated for all the methods below.
     *
     * @return
     */
    IQuestionSet getQuestionSet() {
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

    IUser login(String username, String hashedPwd) {
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

    List<Integer> calculateScore(IUser user, IQuestionSet set) {
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

    List<JobPost> getJobAllPosts() {
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

    void applyForJob(IUser user, IJobPost job) {
        try {
            outputStream.writeObject(new JobApplyTask(user, job));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet) {
        try {
            outputStream.writeObject(new JobApplyPersTask(user, job, questionSet));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void logout() {
        try {
            outputStream.writeObject(new LogOutTask());
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Integer> getPersonalityAssessment(IUser user) {
        try {
            outputStream.writeObject(new getPersonalityAssessmentTask(user));
            return (List<Integer>) inputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    int getRanking(IJobPost jobPost, IUser user) {
        try {
            outputStream.writeObject(new getRankingTask(jobPost, user));
            return (int) inputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
