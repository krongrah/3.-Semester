/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserSystem;

import ProjectInterfaces.IUser;
import ProjectInterfaces.IUserManager;

/**
 *
 * @author Sebas
 */
public class UserManager implements IUserManager {

    private static IUserManager userManager = null;

    /**
     * Stores the active user of the system
     */
    private IUser activeUser;

    /**
     * Logs out the user in the system
     */
    public void logout() {
        this.activeUser = null;
    }

    /**
     * Sets the active user as an object of the Iuser interface
     *
     * @param user : IUser
     */
    @Override
    public void setActiveUser(IUser user) {
        this.activeUser = user;
    }

    @Override
    public IUser getActiveUser() {
        return this.activeUser;
    }

    @Override
    public IUserManager getInstance() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

}
