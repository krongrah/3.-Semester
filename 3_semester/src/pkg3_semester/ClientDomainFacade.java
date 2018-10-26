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
import UserSystem.UserManager;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Communcation between the other 2 layers, which are the GUI 
 * and the ClientComm
 * 
 */
public class ClientDomainFacade implements IClientDomain {

    private IClientComm comm;
    private IUserManager userManager = new UserManager();
    private IHasher hasher = new Hasher();

    /**
     * Injects an instance of the Client Communication facade
     *
     * @param comm
     */
    @Override
    public void injectClientComm(IClientComm comm) {
        this.comm = comm;
        userManager = this.userManager.getInstance();
        comm.connectToServer();
    }

    /**
     * Logs in the user, with a username and a password, the password is first
     * hashed using SHA-256.
     *
     * @param username
     * @param password
     * @return True if successful login, else returns false
     */
    @Override
    public boolean login(String username, String password) {
        try {
            String hashedPwd = hasher.hash(password);
            userManager.setActiveUser(comm.login(username, hashedPwd));
            if (userManager.getActiveUser() == null) {
                return false;
            } else {
                return true;
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClientDomainFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Logs out the active user
     */
    @Override
    public void logout() {
        userManager.logout();
    }

}
