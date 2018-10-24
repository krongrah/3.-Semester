/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverstarter;

import ProjectInterfaces.IServerComm;
import ProjectInterfaces.IServerDomain;
import ProjectInterfaces.IServerPersistence;
import pkg3_semester_servercomm.ServerCommFacade;
import pkg3_semester_serverdomain.ServerDomainFacade;
import pkg3_semester_serverpersistence.PersistenceFacade;

/**
 * Starter for the Server.
 * Starts all processes in the Server.
 * Injects the domain in the ServerCommFacade and the persistance in the ServerDomainFacade.
 * 
 * @author Krongrah
 */
public class Main {

    /**
     * Main method is invoked when the Server is starting
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        IServerComm comm = new ServerCommFacade();
        IServerDomain domain = new ServerDomainFacade();
        IServerPersistence persistence = new PersistenceFacade();
        comm.injectDomain(domain);
        domain.injectPersistence(persistence);
        comm.startServer();
    }

}
