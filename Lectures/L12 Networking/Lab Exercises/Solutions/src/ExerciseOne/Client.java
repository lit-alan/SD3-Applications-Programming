package ExerciseOne;

 //definitions
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {

    /**
     * Main method
     */
    public static void main(String[] args) {

        try {
            // Create a socket to connect to the server
            Socket connectToServer = new Socket("localhost", 8000);
            
            // Create an input stream to receive data from the server
            DataInputStream isFromServer = new DataInputStream(
                    connectToServer.getInputStream());

            // Create an output stream to send data to the server
            DataOutputStream osToServer = new DataOutputStream(connectToServer.getOutputStream());
            // Continuously send radius and receive area from the server
            
            while (true) {
                // Read the height from the keyboard
                String input = JOptionPane.showInputDialog("Please enter your height ");
                double height = Double.parseDouble(input);

                // Read the weight from the keyboard
                input = JOptionPane.showInputDialog("Please enter your weight ");
                double weight = Double.parseDouble(input);
                
                // Send the height and weight to the server
                osToServer.writeDouble(height);
                osToServer.writeDouble(weight);
                
                // Get category from the server
                String category = isFromServer.readUTF();
                
                // display area on the console
                JOptionPane.showMessageDialog(null, "Category is " + category);
            }//end while
            
        }//end try 
        catch (IOException ex) {
            System.err.println(ex);
        }//end catch
    }//end main
}//end class
