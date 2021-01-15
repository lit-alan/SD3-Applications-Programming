package Example1;

// CircleClient.java: The client sends the input to the server and receives
// result back from the server
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CircleClient {

    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);

            // Create a socket to connect to the server
            // Socket connectToServer = new Socket("130.254.32.8", 8000);
            Socket connectToServer = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            DataInputStream isFromServer = new DataInputStream(
                    connectToServer.getInputStream());

            // Create an output stream to send data to the server
            DataOutputStream osToServer
                    = new DataOutputStream(connectToServer.getOutputStream());

            // Continuously send radius and receive area from the server
            while (true) {
                // Read the radius from the keyboard
                System.out.println("Please enter a radius:");
                double radius = scanner.nextDouble();

                // Send the radius to the server
                osToServer.writeDouble(radius);
                osToServer.flush();

                // Get area from the server
                double area = isFromServer.readDouble();

                // Print area on the console
                System.out.println("Area received from the server is " + area);

            }//end while
        }//end try
        catch (IOException ex) {
            System.err.println(ex);
        }//end catch
    }//end main
}//end class