/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class Service implements Runnable{
    
    private Long lastAction;
    private Boolean isLoggedOut=false;
    private BufferedReader br;

    Service(Socket socket){
    lastAction=System.currentTimeMillis();
        try {
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run() {
        while (!isLoggedOut) {  
            
            try {
                String line=br.readLine();
                if(line.equals("logout")){
                isLoggedOut=true;
                }else{
                    
                    
                }
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
                isLoggedOut=true;
            }
            lastAction=System.currentTimeMillis();
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
