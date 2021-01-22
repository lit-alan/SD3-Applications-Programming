package Multicast_Broadcast;

import java.io.*;
import java.net.*;
import java.util.Date;


public class MulticastSender {
  public static void main(String[] args) {
   
  
    DatagramSocket socket = null;
    DatagramPacket outPacket = null;
    byte[] outBuf;
    final int PORT = 8888;
 
    try {
        System.out.print("Server Running.");
        socket = new DatagramSocket();

        String msg;
 
        while (true) {
            msg = new Date().toString();
      
            outBuf = msg.getBytes();
 
            //Send to multicast IP address and port
            InetAddress address = InetAddress.getByName("224.2.2.3");
            
            outPacket = new DatagramPacket(outBuf, outBuf.length, address, PORT);

            socket.send(outPacket);
    
            try {
                Thread.sleep(1000); 
                System.out.print(".");
            } //end try
            catch (InterruptedException ie) {
            }//end catch
      }//end while
    
    }//end try
    
    catch (IOException ioe) {
      System.out.println(ioe);
    }//end catch
  
  }//end main

}//end class