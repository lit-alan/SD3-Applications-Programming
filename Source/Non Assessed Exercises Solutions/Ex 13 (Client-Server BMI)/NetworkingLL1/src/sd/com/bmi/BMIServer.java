package sd.com.bmi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.NumberFormat;
import java.util.Date;

public class BMIServer {

    public static void main(String[] args) {

        String clientsIP = "";
        
        NumberFormat formatter = NumberFormat.getNumberInstance();
     
        try {
            
            ServerSocket serverSocket = new ServerSocket(8000);

            System.out.println("Server started at " + new Date());
            
            while (true) {
                // Listen for a new connection request
                Socket connectToClient = serverSocket.accept();

                // Find the client's IP address
                InetAddress clientInetAddress = connectToClient.getInetAddress();
                clientsIP = clientInetAddress.getHostAddress();

                DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());
                DataOutputStream osToClient = new DataOutputStream(connectToClient.getOutputStream());

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
                System.out.println(clientsIP + ": BMI SCORE: " + formatter.format(BMIScore) + " BMI Category: " + BMICategory);
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }//end catch

    }

}
