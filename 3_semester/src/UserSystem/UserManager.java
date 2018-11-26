package UserSystem;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientSecurity;
import ProjectInterfaces.IUser;
import ProjectInterfaces.IUserManager;

/**
 *
 * @author Sebas
 */
public class UserManager implements IUserManager {

    /**
     * Stores the active user of the system
     */
    private IUser activeUser;
    private IClientSecurity security;
    private IClientComm comm;

    public UserManager(IClientSecurity security, IClientComm comm) {
        this.comm = comm;
        this.security = security;
    }

    @Override
    public boolean login(String username, String password) {
        if (!hasActiveUser()) {
            String hashedPwd = security.Hash(password);
            System.out.println(hashedPwd);
            setActiveUser(comm.login(username, hashedPwd));
            if (getActiveUser() != null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Logs out the user in the system
     */
    @Override
    public void logout() {
        this.activeUser = null;
    }

    /**
     * Sets the active user as an object of the IUser interface
     *
     * @param user : IUser
     */
    private void setActiveUser(IUser user) {
        this.activeUser = user;
    }

    @Override
    public IUser getActiveUser() {
        return this.activeUser;
    }

    @Override
    public boolean hasActiveUser() {
        return this.activeUser == null;
    }

}
