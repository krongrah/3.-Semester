/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 * The interface for the Client communication
 * @author Krongrah
 */
public interface IClientComm {
    public IUser login(String username, String hashedPwd);
}
