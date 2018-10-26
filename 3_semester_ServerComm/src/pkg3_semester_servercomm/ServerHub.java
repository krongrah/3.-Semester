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
 * This class connects approaching users and gives them a dedicated thread.
 *
 * @author Krongrah
 */
public class ServerHub {

    /**
     * This is the maximum number of threads, and thus, maximum number of
     * connected users at any given time.
     */
    private int numberOfThreads = 10;
    /**
     * This is the port clients connect to.
     */
    private int port = 9001;
    /**
     * This is the Thread pool that manages the service threads.
     */
    private ExecutorService threadPool;
    /**
     * This server socket receives incoming connections.
     */
    private ServerSocket ssocket;

    /**
     * This constructor instantiates the thread pool and server socket.
     */
    ServerHub() {
        threadPool = Executors.newFixedThreadPool(numberOfThreads);
        try {
            ssocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ServerHub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method starts the hub, and makes it start receiving connections,
     * each of which will be assigned a dedicated thread.
     */
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
