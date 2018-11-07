package UserSystem;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IClientSecurity;
import ProjectInterfaces.IUser;
import ProjectInterfaces.IUserManager;
import SecuritySystem.SecuritySystemFacade;
import commondata.User;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;

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
        try {
            this.security = new SecuritySystemFacade();
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean login(String username, String password) {
        if (hasActiveUser()) {
            String hashedPwd = security.Hash(password);
            try {
                setActiveUser((User)security.decryptObject(comm.login(username, hashedPwd)));
            } catch (IOException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    private void setActiveUser(Serializable user) {
        this.activeUser = (User) user;
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
