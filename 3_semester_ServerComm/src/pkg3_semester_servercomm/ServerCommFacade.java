/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.IServerComm;
import ProjectInterfaces.IServerDomain;

/**
 * This Facade represents the ServerCommunication, and allows other subsystems
 * to interact with it.
 *
 * @author Krongrah
 */
public class ServerCommFacade implements IServerComm {

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
        hub = new ServerHub();
        hub.start();
    }

}
