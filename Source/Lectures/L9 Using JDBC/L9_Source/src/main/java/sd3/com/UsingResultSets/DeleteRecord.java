package sd3.com.UsingResultSets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {

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

            String deletetSQL = "Delete from authors WHERE LastName = 'Watson'";

            int rowCount = statement.executeUpdate(deletetSQL);

            System.out.println(rowCount + " row deleted\n");

            //exexute our query, which will lead to the return of a resultset
            ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");

            ResultSetMetaData metaData = resultSet.getMetaData();

            String colHeadings = "";
            int numberOfColumns = metaData.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                colHeadings += metaData.getColumnName(i) + "\t";
            }

            System.out.println(colHeadings);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fName = resultSet.getString("FirstName");
                String lName = resultSet.getString(3);
                int year = resultSet.getInt(4);
                System.out.println(id + "\t\t\t" + fName + "\t\t" + lName + "\t\t" + year);
            }//end try

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
    }//end main
}//end class