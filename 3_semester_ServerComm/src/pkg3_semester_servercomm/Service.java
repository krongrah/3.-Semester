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

    private Long lastAction;
    private Boolean isLoggedOut = false;
    private IServerDomain domain;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private CommSecurity security;

    Service(Socket socket, IServerDomain domain) {
        lastAction = System.currentTimeMillis();
        try {
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
                Task task = (Task) inputStream.readObject();
                if (task instanceof LogOutTask) {
                    logOut();
                }
                if (task instanceof EncryptionTask) {
                    security = (CommSecurity) inputStream.readObject();
                } else {
                    task = (Task) security.decryptObject((SealedObject) inputStream.readObject());
                    task.injectDomain(domain);
                    task.injectOutputStread(outputStream);
                    Thread thread = new Thread(task);
                    thread.start();
                }

            } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
            }

            lastAction = System.currentTimeMillis();
        }
    }

    public Boolean isLoggedOut() {
        return isLoggedOut;
    }

    public void logOut() {
        this.isLoggedOut = true;
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Long getLastAction() {
        return lastAction;
    }

}
