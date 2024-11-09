/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 * This is the multithreaded TCP server example.
 * 
 * @author Peter
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMultithreading {

    /**
     * The port number on which the server listens for connections.
     */
    public static final int PORT = 7777;

    /**
     * The main method of the server application.
     * 
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        // First, we prepare the server socket.
        ServerSocket myserver = null;

        try {
            // We open the server socket on the specified port.
            myserver = new ServerSocket(PORT);
            // This is to maintain the connection open even if there is no client currently connected.
            myserver.setReuseAddress(true);
            // Inform that the server is up and running.
            System.out.println("The server is up!");

            // Infinite loop to continuously listen for incoming client connections.
            while (true) {
                // Here we accept the connection of the client. This method blocks until a client connects.
                Socket clientsocket = myserver.accept();
                // Here we inform about establishing the connection with the client, displaying the client's IP address.
                System.out.println("New client connected" + clientsocket.getInetAddress().getHostAddress());

                // Here we create a new thread to process the client - we must pass the client socket to the thread!
                ServerThread mythread = new ServerThread(clientsocket);
                // ... and start the thread. This allows the server to handle multiple clients concurrently.
                new Thread(mythread).start();
            }
        } catch (IOException e) {
            // Handle any IOExceptions that may occur during server socket operations.
            e.printStackTrace();
        } finally {
            // Ensure proper closure of the server socket when the server is shutting down.
            if (myserver != null) {
                try {
                    // Close the server socket to release resources.
                    myserver.close();
                } catch (IOException e) {
                    // Handle any IOExceptions that may occur during server socket closure.
                    e.printStackTrace();
                }
            }
        }
    }

}
