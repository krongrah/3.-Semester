/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IHasher;
import ProjectInterfaces.IUserManager;
import SecuritySystem.Hasher;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmadhamid
 */
public class ClientDomainFacade implements IClientDomain {

    private IClientComm comm;
    private IUserManager userManager;
    private IHasher hasher = new Hasher();
    

    @Override
    public void injectClientComm(IClientComm comm) {
        this.comm = comm;
        userManager = this.userManager.getInstance();
    }

    @Override
    public boolean login(String username, String password) {
        try {
            String hashedPwd = hasher.hash(password);
            userManager.setActiveUser(comm.login(username, hashedPwd));
            if(userManager.getActiveUser() == null){
                return false;
            }else{
                return true;
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClientDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void logout() {
        userManager.logout();
    }
    
    
    
}
