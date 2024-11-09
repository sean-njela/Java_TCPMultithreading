/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class represents a TCP client that communicates with a server.
 * @author Dell
 */
public class TCPClient {
    public static void main(String[] args) throws UnknownHostException 
    {
        // Get the IP address of the server by hostname
        InetAddress address = InetAddress.getByName("localhost");
        // Try to connect to the server using a socket
        try (Socket socket = new Socket(address, TCPMultithreading.PORT)) 
        {
            // Print a message indicating the client has started
            System.out.println("Client with the socket " + socket.getLocalPort() + " has started!");
            // Create an output stream to send data to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  
            // Create an input stream to receive data from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
  
            // Create a Scanner object to read input from the keyboard
            Scanner keyboardLine = new Scanner(System.in); 
            // Initialize a string variable to store the input line
            String line = null; 
  
            // Loop until the user enters "END"
            while (!"END".equalsIgnoreCase(line)) { 
                // Read a line of text from the keyboard
                line = keyboardLine.nextLine();
                // Send the line to the server
                out.println(line);
                // Flush the output stream to ensure data is sent immediately
                out.flush(); 
                // Read the server's response and print it to the console
                System.out.println("Produced content: "  + in.readLine()); 
            } 
            // Close the keyboard scanner
            keyboardLine.close(); 
        } 
        // Catch any IOExceptions that occur
        catch (IOException e) { 
            // Print the stack trace of the exception
            e.printStackTrace(); 
        }
    }
}
