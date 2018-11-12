/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebas
 */
public class LoginTask extends Task{
    
    private String username;
    private String hPassword;
    
    public LoginTask(String username, String password) {
        this.username = username;
        hPassword = password;
    }

    @Override
    public void run() {
        try {
            super.getOutputStream().writeObject(super.getDomain().login(username, hPassword));
        } catch (IOException ex) {
            Logger.getLogger(LoginTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
