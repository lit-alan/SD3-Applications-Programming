package Example3_Passing_Objects;

// RegistrationClientUsingObjectStream.java: The applet client for
// gathering student information the and passing it to the server
import java.io.*;
import java.net.*;

public class RegistrationClientUsingObjectStream  {
  
  // IP address of the server
  static String serverIP = "localhost";

  public static void main(String[] args) {
      try {
        // Establish connection with the server
        Socket socket = new Socket(serverIP, 8000);

        // Create an output stream to the server
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        
        //String name, String street, String city, String year, String fee)
        Student s = new Student("Tom Jones", "Main St", "Limerick", "1985", "123.52");

        // Get data from text fields and send it to the server
        toServer.writeObject(s);
       
        System.out.println("Student Record Written To File on Server machine");
      }//end try
      
      catch (IOException ex)  {
        System.err.println(ex);
      }//end catch
    }//end main
}//end class RegistrationClientUsingObjectStream