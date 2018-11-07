package pkg3_semester_clientcomm;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import commondata.JobPost;
import java.io.Serializable;
import java.util.List;
import javax.crypto.SealedObject;

/**
 * is responsible for the communication between all client communication to the
 * server
 */
public class ClientCommFacade implements IClientComm {
    
    //Test

    /**
     * Logs in the given user
     *
     * @param username
     * @param hashedPwd
     * @return An object of the type IUser
     */
    @Override
    public SealedObject login(String username, String hashedPwd) {
        connectToServer();
        return connection.login(username, hashedPwd);
    }

    /**
     * The reference to the connection.
     */
    private Connection connection;

    /**
     * Connects the connection to the server.
     */
    @Override
    public void connectToServer() {
        connection = new Connection();
        connection.Connect();
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
