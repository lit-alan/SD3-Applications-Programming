package app_prog_ui;

import java.util.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sd3.model.Customer;
import sd3.model.CustomerDB;
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
        
        //connect to DB
        CustomerDB.doConnection();
        
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
                    Date d = new Date();
                    Console.displayLine("Enter Data For Customer One");
                    String cName1 = Console.getString("Enter customer name: ");
                    String lName1 = Console.getString("Enter contact last name: ");
                    String fName1 = Console.getString("Enter contact first name: ");
                                  
                    Console.displayLine("\nEnter Data For Customer Two");
                    String cName2 = Console.getString("Enter customer name: ");
                    String lName2 = Console.getString("Enter contact last name: ");
                    String fName2 = Console.getString("Enter contact first name: ");
                    
                    Console.displayLine("\nEnter Data For Customer Three");
                    String cName3 = Console.getString("Enter customer name: ");
                    String lName3 = Console.getString("Enter contact last name: ");
                    String fName3 = Console.getString("Enter contact first name: ");
                    
                    Object[][] params = new Object[][] { { cName1, lName1, fName1, new Date()}, { cName2, lName2, fName2, new Date() }, { cName3, lName3, fName3, new Date()} };
                    taskFour(params);
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
            CustomerDB.closeConnection(); //disconnect from DB
            System.exit(0);
            
        } catch (Exception ex) {
            Console.displayLine("Error with ASCII art " + ex);
        }//end try
    }
    
    private void taskOne() {
        List<Customer> list = null;
        try {
            list = CustomerDB.getAllCustomers();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("Number of customers " + list.size());
        list.forEach(System.out::println); //the equilavent of looping over the list and displaying each object in it
 
        Console.displayLine();
    }
    
    private void taskTwo() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        List<Customer> list = null;
        int limit = 5;
        try {
            list = CustomerDB.getHighestCreditLimit(limit);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("\nTop " + limit + " customers with the largest credit limit");
        
        for (Customer c : list) {
            System.out.println(c.getCustomerNumber() + "\t" + c.getCustomerName() + "\t" + fmt.format(c.getCreditLimit()));
        }
        Console.displayLine();
    }
    
    private void taskThree() {
        List<Customer> list = null;
        String sql = "SELECT * FROM customers WHERE year(dateJoined) = ?";
        String year = "2018";
        try {
            list = CustomerDB.getAllCustomersInDateRange(sql, year);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        Console.displayLine("\nCustomers who joined in " + year + ":" + list.size());
        list.forEach(System.out::println);
        Console.displayLine();
    }
    
    private void taskFour(Object params[][]) {
       int[] values= null;
        try {
            values = CustomerDB.batchACustomerInsert(params);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(values.length + " record(s) inserted");  

        Console.displayLine();
    }
    
    private void taskFive() {
        String sql = "ALTER TABLE customers ADD creditRisk TINYINT(1)";
        try {
            System.out.println("Records Affected by " + sql + " " + CustomerDB.executeSQLStmt(sql));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        sql = "UPDATE customers SET creditRisk = 0 WHERE creditLimit <= 0;";
        try {
            System.out.println("Records Affected : " + sql + " " + CustomerDB.executeSQLStmt(sql));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        Console.displayLine();
    }
    
}//end class
