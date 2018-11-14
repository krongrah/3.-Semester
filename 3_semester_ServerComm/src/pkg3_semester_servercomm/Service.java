/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import ProjectInterfaces.IServerDomain;
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
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private CommSecurity security;

    Service(Socket socket, IServerDomain domain, CommSecurity security) {
        try {
            this.security = security;
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
                Task task = (Task)inputStream.readObject();
                //checks if the task is a LogOutTask, and logs out if true.
                
                switch(task.getType()){
                    case LOGIN:
                        
                        break;
                    case LOGOUT:
                        
                        break;
                    case APPLY:
                        
                        break;
                    case APPLYPERS:
                        
                        break;
                    case CALC:
                        
                        break;
                    case ALLJOBS:
                        
                        break;
                    case RANKING:
                        
                        break;
                    case ASSESSMENT:
                        
                        break;
                    case QUESTION:
                        
                        break;
                    
                    
                }
                } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
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
