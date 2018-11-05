package sd3.com.UsingRowSets;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import utilities.Books;

public class DisplayRecordsUsingRowSet {

    public static void main(String[] args) {

        JdbcRowSet rowSet = null;
        String results = "";

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

            //get the meta data as before
            ResultSetMetaData metaData = rowSet.getMetaData();

            int numberOfColumns = metaData.getColumnCount();

            for (int i = 1; i < numberOfColumns; i++) {
                results += metaData.getColumnName(i) + "\t";
            }

            results += "\n";

            //iterate over the RowSet
            while (rowSet.next()) {
                for (int i = 1; i < numberOfColumns; i++) {
                    results += rowSet.getString(i) + "\t\t";
                }//end for

                results += "\n";
            }//end while

        }//end try
        catch (SQLException sqlex) {
            System.out.println("Comms error " + sqlex);
        }//end catch
        
        finally {
            try {
                rowSet.close();
            } catch (SQLException sqlex) {
                System.out.println("Error cleaning up " + sqlex);
            }

        }//end finally 
        System.out.println(results);
    
    }//end main

}//end class