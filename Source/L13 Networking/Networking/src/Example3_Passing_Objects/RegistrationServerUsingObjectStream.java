package Example3_Passing_Objects;

// RegistrationServerUsingObjectStream.java: The server
// responsible for writing on the objects to a fileserver side
import java.io.*;
import java.net.*;

public class RegistrationServerUsingObjectStream  {
  private static ObjectOutputStream objOutStream;
  private static ObjectInputStream objInStream;

   /**Main method*/
  public static void main(String[] args) {
    
    RegistrationServerUsingObjectStream server = 
    					new RegistrationServerUsingObjectStream();
    
  }//end main

  public RegistrationServerUsingObjectStream() {
  	System.out.println("Server started and is awaiting connections");

    // Open the local file on the server side
    try   {
      // Open the file if the file exists, create a new file
      // if the file does not exist
      File f = new File("Student.dat");
      objOutStream =  new ObjectOutputStream(new FileOutputStream(f));
     
    }//end try
    
    catch(IOException ex)  {
      System.out.println("An error has occured: " + ex);
      System.exit(0);
    }//end catch

    // Establish server socket
    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);
      
      // Count the number of threads started
      int count = 1;

      while (true) {
        // Connect to a client Socket socket = serverSocket.accept();
        Socket socket = serverSocket.accept();
        
        // Start a new thread to register a client
        new RegistrationThread(socket, count++).start();
      }//end while
    
    }//end try
    
    catch (IOException ex)  {
      System.out.println("An error has occured: " + ex);
      System.exit(0);
    }//end catch
  
  }//end constructor

  /**Write student information to the file*/
  private synchronized static void writeToFile(Student student) {
    try  {
      // Append it to "student.dat"
       objOutStream.writeObject(student);


      // Display data saved
      System.out.println("The following info is saved in the file");
      String studentDetails = "Name: " + student.getName();
      studentDetails += "\nStreet: " + student.getStreet(); 
      studentDetails += "\nCity: " + student.getCity(); 
      studentDetails += "\nYear: " + student.getYear(); 
      studentDetails += "\nFee: " + student.getFee(); 
      
      System.out.println(studentDetails);
    
    }//end try
    
    catch (Exception ex) {
      System.out.println("An error has occured: " + ex);
    }//end catch
  
  }//end writeToFile(Student student)

  /**Define a thread to process the client registration*/
  class RegistrationThread extends Thread {
  
    // The socket to serve a client
    private Socket socket;

    private int clientNo; // The thread number

    // Create a registration thread
    public RegistrationThread(Socket socket, int clientNo)  {
      this.socket = socket;
      this.clientNo = clientNo;

      System.out.println("Thread " + clientNo + " started");

      // get the input stream from a clientto receive data 
      try {
      
        objInStream = new ObjectInputStream(socket.getInputStream());
      
      }//end try
      
      catch(IOException ex)  {
      
        System.out.println("An error has occured: " + ex);
      
      }//end catch
    
    }//end RegistrationThread(Socket socket, int clientNo)

    public void run() {
      try  {
    
        // Receive data from the client
        Student student = (Student)objInStream.readObject();

        writeToFile(student);
      }//end try
      
      catch (Exception ex) {
    
        System.out.println("An error has occured: " + ex);

      }//end catch

    }//end run

  }//end class RegistrationThread

}//end class RegistrationServerUsingObjectStream