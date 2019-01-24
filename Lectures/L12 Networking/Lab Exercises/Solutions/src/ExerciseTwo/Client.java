package ExerciseTwo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

 public class Client {
  
    public static void main( String args[])  {
        JTextArea contents = new JTextArea(10, 50);
        JScrollPane scroller = new JScrollPane(contents);
        contents.setEditable(false);
        contents.setWrapStyleWord(true);
        contents.setLineWrap(true);
        
        String fName = JOptionPane.showInputDialog(null, "Enter file name") + "\n";
        
        // connect to server, get streams
        try {

            // create Socket to make connection to server
            Socket connection = new Socket( InetAddress.getLocalHost(), 5000 );

            // set up output stream
            BufferedWriter bufferOutput = new BufferedWriter( new OutputStreamWriter(connection.getOutputStream()));

            // set up input streams
            BufferedReader bufferInput = new BufferedReader( new InputStreamReader(connection.getInputStream()));
            DataInputStream isFromServer = new DataInputStream(connection.getInputStream());

            bufferOutput.write( fName, 0, fName.length() );
            bufferOutput.flush();// 
            
            int code = isFromServer.readInt(); //get code from server
                                               //200  = file found
                                               //404  = file not found
            
            String output = bufferInput.readLine() + "\n";

            // if file exists, dislay file contents
            if ( code == 200 ) {
                output += bufferInput.readLine();

                while ( output != null ) {
                    contents.append( output + "\n" );
                    output = bufferInput.readLine();
                }//end while
            
            }//end if
            else if (code == 404) {
                JOptionPane.showMessageDialog(null, "File not found");
                System.exit(0);
            }

            // close streams and socket
            bufferOutput.close();
            bufferInput.close();
            connection.close();
            
            //display contents of file in text area
            JOptionPane.showMessageDialog(null, scroller);
        }//end try

        // process problems communicating with server
        catch( IOException ioException ) {
            System.out.println(ioException.toString());
        }
        
    }//end main

}//end Client class 
