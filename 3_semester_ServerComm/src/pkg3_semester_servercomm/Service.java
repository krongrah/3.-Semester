/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import java.net.Socket;

/**
 * This class implements the run method that will service a newly connected
 * user.
 *
 * @author Krongrah
 */
public class Service implements Runnable {

    /**
     * This socket contains the connection to the client, which allows the user
     * to communicate with the thread.
     */
    private Socket s;

    /**
     * This creates a new Service task, that will service a client, when run as
     * a runnable.
     *
     * @param s This socket is connected to the client, and allows this task to
     * communicate with it.
     */
    public Service(Socket s) {
        this.s = s;
    }

    /**
     * This is not yet implemented.
     */
    @Override
    public void run() {

    }

}
