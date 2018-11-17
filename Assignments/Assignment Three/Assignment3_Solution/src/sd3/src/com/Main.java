package sd3.src.com;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        
        try {
        CustomerDB.doConnection();
        
        //TASK 1
        List<Customer> list = CustomerDB.getAllCustomers();
        System.out.println("Number of customers " + list.size());
        displayAllCustomers(list);
        
        //TASK 2
        int limit = 5;
        list = CustomerDB.getHighestCreditLimit(limit);
        System.out.println("\nTop " + limit + " customers with the largest credit limit");
        for (Customer c : list) {
            System.out.println(c.getCustomerNumber() + "\t" + c.getCustomerName() + "\t" +  c.getFormattedCreditLimit());
        }
        
        //TASK 3
        String sql = "SELECT * FROM customers WHERE dateJoined between ? AND ?";
        String startDate = "20180101";
        String endDate =   "20181231";
        list = CustomerDB.getAllCustomersInDateRange(sql, startDate, endDate);
        System.out.println("\nCustomers who joined in 2018: " + list.size());
        displayAllCustomers(list);
        
        //TASK 4
        Object[][] params = new Object[][] { { "Los Pollos Hermanos", "Fring", "Gustavo", new Date()}, { "A1 Car Wash", "White", "Walter", new Date() }, { "Saul Goodman & Associates", "Goodman", "Saul", new Date()} };
        int[] values = CustomerDB.batchACustomerInsert(params);
        System.out.println(values.length + " record(s) inserted");     
        
        //TASK 5
        sql = "ALTER TABLE customers ADD creditRisk TINYINT(1)";
        System.out.println("Records Affected by " + sql + " " + CustomerDB.executeSQLStmt(sql));
        
        sql = "UPDATE customers SET creditRisk = 1 WHERE creditLimit > 0"; 
        System.out.println("Records Affected : " + sql + " " + CustomerDB.executeSQLStmt(sql));
        
        
        }//end try
        catch(SQLException sqlx) {
            System.out.println(sqlx);
        }
        finally {
         CustomerDB.closeConnection();   
        }
        
    }
    
    private static void displayAllCustomers(List<Customer> allCustomers) {
        for (Customer c : allCustomers) {
                System.out.println(c);
        }
    }//end displayAllAuthors
}
