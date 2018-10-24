/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_semester_servercomm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krongrah
 */
public class ServerHub {

    private int numberOfThreads = 10;
    private int port = 9001;
    private ExecutorService threadPool;
    private ServerSocket ssocket;

    ServerHub() {
        threadPool = Executors.newFixedThreadPool(numberOfThreads);
        try {
            ssocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ServerHub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void start() {

        while (true) {
            try {
                Socket s = ssocket.accept();
                System.out.println("User connected.");
                threadPool.submit(new Service(s));

            } catch (IOException ex) {
                Logger.getLogger(ServerHub.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
