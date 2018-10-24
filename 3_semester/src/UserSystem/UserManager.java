/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSystem;

/**
 *
 * @author Sebas
 */
public class UserManager {
    /**
     * Stores the active user of the system
     */
    private User activeUser;
    
    /**
     * Logs in the user, with their password and username
     * @param Username : String
     * @param Password : Hashed String
     */
    public void login(String Username, String Password){
        //todo
    }
    
    /**
     * Logs out the user in the system
     */
    public void logout(){
        this.activeUser = null;
    }
}
