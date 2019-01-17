

package Example4_Datagrams;

import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.Date;


public class DatagramServer {

    
    static byte buf[] = new byte[8];


    public static void main(String args[]) {


       try {

            //create a socket on port 8000
            MulticastSocket socket = new MulticastSocket(8000);
            socket.setBroadcast(true);

            System.out.println("================================================");
            System.out.println("Server started at " + new Date());
            System.out.println("================================================");

            //create a packet for recieving data
            DatagramPacket recievePacket = new DatagramPacket(buf, buf.length);

            //create a packet for sending data
            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length);

            while (true) {

                //initialise buffer for each iteration
                Arrays.fill(buf, (byte)0);

                //recieve radius from client in a packet
                socket.receive(recievePacket);

                System.out.println("The client hostname is " + recievePacket.getAddress().getHostName() +
                                   " and the port number is " + recievePacket.getPort());

                System.out.println("Radius recieved from client is " + new String(buf).trim() + "\n");

          
                //do computation and calculate the radius
                double radius = Double.parseDouble(new String(buf).trim());
                double area = radius * radius * Math.PI;

                //send area to the client in a packet
                sendPacket.setAddress(recievePacket.getAddress());
                sendPacket.setPort(recievePacket.getPort());
                sendPacket.setData(new Double(area).toString().getBytes());
                socket.send(sendPacket);

            }//end while

        }//end try

        catch(Exception ioe) {
            System.out.println(ioe);
        }//end catch

    }

}
