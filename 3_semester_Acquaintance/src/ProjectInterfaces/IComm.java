/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Krongrah
 */
public interface IComm extends Remote {

    //todo add methods calls going to the server
    public IQuestionSet getQuestionSet() throws RemoteException;

    public IUser login(String username, String hashedPwd) throws RemoteException;

    public List<Integer> calculateScore(IUser user, IQuestionSet set) throws RemoteException;

    public List<IJobPost> getJobAllPosts() throws RemoteException;

    public void applyForJob(IUser user, IJobPost job) throws RemoteException;

    public void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet) throws RemoteException;

}
