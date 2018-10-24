/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 * The interface for the Client domain
 * @author Krongrah
 */
public interface IClientDomain {

    
    /**
     * Method for injecting Client communication
     * @param comm 
     */
    public void injectClientComm(IClientComm comm);
}
