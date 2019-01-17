package Example2;

// MultiThreadServer.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {

    public static void main(String[] args) {
        
        //create executor
        ExecutorService exe = Executors.newCachedThreadPool();

        System.out.println("Server started....awaiting connections");
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);

            int clientNo = 1; // The number of a client

            while (true) {
                // Listen for a new connection request
                Socket connectToClient = serverSocket.accept();

                // Print the new connect number on the console
                System.out.println("Start thread for client " + clientNo);

                // Find the client's host name, and IP address
                InetAddress clientInetAddress = connectToClient.getInetAddress();
                System.out.println("Client " + clientNo + "'s host name is " + clientInetAddress.getHostName());
                System.out.println("Client " + clientNo + "'s IP Address is " + clientInetAddress.getHostAddress());

                // Create a new thread for the connection
                HandleAClient thread = new HandleAClient(connectToClient);

                exe.submit(thread);
                clientNo++;// Increment clientNo
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

// Define the thread class for handling a new connection
class HandleAClient implements Runnable {

    private Socket connectToClient; // A connected socket

    /**
     * Construct a thread
     */
    public HandleAClient(Socket socket) {
        connectToClient = socket;
    }

    /**
     * Implement the run() method for the thread
     */
    public void run() {
        try {
            // Create data input and output streams
            DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());
            DataOutputStream osToClient = new DataOutputStream(connectToClient.getOutputStream());

            // Continuously serve the client
            while (true) {
                // Receive radius from the client
                double radius = isFromClient.readDouble();
                System.out.println("radius received from client: " + radius);

                // Compute area
                double area = radius * radius * Math.PI;

                // Send area back to the client
                osToClient.writeDouble(area);
                System.out.println("Area found: " + area);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
