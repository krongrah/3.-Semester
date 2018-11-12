/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.IServerDomain;
import Tasks.Task;
import com.sun.rmi.rmid.ExecOptionPermission;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class Service implements Runnable {

    private Long lastAction;
    private Boolean isLoggedOut = false;
    private IServerDomain domain;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    Service(Socket socket, IServerDomain domain) {
        lastAction = System.currentTimeMillis();
        try {
            inputStream= new ObjectInputStream(socket.getInputStream());
            outputStream=new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (!isLoggedOut) {
            try {
                
                Task task=(Task)inputStream.readObject();
                task.injectDomain(domain);
                task.injectOutputStread(outputStream);
                Thread thread=new Thread(task);
                thread.start();
                
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

    public void LogOut() {
        this.isLoggedOut = true;
    }

    public Long getLastAction() {
        return lastAction;
    }

}
