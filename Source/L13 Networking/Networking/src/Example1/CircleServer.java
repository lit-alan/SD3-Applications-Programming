package Example1;
// CircleServer.java: The server accepts data from the client, processes it
// and returns the result back to the client

import java.io.*;
import java.net.*;

public class CircleServer {

    /**
     * Main method
     */
    public static void main(String[] args) {
        try {

            System.out.println("Server started and awaiting connections....");
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);

            // Start listening for connections on the server socket
            Socket connectToClient = serverSocket.accept();

            // Create an input stream to get data from the client
            DataInputStream isFromClient = new DataInputStream(
                    connectToClient.getInputStream());

            // Create an output stream to send data to the client
            DataOutputStream osToClient = new DataOutputStream(
                    connectToClient.getOutputStream());

            InetAddress clientInetAddress = connectToClient.getInetAddress();

            System.out.println("Clients host name is " + clientInetAddress.getHostName());
            System.out.println("Clients IP address is " + clientInetAddress.getHostAddress());

            // Continuously read from the client and process it,
            // and send result back to the client
            while (true) {

                // Read a string from the input stream
                double radius = isFromClient.readDouble();

                // Display radius on console
                System.out.println("radius received from client: " + radius);

                // Compute area
                double area = radius * radius * Math.PI;

                // Send the result to the client
                osToClient.writeDouble(area);
                osToClient.flush();

                // Print the result to the console
                System.out.println("Area found: " + area);
            }//end while
        }//end try
        catch (IOException ex) {
            System.err.println(ex);
        }//end catch
    }//end main
}//end class