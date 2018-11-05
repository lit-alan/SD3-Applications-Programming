package sd3.com.UsingResultSets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {

    public static void main(String[] args) {
        String results = "";
        Connection connection = null;
        Statement statement = null;

        try {

            //create the connection object
            //ATTN: username and password must be changed depending on the settings on your database server
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");

            //create a statement object.
            //We will use this object to carry our query to the database
            statement = connection.createStatement();

            String updatetSQL = "UPDATE authors SET FirstName = 'Brendan', LastName = 'Watson', YearBorn = '1967'  WHERE LastName = 'Guinane'";

            int rowCount = statement.executeUpdate(updatetSQL);

            System.out.println(rowCount + " row updated\n");

            //exexute our query, which will lead to the return of a resultset
            ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");

            ResultSetMetaData metaData = resultSet.getMetaData();

            int numberOfColumns = metaData.getColumnCount();

            for (int i = 1; i < numberOfColumns; i++) {
                results += metaData.getColumnName(i) + "\t";
            }

            results += "\n";

            while (resultSet.next()) {
                for (int i = 1; i < numberOfColumns; i++) {
                    results += resultSet.getObject(i) + "\t\t";
                }//end for

                results += "\n";
            }//end while

        } catch (SQLException sqlex) {
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