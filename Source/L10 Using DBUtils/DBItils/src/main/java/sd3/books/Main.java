package sd3.books;

import java.sql.SQLException;
import java.util.List;

import sd3.books.dao.AuthorDAO;
import sd3.books.model.Author;
import sd3.utilities.Books;

public class Main {
   
    public static void main(String[] args) throws SQLException {
        try {
            
            Books.resetTableInDB();
            AuthorDAO.doConnection();

//            int id = 2;
//            System.out.println("Print Details for Author With an ID of " + id);
//            System.out.println(AuthorDAO.getAuthorByID(id));
//
////            System.out.println("\nPrint all Authors");
//            List<Author> list = AuthorDAO.getAllAuthors();
//            list.forEach(System.out::println);
//
//            String firstName = "Tom";
//            String lastName = "Costello";
//            int yearBorn = 1952;
//            System.out.println("Insert " + AuthorDAO.insertAnAuthor(firstName, lastName, yearBorn) + " record(s)");
//            AuthorDAO.getAllAuthors().forEach(System.out::println);
//
//            id = 3;
//            System.out.println("Delete " + AuthorDAO.deleteAnAuthor(id) + " record(s)");
//            AuthorDAO.getAllAuthors().forEach(System.out::println);
//
//            id = 1;
//            firstName = "Bort";
//            lastName = "Simpson";
//            yearBorn = 1994;
//            System.out.println("Update " + AuthorDAO.updateAnAuthor(id, firstName, lastName, yearBorn) + " record(s)");
//            AuthorDAO.getAllAuthors().forEach(System.out::println);
//
//           Object[][] params = new Object[][] { { "fred", "perry", 1985 }, { "AN", "Other", 1986 } };
//           int[] values = AuthorDAO.batchAnAuthorInsert(params);
//           System.out.println("Update " + values.length + " record(s)");
//           list = AuthorDAO.getAllAuthors();
//           list.forEach(System.out::println);

//           System.out.println("All Authors After Calling Stored Procedure");
//           list = AuthorDAO.getAllAuthorsByStrProc();
//           list.forEach(System.out::println);
//
//            System.out.println("TOTAL Records: " + AuthorDAO.countRecords());
//
//            System.out.println("Avg of YearBorn: " + AuthorDAO.getYearBornAverage().intValue());
//
//            System.out.println("Sum of YearBorn: " + AuthorDAO.sumYearBorn().intValue());
//
//            System.out.println("Max of YearBorn: " + AuthorDAO.getMaxYearBorn());
//
//            System.out.println("Min of YearBorn: " + AuthorDAO.getMinYearBorn());
//
            AuthorDAO.getAuthorsAndTitles().forEach(System.out::println);
            
        } catch(SQLException ex) {
           System.out.println(ex);
       }
       finally {
           AuthorDAO.closeConnection();
       }
    }//end main

}//end class Main