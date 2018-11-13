/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.IServerDomain;
import Tasks.EncryptionTask;
import Tasks.LogOutTask;
import Tasks.Task;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SealedObject;

/**
 *
 * @author Kasper
 */
public class Service implements Runnable {

    private Boolean isLoggedOut;
    private IServerDomain domain;
    private IExecutor executor;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private CommSecurity security;

    Service(Socket socket, IServerDomain domain, IExecutor executor) {
        try {
            this.executor = executor;
            isLoggedOut = false;
            this.socket = socket;
            this.domain = domain;
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (!isLoggedOut) {
            try {
                //recieves a task from the client
                Task task = (Task) inputStream.readObject();
                //checks if the task is a LogOutTask, and logs out if true.
                if (task instanceof LogOutTask) {
                    logOut();
                }
                if (task instanceof EncryptionTask) {
                    security = (CommSecurity) inputStream.readObject();
                } else {
                    task = (Task) security.decryptObject((SealedObject) inputStream.readObject());
                    //injects the necessary objects into the task, 
                    //and then executes it in the common executor.
                    task.injectDomain(domain);
                    task.injectOutputStream(outputStream);
                    executor.execute(task);
                }
            } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                logOut();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Closes the socket and ends the run-loop
     */
    public void logOut() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.isLoggedOut = true;

    }
}
