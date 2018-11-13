/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import commondata.CommSecurity;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Sebas
 */
public class EncryptionTask extends Task {

    private static CommSecurity security;
    
    @Override
    public void run() {
        security = new CommSecurity();
        try {
            super.getOutputStream().writeObject(security);
        } catch (IOException ex) {
            Logger.getLogger(EncryptionTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
