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
import java.io.Serializable;
import javax.crypto.SealedObject;

/**
 * A connection to the server.
 *
 * @author Krongrah
 */
class Connection {

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Security security;

    /**
     * connects the client to the server and creates an object input and output
     * stream.
     */
    void Connect() throws InterruptedException {
        try {
            security = new Security();
            Socket socket = new Socket(IP, PORT);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            security.setPublicKey(inputStream.readObject());
            outputStream.writeObject(security.sendSecretKey());

        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sends the appropriate task object to the server, along with the relevant
     * arguments, and then waits for a response containing the expected return
     * object. This pattern is repeated for all the methods below.
     *
     * @return
     */
    IQuestionSet getQuestionSet() {
        sendTask(new QuestionSetTask());
        return (IQuestionSet) recieveResponse();
    }

    IUser login(String username, String hashedPwd) {
        sendTask(new LoginTask(username, hashedPwd));
        return (IUser) recieveResponse();
    }

    List<Integer> calculateScore(IUser user, IQuestionSet set) {
        sendTask(new CalculateScoreTask(user, set));
        return (List<Integer>) recieveResponse();
    }

    List<JobPost> getJobAllPosts() {
        sendTask(new AllJobsTask());
        return (List<JobPost>) recieveResponse();
    }

    void applyForJob(IUser user, IJobPost job) {
        sendTask(new JobApplyTask(user, job));
    }

    void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet) {
        sendTask(new JobApplyPersTask(user, job, questionSet));
    }

    void logout() {
        try {
            outputStream.writeObject(new LogOutTask());
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Integer> getPersonalityAssessment(IUser user) {
        sendTask(new PersonalityAssessmentTask(user));
        return (List<Integer>) recieveResponse();
    }

    private void sendTask(Task task) {
        try {
            outputStream.writeObject(security.encryptObject(task));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Serializable recieveResponse() {
        try {
            return security.decryptObject((SealedObject) inputStream.readObject());
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    int getRanking(IJobPost jobPost, IUser user) {
        sendTask(new RankingTask(jobPost, user));
        return (int) recieveResponse();
    }
}
