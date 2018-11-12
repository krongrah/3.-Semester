package pkg3_semester_clientcomm;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import commondata.JobPost;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * is responsible for the communication between all client communication to the
 * server
 */
public class ClientCommFacade implements IClientComm {

    /**
     * The reference to the connection.
     */
    private Connection connection;

    public ClientCommFacade() {
        connectToServer();
    }

    /**
     * Logs in the given user
     *
     * @param username
     * @param hashedPwd
     * @return An object of the type IUser
     */
    @Override
    public IUser login(String username, String hashedPwd) {
        return connection.login(username, hashedPwd);
    }

    /**
     * Connects the connection to the server.
     */
    @Override
    public final void connectToServer() {
        try {
            connection = new Connection();
            connection.Connect();
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<JobPost> getAllJobs() {
        return connection.getJobAllPosts();
    }

    @Override
    public IQuestionSet getQuestionSet() {
        return connection.getQuestionSet();
    }

    @Override
    public List<Integer> calculateScore(IUser user, IQuestionSet set) {
        return connection.calculateScore(user, set);
    }

    @Override
    public void applyForJob(IUser user, IJobPost job) {
        connection.applyForJob(user, job);
    }

    @Override
    public void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet) {
        connection.applyForJob(user, job, questionSet);
    }

}
