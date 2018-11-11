package sd3.com.CallingStoredProcedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import utilities.Books;

public class DisplayAllRecords {

    public static void main(String[] args) {

        String results = "";
        Connection connection = null;

        try {

            Books.resetTableInDB();

            //create the connection object
            //ATTN: username and password must be changed depending on the settings on your database server
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");

            CallableStatement callableStatement
                    = connection.prepareCall("{call getAllAuthors()}");

            ResultSet resultSet = callableStatement.executeQuery();

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

        }//end try
        catch (SQLException sqlex) {
            System.out.println("Comms error " + sqlex);
        }//end catch
        finally {
            try {
                connection.close();
            } catch (SQLException sqlex) {
                System.out.println("Error cleaning up " + sqlex);
            }

        }//end finally 
        System.out.println(results);

    }//end main
}
