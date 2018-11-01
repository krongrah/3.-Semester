/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 *
 * @author Sebas
 */
public interface IUserManager {

    public void logout();

    public IUser getActiveUser();
    
    public boolean hasActiveUser();
    
    public boolean login(String username, String password);

}
