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
    private User activeUser;
    
    public void login(String Username, String Password){
        
    }
    
    public void logout(){
        this.activeUser = null;
    }
}
