/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static commondata.Constants.TIMEOUT_TIME_IN_MINUTES;

/**
 *
 * @author Kasper
 */
public class TimeoutThread implements Runnable{

    private List<Service>list;
    private Iterator<Service> it;
    
    TimeoutThread(List<Service> list){
    this.list=list;
    
    }
    
    @Override
    public void run() {
        while (true) {            
            it=list.iterator();
            while (it.hasNext()){
                Service service=it.next();
                if (service.getLastAction()+TIMEOUT_TIME_IN_MINUTES*60000<System.currentTimeMillis()) {
                    service.LogOut();
                }
                if(service.isLoggedOut()){
                it.remove();
                }
            }
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimeoutThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
