/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class AllJobsTask extends Task{

    public AllJobsTask(){
        
    }
    
    @Override
    public void run() {
        try {
            super.getOutputStream().writeObject(super.getDomain().getAllJobs());
        } catch (IOException ex) {
            Logger.getLogger(AllJobsTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
