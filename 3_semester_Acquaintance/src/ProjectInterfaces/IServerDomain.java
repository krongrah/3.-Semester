/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 * The interface for the Server Domain
 * @author Krongrah
 */
public interface IServerDomain {

    
    /**
     * The method for injecting the Server Persistence interface
     * @param persistence 
     */
    public void injectPersistence(IServerPersistence persistence);
}
