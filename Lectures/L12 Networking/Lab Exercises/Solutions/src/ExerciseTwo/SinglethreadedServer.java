package ExerciseTwo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SinglethreadedServer {
    private static ServerSocket server;
    private static Socket connection;

    public static void main(String args[]) {
    
        // create ServerSocket
        try {
            server = new ServerSocket(5000);
        
       
            System.out.println("Server running and awaiting connections");
           
            while (true) {
                // allow server to accept connection
                connection = server.accept();

                DataOutputStream osToClient = new DataOutputStream(connection.getOutputStream());
                DataInputStream isFromClient = new DataInputStream(connection.getInputStream());
                
                
                String fName = isFromClient.readUTF().trim();
                // receive file name from client
              
                File file = new File(fName);
              
                if ( file.exists() ) {
                    
                    osToClient.writeInt(200);
                    
                    Path pathToTargetFile = Paths.get(fName); 

                    List<String> lines;
                    String output = "";

                    try {
                        lines = Files.readAllLines(pathToTargetFile,Charset.forName("UTF-8"));
                        
                         for(String item : lines ){
                            output += item + "\n";
                        }
                   
                    }//end try
                    catch (Exception ex) {
                        System.out.println(ex);
                    }//end catch
                    
                   osToClient.writeUTF(output);
                
                }//end if (check for existance of file)
                else {
                    osToClient.writeInt(404);
                    osToClient.flush();

                }//end else
            
            }//end while
            
        }//end try
        catch(Exception ex){
            System.out.println(ex.toString());
        }//end catch

     } // end main

 } //end class SinglethreadedServer
