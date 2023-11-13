package sd3.com;

import java.sql.SQLException;
import java.util.List;
import sd3.utilities.Books;

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
            list.forEach(System.out::println);

            String firstName = "Tom";
            String lastName = "Costello";
            int yearBorn = 1952;
            System.out.println("Insert " + AuthorDB.insertAnAuthor(firstName, lastName, yearBorn) + " record(s)");
            AuthorDB.getAllAuthors().forEach(System.out::println);

            id = 3;
            System.out.println("Delete " + AuthorDB.deleteAnAuthor(id) + " record(s)");
            AuthorDB.getAllAuthors().forEach(System.out::println);

            id = 1;
            firstName = "Bort";
            lastName = "Simpson";
            yearBorn = 1994;
            System.out.println("Update " + AuthorDB.updateAnAuthor(id, firstName, lastName, yearBorn) + " record(s)");
            AuthorDB.getAllAuthors().forEach(System.out::println);

           Object[][] params = new Object[][] { { "fred", "perry", 1985 }, { "AN", "Other", 1986 } };
           int[] values = AuthorDB.batchAnAuthorInsert(params);
           System.out.println("Update " + values.length + " record(s)");
           list = AuthorDB.getAllAuthors();
           list.forEach(System.out::println);

           System.out.println("All Authors After Calling Stored Procedure");
           list = AuthorDB.getAllAuthorsByStrProc();
           list.forEach(System.out::println);

            System.out.println("TOTAL Records: " + AuthorDB.countRecords());

            System.out.println("Avg of YearBorn: " + AuthorDB.getYearBornAverage().intValue());

            System.out.println("Sum of YearBorn: " + AuthorDB.sumYearBorn().intValue());

            System.out.println("Max of YearBorn: " + AuthorDB.getMaxYearBorn());

            System.out.println("Min of YearBorn: " + AuthorDB.getMinYearBorn());

            AuthorDB.getAuthorsAndTitles().forEach(System.out::println);
            
        } catch(SQLException ex) {
           System.out.println(ex);
       }
       finally {
           AuthorDB.closeConnection();
       }
    }//end main

}//end class Main