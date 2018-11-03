/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * This Facade represents the ServerCommunication, and allows other subsystems
 * to interact with it.
 *
 * @author Krongrah
 */
public class ServerCommFacade extends UnicastRemoteObject implements IServerComm, IComm {

    public ServerCommFacade() throws RemoteException {
        Registry r = LocateRegistry.createRegistry(9001);
        IComm i = (IComm) this;
        r.rebind("rmi://localhost/theJob", i);
        System.out.println("Server is ready.");

    }

    /**
     * This is a reference to the domain layer beneath this Communications
     * layer.
     */
    private IServerDomain domain;

    /**
     * This injects a reference to the domain layer into this instance, so calls
     * can be made onto said domain layer.
     *
     * @param domain
     */
    @Override
    public void injectDomain(IServerDomain domain) {
        this.domain = domain;
    }

    @Override
    public IQuestionSet getQuestionSet() throws RemoteException  {
        return domain.getQuestionSet();
    }

    @Override
    public IUser login(String username, String hashedPwd) throws RemoteException {
        IUser i=domain.getUser(username, hashedPwd);
        return i;
    }

    @Override
    public List<Integer> calculateScore(IUser user, IQuestionSet set) throws RemoteException {
        return domain.calculateScore(user, set);
    }

    @Override
    public List<IJobPost> getJobAllPosts() throws RemoteException  {
       return domain.getAllJobs();
    }

    @Override
    public void applyForJob(IUser user, IJobPost job) throws RemoteException  {
        domain.applyForJob(job, user);
    }

    @Override
    public void applyForJob(IUser user, IJobPost job, IQuestionSet questionSet) throws RemoteException {
       domain.applyForJob(job, user, questionSet);
    }

}
