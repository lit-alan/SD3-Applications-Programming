package sd3.com.UsingResultSets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UpdateRecord {

    public static void main(String[] args) {

        ArrayList<Author> authorList = new ArrayList();
        Connection connection = null;
        Statement statement = null;

        try {

            //create the connection object
            //ATTN: username and password must be changed depending on the settings on your database server
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");

            //create a statement object.
            //We will use this object to carry our query to the database
            statement = connection.createStatement();

            String fNAme = "Brendan";
            String lName = "Watson";
            int year = 1967;
            String criteria = "Guinane";

           // String updatetSQL = "UPDATE authors SET FirstName = 'Brendan', LastName = 'Watson', YearBorn = '1967'  WHERE LastName = 'Guinane'";
           String updatetSQL = "UPDATE authors SET FirstName = '" + fNAme + "', LastName = '" + lName + "', " +
                   "YearBorn = '" + year + "'  WHERE LastName = '" + criteria + "'";

            System.out.println(updatetSQL);


            int rowCount = statement.executeUpdate(updatetSQL);

            System.out.println(rowCount + " row updated\n");

            //exexute our query, which will lead to the return of a resultset
            ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");

            ResultSetMetaData metaData = resultSet.getMetaData();

            //int numberOfColumns = metaData.getColumnCount();

            System.out.printf("%-10s %-15s %-15s %-10s%n",
                    metaData.getColumnName(1),
                    metaData.getColumnName(2),
                    metaData.getColumnName(3),
                    metaData.getColumnName(4));

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString(3);
                int yob = resultSet.getInt(4);

                Author a = new Author(id, firstName, lastName, year);
                authorList.add(a);

                System.out.printf("%-10d %-15s %-15s %-10d%n", id, a.getFirstName(), a.getLastName(), a.YearBorn);


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