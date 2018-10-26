/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_clientcomm;

import ProjectInterfaces.IClientComm;
import ProjectInterfaces.IUser;

/**
 *
 * @author Krongrah
 */
public class ClientCommFacade implements IClientComm {

    /**
     * Logs in the given user
     * @param username
     * @param hashedPwd
     * @return An object of the type IUser
     */
    @Override
    public IUser login(String username, String hashedPwd) {
        return null;
    }

}
