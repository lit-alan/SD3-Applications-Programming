package sd3.com.UsingRowSets;

import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import utilities.Books;

public class CompleteRowSetExample {

    static String results = "";

    public static void main(String[] args) {
        JdbcRowSet rowSet = null;

        try {
             Books.resetTableInDB();

            //use a factory object to get our hands on a RowSet
            RowSetFactory factory = RowSetProvider.newFactory();
            rowSet = factory.createJdbcRowSet();

            //set values for the RowSet (inc the query)
            rowSet.setUrl("jdbc:mysql://localhost:3306/books");
            rowSet.setUsername("sduser");
            rowSet.setPassword("pass");

            rowSet.setCommand("SELECT * FROM authors");
            rowSet.execute();

       
            displayRowSet(rowSet, "Before update: Display All Records");

            //////////////////////////////////////////////////////////////////
            //position cursor on second row and delete it
            rowSet.absolute(2);
            rowSet.deleteRow();
            rowSet.beforeFirst();
            displayRowSet(rowSet, "After delete: Display All Records");

            //////////////////////////////////////////////////////////////////
            //position the cursor to the first row and update the FirstName of the author to Rex
            rowSet.absolute(1);
            rowSet.updateString("FirstName", "Rex");
            rowSet.updateRow();
            rowSet.beforeFirst();

            displayRowSet(rowSet, "After update: Display All Records");

            //////////////////////////////////////////////////////////////////
            //move the cursor to the end of the rowset and insert a new row
            rowSet.moveToInsertRow();
            rowSet.updateInt("AuthorID", 14);
            rowSet.updateString("FirstName", "Bertie");
            rowSet.updateString("LastName", "Ahern");
            rowSet.updateInt("YearBorn", 1964);
            rowSet.insertRow();
            rowSet.beforeFirst();

            displayRowSet(rowSet, "After insertion: Display All Records");

            //////////////////////////////////////////////////////////////////
        
        } catch (SQLException sqlex) {
            System.out.println("Comms error " + sqlex);
        }//end catch
        
        finally {
            try {
                rowSet.close();
            } catch (SQLException sqlex) {
                System.out.println("Error cleaning up " + sqlex);
            }

        }//end finally 

    }//end main

    private static void displayRowSet(JdbcRowSet rowSet, String message) throws SQLException {
       
        results = message + "\n";
        
        while (rowSet.next()) {
            for (int i = 1; i < 4; i++) {
                results += rowSet.getString(i) + "\t\t";
                
            }//end for
            results += "\n";

        }//end while

        System.out.println(results);

    }

}
