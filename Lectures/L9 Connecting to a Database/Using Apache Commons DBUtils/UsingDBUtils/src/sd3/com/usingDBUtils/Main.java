package sd3.com.usingDBUtils;

import java.sql.SQLException;
import java.util.List;
import utilities.Books;

public class Main {
   
    public static void main(String[] args) throws SQLException {
        try {
            
            Books.resetTableInDB();
            AuthorDB.doConnection();
           
            int id = 3;
            System.out.println("Print Details for Author With an ID of " + id);
            System.out.println(AuthorDB.getAuthorByID(id));
            
            System.out.println("\nPrint all Authors");
            List<Author> list = AuthorDB.getAllAuthors();
            displayAllAuthors(list);
                        
            String firstName = "Tom";
            String lastName = "Costello";
            int yearBorn = 1952;
            System.out.println("Insert " + AuthorDB.insertAnAuthor(firstName, lastName, yearBorn) + " record(s)");
            displayAllAuthors(AuthorDB.getAllAuthors());
            
         
            id = 3;
            System.out.println("Delete " + AuthorDB.deleteAnAuthor(id) + " record(s)");            
            displayAllAuthors(AuthorDB.getAllAuthors());
                       
            id = 1;
            firstName = "Bort";
            lastName = "Simpson";
            yearBorn = 1994;
            System.out.println("Update " + AuthorDB.updateAnAuthor(id, firstName, lastName, yearBorn) + " record(s)");            
            displayAllAuthors(AuthorDB.getAllAuthors());
            
            
       } catch(SQLException ex) {
           System.out.println(ex);
       }
       finally {
           AuthorDB.closeConnection();
       }
    }//end main

    private static void displayAllAuthors(List<Author> allAuthors) {
        for (Author anAuthor : allAuthors) {
                System.out.println(anAuthor);
        }
    }//end displayAllAuthors

}//end class Main