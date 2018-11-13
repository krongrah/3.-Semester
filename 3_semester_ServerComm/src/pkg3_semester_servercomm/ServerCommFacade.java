/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.IServerComm;
import ProjectInterfaces.IServerDomain;
import Tasks.Task;
import static commondata.Constants.PORT;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class ServerCommFacade implements IServerComm, IExecutor {

    private IServerDomain domain;
    private ServerSocket serv;
    private ExecutorService Services;
    private ExecutorService tasks;

    public ServerCommFacade() {
        try {
            serv = new ServerSocket(PORT);
            Services = Executors.newCachedThreadPool();
            tasks = Executors.newCachedThreadPool();
        } catch (IOException ex) {
            Logger.getLogger(ServerCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * main thread of the server. Adds services to the service thread pool, along with the necessary arguments.
     */
    @Override
    public void start() {
        System.out.println("Server is ready.");
        while (true) {
            try {
                Services.execute(new Service(serv.accept(), domain, this));
            } catch (IOException ex) {
                Logger.getLogger(ServerCommFacade.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void injectDomain(IServerDomain domain) {
        this.domain = domain;
    }

    /**
     * executes a task sent from a service thread in a common thread pool.
     * @param task 
     */
    @Override
    public void execute(Task task) {
        tasks.execute(task);
    }

}
