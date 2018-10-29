/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_serverdomain;

import ProjectInterfaces.IServerDomain;
import ProjectInterfaces.IServerPersistence;
import ProjectInterfaces.IUser;
import UserSystem.User;

/**
 *Facade for the ServerDomain
 * @author Krongrah
 */
public class ServerDomainFacade implements IServerDomain {

    
    /**
     * The interface for the serverpersistence
     */
    IServerPersistence persistence;

    
    /**
     * Inject method for persistence 
     * Injects ServerPersistence into ServerDomainFacade
     * @param persistence 
     */
    @Override
    public void injectPersistence(IServerPersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public IUser getUser(IUser user, String username, String password) {
        return persistence.getUser(new User(), username, password);
    }

    
}
