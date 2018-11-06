/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import commondata.JobPost;
import java.util.List;

/**
 * The interface for the Client communication
 *
 * @author Krongrah
 */
public interface IClientComm {

    public IUser login(String username, String hashedPwd);

    /**
     * Connects the client to the server.
     *
     * @return returns true if the connection was successful.
     */
    public boolean connectToServer();

    public List<JobPost> getAllJobs();

    public IQuestionSet getQuestionSet();

    public List<Integer> calculateScore(IUser user, IQuestionSet set);

    public void applyForJob(IUser user, IJobPost job);

    public void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet);
}
