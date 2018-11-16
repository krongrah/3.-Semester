package pkg3_semester_clientstarter;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientGui;
import GUI.GuiFacade;
import pkg3_semester.ClientDomainFacade;
import pkg3_semester_clientcomm.ClientCommFacade;


/**
 * Starter for the client. Starts all processes in the client. 
 */
public class Main {

    public static void main(String[] args) {

        IClientGui gui = new GuiFacade();
        IClientDomain domain = new ClientDomainFacade();
        IClientComm comm = new ClientCommFacade();
        gui.injectdomain(domain);
        domain.injectClientComm(comm);
        gui.start(args);

    }

}
