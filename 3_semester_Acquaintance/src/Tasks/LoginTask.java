/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;

import ProjectInterfaces.IUser;

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
        IUser user = super.getDomain().login(username, hPassword);
        //todo:
        //Send the found user to the client..
    }
}
