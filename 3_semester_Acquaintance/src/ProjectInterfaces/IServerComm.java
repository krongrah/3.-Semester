/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectInterfaces;

/**
 *
 * @author Krongrah
 */
public interface IServerComm {
    public void injectDomain(IServerDomain domain);
    public void startServer();
}
