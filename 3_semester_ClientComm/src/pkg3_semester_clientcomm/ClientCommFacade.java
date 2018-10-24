/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_clientcomm;

import ProjectInterfaces.IClientComm;

/**
 * The Facade of the client side of the client server communication.
 * @author Krongrah
 */
public class ClientCommFacade implements IClientComm {

    /**
     * The reference to the connection.
     */
    private Connection connection;
    
    /**
     * Connects the connection to the server.
     * @return returns true if the connection was successful.
     */
    @Override
    public boolean connectToServer() {
        connection=new Connection();
       return connection.Connect();
    }

}
