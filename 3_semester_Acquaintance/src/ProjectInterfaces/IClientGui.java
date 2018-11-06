/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 * The interface for the Client GUI
 *
 * @author Krongrah
 */
public interface IClientGui {

    /**
     * The method for injecting the domain
     *
     * @param domain
     */
    public void injectdomain(IClientDomain domain);

    /**
     * Gets an instance of ClientGui
     *
     * @return IClientGui
     */
    public IClientGui getInstance();

    /**
     * The method for starting the entire system
     *
     * @param args
     */
    public void start(String[] args);
}
