/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientDomain;
import ProjectInterfaces.IClientSecurity;
import ProjectInterfaces.IUserManager;
import SecuritySystem.SecuritySystemFacade;
import UserSystem.UserManager;

/**
 * Communcation between the other 2 layers, which are the GUI and the ClientComm
 *
 */
public class ClientDomainFacade implements IClientDomain {

    private IClientComm comm;
    private static IUserManager userManager = new UserManager();
    private IClientSecurity security = new SecuritySystemFacade();

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
        
        String hashedPwd = security.Hash(password);
        userManager.setActiveUser(comm.login(username, hashedPwd));
        if (userManager.getActiveUser() == null) {
            return false;
        } else {
            return true;
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
