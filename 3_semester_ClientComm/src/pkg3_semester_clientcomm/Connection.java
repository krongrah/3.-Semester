/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_clientcomm;

import ProjectInterfaces.IComm;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A connection to the server.
 *
 * @author Krongrah
 */
public class Connection {

    /**
     * A socket.
     */
    private Socket s;
    /**
     * Port of the server.
     */
    private int port = 9001;
    /**
     * The IP of the server.
     */
    private String IP = "localhost";//"10.123.3.31";
    /**
     * An object output stream.
     */
    private ObjectOutputStream stream;

    /**
     * connects the connection to the server.
     * @return returns true if the connection was successful.
     */
    public boolean Connect() {

        try {
            Registry r=LocateRegistry.getRegistry(9001);
            IComm icomm=(IComm)r.lookup("rmi://localhost/theJob");
            System.out.println("John is back" + icomm.sup());
            return true;
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientCommFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;    }

    /**
     * Sends an object to the server.
     *
     * @param object The object being send.
     * @return returns True if the object was successfully sent.
     */
    public boolean SendObject(Serializable object) {
        try {
            stream.writeObject(object);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Disconnects the client from the server.
     */
    public void disconnect() {
        try {
            stream.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
