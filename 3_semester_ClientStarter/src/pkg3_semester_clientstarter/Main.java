package pkg3_semester_clientstarter;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientGui;
import GUI.GuiFacade;
import pkg3_semester.ClientDomainFacade;
import pkg3_semester_clientcomm.ClientCommFacade;

public class Main {

    public static void main(String[] args) {

        IClientGui gui = new GuiFacade();
        IClientDomain domain = new ClientDomainFacade();
        IClientComm comm = new ClientCommFacade();
        gui.injectdomain(domain);
        domain.injectClientComm(comm);
        System.out.println(domain.getAllQuestions().getQuestion(3).getQuestion());
        gui.start(args);

    }

}
