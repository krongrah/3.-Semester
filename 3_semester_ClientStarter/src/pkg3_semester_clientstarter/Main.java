/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_clientstarter;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientGui;
import pkg3_semester_clientgui.GuiFacade;
import pkg3_semester.ClientDomainFacade;
import pkg3_semester_clientcomm.ClientCommFacade;

/**
 *
 * Starts the all the progesses in the client
 * 
 * And starts the GUIFacade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IClientGui gui = new GuiFacade();
        IClientDomain domain = new ClientDomainFacade();
        IClientComm comm = new ClientCommFacade();
        gui.injectdomain(domain);
        domain.injectClientComm(comm);
        gui.start(args);

    }

}
