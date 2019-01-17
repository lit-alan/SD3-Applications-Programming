/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example4_Datagrams;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author alan.ryan
 */
public class DatagramClient {

    //Datagram socket
    private DatagramSocket socket;

    //A byte array for sending and recieving datagram sockets
    private byte[] buf = new byte[256];

    //server InetAddress
    private InetAddress address;

    //The packet sent to the server
    private DatagramPacket sendPacket;

    //The packet recieved from the client
    private DatagramPacket recievePacket;

    public static void main(String[] args) {
        new DatagramClient();
    }

    public DatagramClient() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Datagram Socket");

        try {
            socket = new DatagramSocket();

            address = InetAddress.getByName("localhost");

            sendPacket = new DatagramPacket(buf, buf.length, address, 8000);

            recievePacket = new DatagramPacket(buf, buf.length);

        } catch (SocketException se) {
            System.out.println(se);
        } catch (UnknownHostException uhe) {
            System.out.println(uhe);
        }

        System.out.println("Enter radius (-1 to quit): ");
        String input = scanner.nextLine();
        
        while (!input.equals("-1")) {
            try {
                //initialise buffer for each iteration
                Arrays.fill(buf, (byte) 0);

                //send radius to the server in a packet
                sendPacket.setData(input.trim().getBytes());
                socket.send(sendPacket);

                //recieve area from the server in a packet
                socket.receive(recievePacket);

                //display to the text area
                System.out.println("Area recieved from the server is " + Double.parseDouble(new String(buf).trim()));

                
                System.out.println("\nEnter radius (-1 to quit): ");
                input = scanner.nextLine();
            }//end try
            catch (IOException ioe) {
                System.out.println(ioe);
            }//end catch

        }//end while

    }//end constructor

}//end class
