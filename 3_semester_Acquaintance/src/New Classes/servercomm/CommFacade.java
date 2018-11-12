/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servercomm;

import IncomingCommunication.InCommFacade;
import OutgoingCommunication.OutCommFacade;
import ServerInterfaces.IComm;
import ServerInterfaces.IDomain;

/**
 *
 * @author Krongrah
 */
public class CommFacade implements IComm{
    private IDomain domain;
    private InCommFacade inComm;
    private OutCommFacade outComm;
    
    public CommFacade(){
    inComm=new InCommFacade();
    outComm=new OutCommFacade();
    
    Thread t=new Thread(inComm);
    t.start();
    t.setDaemon(true);
    
    }

    @Override
    public void injectDomain(IDomain domain) {
        this.domain=domain;
        domain.injectOutComm(outComm);
        
    }
    


    
}
