/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.IServerComm;
import ProjectInterfaces.IServerDomain;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class ServerCommFacade implements Runnable, IServerComm {

    private ServerSocket serv;
    private List<Service> threadPool;
    private IServerDomain domain;

    public ServerCommFacade() {
        try {
            serv = new ServerSocket();
            threadPool = new ArrayList();
        } catch (IOException ex) {
            Logger.getLogger(ServerCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        
        Thread timeout = new Thread(new TimeoutThread(threadPool));
        timeout.start();
        timeout.setDaemon(true);
        
        while (true) {
            try {
                
                Service service = new Service(serv.accept());
                threadPool.add(service);
                Thread t = new Thread(service);
                t.start();
                t.setDaemon(true);

            } catch (IOException ex) {
                Logger.getLogger(ServerCommFacade.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void injectDomain(IServerDomain domain) {
       this.domain=domain;
    }

}
