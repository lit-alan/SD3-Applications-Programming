package utilities;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan.Ryan
 */
public class Books {

    public static void resetTableInDB() {

        try {

          
              //create the connection object
              //ATTN: username and password must be changed depending on the settings on your database server
              Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");

	      //create a statement object.
	      //We will use this object to carry our query to the database
	      Statement statement = connection.createStatement();

              //define SQL which will delete all records from the authors table
              String deleteSQL = "Delete from authors";

              //execute the sql on the db
              statement.executeUpdate(deleteSQL);

              //define SQL which will insert the 1st record into the db
              String insertSQL = "INSERT INTO authors(AuthorID, FirstName, LastName, YearBorn)VALUES ('1', 'Harvey', 'Deitel', '1946')";

              //execute the sql on the db
              statement.executeUpdate(insertSQL);

              //define SQL which will insert the 2nd record into the db
              insertSQL  = "INSERT INTO authors(AuthorID, FirstName, LastName, YearBorn)VALUES ('2', 'Paul', 'Deitel', '1968')";

              //execute the sql on the db
              statement.executeUpdate(insertSQL);
                            
              //define SQL which will insert the 3rd record into the db
              insertSQL = "INSERT INTO authors(AuthorID, FirstName, LastName, YearBorn)VALUES ('3', 'Tem', 'Nieto', '1969')";

              //execute the sql on the db
              statement.executeUpdate(insertSQL);

        } //end method resetTableInDB()

	catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.exit(0);
	}
    }

}
