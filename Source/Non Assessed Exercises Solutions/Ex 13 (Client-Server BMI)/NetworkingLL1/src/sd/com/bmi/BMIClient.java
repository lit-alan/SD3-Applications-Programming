package sd.com.bmi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BMIClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

			try {
				// Create a socket to connect to the server
				Socket connectToServer = new Socket("localhost", 8000);

				// Create an input stream to receive data from the server
				DataInputStream isFromServer = new DataInputStream(
						connectToServer.getInputStream());

				// Create an output stream to send data to the server
				DataOutputStream osToServer = new DataOutputStream(connectToServer.getOutputStream());
				// Continuously send radius and receive area from the server

				while (true) {
					// Read the height from the keyboard
					System.out.println("Please enter your height");
					double height = scanner.nextDouble();

					// Read the weight from the keyboard
					System.out.println("Please enter your weight ");
					double weight = scanner.nextDouble();

					// Send the height and weight to the server
					osToServer.writeDouble(height);
					osToServer.writeDouble(weight);

					// Get category from the server
					String category = isFromServer.readUTF();

					// display area on the console
					System.out.println("Category is " + category + "\n");
				}//end while

			}//end try 
			catch (IOException ex) {
				System.err.println(ex);
			}//end catch
		}

}
