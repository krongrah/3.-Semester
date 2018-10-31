/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Facade represents the ServerCommunication, and allows other subsystems
 * to interact with it.
 *
 * @author Krongrah
 */
public class ServerCommFacade extends UnicastRemoteObject implements IServerComm, IComm {

    public ServerCommFacade()throws RemoteException{
    }
    
    /**
     * This is a reference to the domain layer beneath this Communications
     * layer.
     */
    private IServerDomain domain;
    /**
     * This is the server hub that new clients connect to, and which assigns
     * them a dedicated thread.
     */
    private ServerHub hub;

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

    /**
     * This method instantiates the server hub, and then starts it, thus
     * allowing clients to connect.
     */
    @Override
    public void startServer() {
//        hub = new ServerHub();
//        hub.start();
    }
    
    @Override
    public IQuestionSet getQuestionSet() {
        return domain.getQuestionSet();
    }


}
