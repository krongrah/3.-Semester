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
public interface IClientComm {

    /**
     * Connects the client to the server.
     *
     * @return returns true if the connection was successful.
     */
    public boolean connectToServer();
}
