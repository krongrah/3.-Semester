/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 * The interface for the Server Communication
 *
 * @author Krongrah
 */
public interface IServerComm {

    /**
     * The method to inject the server domain
     *
     * @param domain
     */
    public void injectDomain(IServerDomain domain);

    public void start();

}
