/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.IServerComm;
import ProjectInterfaces.IServerDomain;
import Tasks.Task;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class ServerCommFacade implements IServerComm, IThreadPool {

    private ServerSocket serv;
    private List<Service> ServiceList;
    private IServerDomain domain;
    private ExecutorService tasks;

    public ServerCommFacade() {
        try {
            serv = new ServerSocket();
            ServiceList = new ArrayList();
            tasks = Executors.newCachedThreadPool();
        } catch (IOException ex) {
            Logger.getLogger(ServerCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start() {
        Thread timeout = new Thread(new TimeoutThread(ServiceList));
        timeout.start();
        timeout.setDaemon(true);

        while (true) {
            try {

                Service service = new Service(serv.accept(), domain);
                ServiceList.add(service);
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
        this.domain = domain;
    }

    @Override
    public void execute(Task task) {
       tasks.execute(task);
    }

}
