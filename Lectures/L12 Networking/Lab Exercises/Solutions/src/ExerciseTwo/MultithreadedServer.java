package ExerciseTwo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedServer {
    private static ServerSocket server;
    private static Socket connection;
    private static ExecutorService exe = Executors.newCachedThreadPool();

    public static void main(String args[]) {
    
        // create ServerSocket
        try {
            server = new ServerSocket( 5000);
        
       
            System.out.println("Server running and awaiting connections");
           
            while (true) {
                // allow server to accept connection
                connection = server.accept();

                // Create a new thread for the connection
                HandleAClient thread = new HandleAClient(connection);
                exe.submit(thread);
            }//end while
            
        }//end try
        catch(Exception ex){
            System.out.println(ex.toString());
        }//end catch

     } // end main

 } //end class MultithreadedServer

//////////////////////////////////////////////////////////
// Define the thread class for handling a new connection
//////////////////////////////////////////////////////////

class HandleAClient extends Thread {

  private Socket connectToClient; // A connected socket
  private BufferedReader input;
  private BufferedWriter output;

  /**Construct a thread*/
  public HandleAClient(Socket socket)  {
    connectToClient = socket;
  }

  /**Implement the run() method for the thread*/
  public void run() {
    try   {
     
             // set up output streams
            output = new BufferedWriter( new OutputStreamWriter(connectToClient.getOutputStream()));
            DataOutputStream codeToClient = new DataOutputStream(connectToClient.getOutputStream());
     
            // set up input stream
            input = new BufferedReader( new InputStreamReader(connectToClient.getInputStream() ) );
       
            // receive file name from client
            File file = new File( input.readLine() );
  
            String result = "";
  
            // send file to client
            if ( file.exists() ) {
                codeToClient.writeInt(200);
                BufferedReader fileInput = new BufferedReader(new InputStreamReader( new FileInputStream( file ) ) );
            
                // read first line of file
                result = fileInput.readLine();

                while ( result != null ) {
                    output.write( result + '\n', 0, result.length() + 1 );
                    output.flush();
                     result = fileInput.readLine();
                }//end while
            
            }//end if
           
            // file does not exist
             else {
                
                codeToClient.writeInt(404);
                output.flush();
             }

            // close streams and socket
            output.close();
            input.close();
            connectToClient.close();
     
      }
      catch(IOException ex) {
        System.err.println(ex);
    }//end try
  
  }//end run

}//end class HandleAClient