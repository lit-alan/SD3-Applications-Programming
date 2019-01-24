package ExerciseOne;

import java.io.*;
import java.net.*;
import java.text.DecimalFormat;

public class Server {

    static FileWriter fws = null;
    static PrintWriter out = null;

    public static void main(String[] args) {
        try {
            fws = new FileWriter("logfile.dat");
            out = new PrintWriter(fws);

            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);

            while (true) {
                // Listen for a new connection request
                Socket connectToClient = serverSocket.accept();
                
                // Find the client's IP address
                InetAddress clientInetAddress = connectToClient.getInetAddress();
                String ipAddress = clientInetAddress.getHostAddress();
                
                // Create a new thread for the connection and pass ip address
                HandleAClient thread = new HandleAClient(connectToClient, ipAddress, out);
                thread.start();// Start the new thread
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
// Define the thread class for handling a new connection

class HandleAClient extends Thread {

    private final Socket connectToClient; // A connected socket
    private final String clientsIP;
    private final PrintWriter out;
    private final DecimalFormat df  = new DecimalFormat("0.00");

    /**
     * Construct a thread
     */
    public HandleAClient(Socket socket, String IP, PrintWriter out) throws IOException {
        connectToClient = socket;
        clientsIP = IP;
        this.out = out;
    }

    public void run() {
        try { 

            // Create data input and output streams
            DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());
            DataOutputStream osToClient = new DataOutputStream(connectToClient.getOutputStream());

            // Continuously serve the client
            while (true) {
                // Receive values from client
                double height = isFromClient.readDouble();
                double weight = isFromClient.readDouble();

                //calculate score
                double BMIScore = weight / Math.pow(height, 2);
                String BMICategory;

                //determine category
                if (BMIScore < 14.0) {
                    BMICategory = "Emaciation";
                } else if (BMIScore > 14.0 && BMIScore < 18.4) {
                    BMICategory = "Underweight";
                } else if (BMIScore > 18.5 && BMIScore < 22.9) {
                    BMICategory = "Normal";
                } else if (BMIScore > 23.0 && BMIScore < 27.5) {
                    BMICategory = "Overweight";
                } else if (BMIScore > 27.6 && BMIScore < 40.0) {
                    BMICategory = "Obese";
                } else {
                    BMICategory = "Morbidly Obese";
                }
                
                // Send category back to the client
                osToClient.writeUTF(BMICategory);
                
                //print IP address along with BMIScore and BMICategory to file
                out.println(clientsIP + " BMI SCORE " + df.format(BMIScore) + " BMI Category " + BMICategory);
                

            }//end while
        }//end try
        catch (IOException ex) {
            System.err.println(ex);
        }//end catch
        
        finally {
            out.close();
        }
            
    }//end run
}//end HandleAClient
