/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a server thread that handles communication with a single client.
 * @author Peter
 */
public class ServerThread implements Runnable {
    // A reference to the client socket
    private final Socket clientSocket; 
    // Sleep time for the thread in milliseconds
    private final int sleepTime = 1000;
  
    /**
     * Constructor for the ServerThread class.
     * @param socket The client socket to handle.
     */
    public ServerThread(Socket socket) 
    {
        // Here we assign the client socket to the thread
        this.clientSocket = socket; 
        System.out.println("The Server Thread No. " + Thread.currentThread().threadId() + " for the client " + socket.getPort() + " has started!");
    } 
    
    /**
     * The run method of the thread, which handles communication with the client.
     */
    @Override
    public void run() 
    { 
        // Output stream for sending data to the client
        PrintWriter out = null; 
        // Input stream for receiving data from the client
        BufferedReader in = null; 
        try {                 
            // This is the output stream
            out = new PrintWriter(clientSocket.getOutputStream(), true); 
            // This is the input stream
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
            // String to store the received line from the client
            String line; 
            // Loop to continuously read data from the client
            while ((line = in.readLine()) != null) { 
                // Print the received line to the console
                System.out.println(" Received: " + line); 
                // Here we put the thread to sleep to show multiple are at work
                Thread.sleep(sleepTime);
                // Send the received line back to the client, enclosed in <strong> tags
                out.println("<strong>" + line + "</strong>"); 
            } 
        } 
        // Catch block for IOException
        catch (IOException e) { 
            // Print the stack trace of the exception
            e.printStackTrace(); 
        } 
        // Catch block for InterruptedException
        catch (InterruptedException ex) {
            // Log the exception using the Logger class
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
        // Finally block to ensure proper cleanup
        finally { 
            try { 
                // Here we close the connection
                if (out != null) { 
                    // Close the output stream
                    out.close(); 
                } 
                if (in != null) { 
                    // Close the input stream
                    in.close(); 
                    // Close the client socket
                    clientSocket.close(); 
                } 
            } 
            // Catch block for IOException
            catch (IOException e) { 
                // Print the stack trace of the exception
                e.printStackTrace(); 
            } 
        } 
    } 
} 
