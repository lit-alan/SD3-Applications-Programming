package sd3.com.UsingResultSets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utilities.Books;

public class DisplayRecords {

    public static void main(String[] args) {

        String results = "";
        Connection connection = null;
        Statement statement = null;

        try {

            Books.resetTableInDB();
            
            //create the connection object
            //ATTN: username and password must be changed depending on the settings on your database server
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "");

            //create a statement object.
            //We will use this object to carry our query to the database
            statement = connection.createStatement();

            //exexute our query, which will lead to the return of a resultset
            ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");
//
//            ResultSetMetaData metaData = resultSet.getMetaData();
//
//            int numberOfColumns = metaData.getColumnCount();
//
//            for (int i = 1; i < numberOfColumns; i++) {
//                results += metaData.getColumnName(i) + "\t";
//            }


            results += "\n";

            List<Author> aList = new ArrayList<>();

            while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String fName = resultSet.getString(2);
                    String lName = resultSet.getString(3);
                    int year = resultSet.getInt(4);
                    Author a = new Author(id, fName, lName, year);
                    aList.add(a);
//
//                for (int i = 1; i <= 4; i++) {
//                    results += resultSet.getObject(i) + "\t\t";
//                }//end for
//
//                results += "\n";
            } //end while

            aList.forEach(System.out::println);
        }//end try
        catch (SQLException sqlex) {
            System.out.println("Comms error " + sqlex);
        }//end catch
        finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException sqlex) {
                System.out.println("Error cleaning up " + sqlex);
            }

        }//end finally 
        System.out.println(results);

    }//end main
}//end class