/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IncomingCommunication;

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
public class InCommFacade implements Runnable {

    private ServerSocket serv;
    private List<Service> threadPool;
    private CommandInterpreter command;

    public InCommFacade() {
        try {
            serv = new ServerSocket();
            threadPool = new ArrayList();
            command=new CommandInterpreter();
        } catch (IOException ex) {
            Logger.getLogger(InCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        
        Thread timeout = new Thread(new TimeoutThread(threadPool));
        timeout.start();
        timeout.setDaemon(true);
        
        while (true) {
            try {
                
                Service service = new Service(serv.accept(), command);
                threadPool.add(service);
                Thread t = new Thread(service);
                t.start();
                t.setDaemon(true);

            } catch (IOException ex) {
                Logger.getLogger(InCommFacade.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
