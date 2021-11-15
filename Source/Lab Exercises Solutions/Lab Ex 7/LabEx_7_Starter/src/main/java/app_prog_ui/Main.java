package app_prog_ui;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.app_prog_art.ASCIIArtGenerator;



public class Main {

    
    public static void main(String[] args) {

        try {
            new Main();
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Main() throws ParseException {

        // displayLine a welcome message
        Console.displayLine("\t\t\t\tWelcome to the Assignment Three Main Menu");
        Console.displayLine();

        int choice = 0;

        while (choice != -1) {

            //display menu choices
            Console.displayLine("1:  Display all records in ascending order");
            Console.displayLine("2:  Display five records that have the highest creditLimit");
            Console.displayLine("3:  Display All Records of Customers who joined in 2018");
            Console.displayLine("4:  Insert Records With Batch");
            Console.displayLine("5:  Add Credit Risk Column");
            Console.displayLine("-1: Quit");
            Console.displayLine();

            //prompt user for their menu choice
            choice = Console.getInt("Enter Choice: ");

            //evaluate user choice
            switch (choice) {

                case 1:
                    taskOne();
                    break;
                case 2:
                    taskTwo();
                    break;
                case 3:
                    taskThree();
                    break;
                case 4:
                    Console.displayLine("Enter Data For Customer One");
                    String cName = Console.getString("Enter customer name: ");
                    String lName = Console.getString("Enter contact last name: ");
                    String fName = Console.getString("Enter contact first name: ");
     
                    Console.displayLine("\nEnter Data For Customer Two");
                    cName = Console.getString("Enter customer name: ");
                    lName = Console.getString("Enter contact last name: ");
                    fName = Console.getString("Enter contact first name: ");
                    
                    Console.displayLine("\nEnter Data For Customer Three");
                    cName = Console.getString("Enter customer name: ");
                    lName = Console.getString("Enter contact last name: ");
                    fName = Console.getString("Enter contact first name: ");

                    taskFour();
                    break;
                case 5:
                    taskFive();
                    break;

            }//end switch

            Console.displayLine();

        }//end while  
        
        //display ASCII art before exiting
        ASCIIArtGenerator art = new ASCIIArtGenerator();
        try {
            art.printTextArt("Bye!", 14, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_DIALOG, "+");
            System.exit(0);
        } catch (Exception ex) {
            Console.displayLine("Error with ASCII art " + ex);
        }//end try
    }
    
    private void taskOne() {
       /* 
        * TODO Task 1.1: Display on screen, all records from the customers table in ascending order 
        *(on the customerName field). You must display all fields for each record on the screen. 
        
        * TODO Task 1.1: Display how many records are returned from the database. 
        */
        Console.displayLine("\nTASK One");  
        Console.displayLine();
    }

    private void taskTwo() {
        /*
         * TODO Task 2: Display on screen, the 5 records from the customers table that have the highest creditLimit
         * These records must be ordered by creditLimit in descending order. You must 
         * then display just the customerNumber, customerName and creditLimit for these 5 customers 
         * 
        */
        
         
        Console.displayLine("\nTASK TWO");     
        Console.displayLine();
    }

    private void taskThree() {
        /*
         * TODO Task 3.1: Display on screen, all fields for every record for every record in the customers table who joined in 2018. 
         * TODO Task 3.2: You must also display on screen how many records are returned from the database
         */
      
        Console.displayLine("\nTASK Three"); 
        Console.displayLine();
    }

    private void taskFour() {
        // TODO Task 4: Insert Three records
        
        Console.displayLine("\nTASK Four");  
        Console.displayLine();
    }
    
    private void taskFive() {
        /*
         * ToDo Task 5.1: Add a column called ‘creditRisk’ to the customers table
         * ToDo Task 5.2: Ensure that all records which have a creditLimit of zero are recorded 
         * as a credit risk, while all others are not.
         */
        
        Console.displayLine("\nTASK Five"); 
        Console.displayLine();
    }
    
}//end class
