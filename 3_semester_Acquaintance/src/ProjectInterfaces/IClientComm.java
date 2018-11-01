/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.rmi.RemoteException;
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

    public List<IJobPost> getAllJobs();

    public IQuestionSet getQuestionSet();

    public int[] calculateScore(IUser user, IQuestionSet set);

    public List<IJobPost> getJobAllPosts();

    public void applyForJob(IUser user, IJobPost job);
}
