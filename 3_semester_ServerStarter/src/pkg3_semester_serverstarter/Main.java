/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverstarter;

import ProjectInterfaces.IServerComm;
import ProjectInterfaces.IServerDomain;
import ProjectInterfaces.IServerPersistence;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg3_semester_servercomm.ServerCommFacade;
import pkg3_semester_serverdomain.ServerDomainFacade;
import pkg3_semester_serverpersistence.PersistenceFacade;

/**
 * Starter for the Server. Starts all processes in the Server. Injects the
 * domain in the ServerCommFacade and the persistence in the ServerDomainFacade.
 *
 * @author Krongrah
 */
public class Main {

    public static void main(String[] args) {
            IServerComm comm = new ServerCommFacade();
            IServerDomain domain = new ServerDomainFacade();
            IServerPersistence persistence = new PersistenceFacade();
            comm.injectDomain(domain);
            domain.injectPersistence(persistence);
            comm.start();
    }

}
