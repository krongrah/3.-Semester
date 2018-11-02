/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_clientcomm;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IJobPost;
import ProjectInterfaces.IQuestionSet;
import ProjectInterfaces.IUser;
import java.util.List;

/**
 * is responsible for the communication between all client communication to the
 * server
 */
public class ClientCommFacade implements IClientComm {

    /**
     * Logs in the given user
     *
     * @param username
     * @param hashedPwd
     * @return An object of the type IUser
     */
    @Override
    public IUser login(String username, String hashedPwd) {
        connectToServer();
        return connection.login(username, hashedPwd);
    }

    /**
     * The reference to the connection.
     */
    private Connection connection;

    /**
     * Connects the connection to the server.
     *
     * @return returns true if the connection was successful.
     */
    @Override
    public boolean connectToServer() {
        connection = new Connection();
        return connection.Connect();
    }

    @Override
    public List<IJobPost> getAllJobs() {
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
    public List<IJobPost> getJobAllPosts() {
      return connection.getJobAllPosts();
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
