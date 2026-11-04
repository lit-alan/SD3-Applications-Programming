
package sd3.com.UsingRowSets;

import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import utilities.Books;

public class CompleteRowSetExample {

    public static void main(String[] args) {

        try {
            //reset the authors table before starting
            Books.resetTableInDB();

            //create a JdbcRowSet using a RowSetFactory
            RowSetFactory factory = RowSetProvider.newFactory();

            //create a JdbcRowSet (automatically closed when finished)
            try (JdbcRowSet rowSet = factory.createJdbcRowSet()) {

                //configure the database connection
                rowSet.setUrl("jdbc:mysql://localhost:3306/books");
                rowSet.setUsername("root");
                rowSet.setPassword("");

                //specify and execute the SQL query
                rowSet.setCommand("SELECT * FROM authors");
                rowSet.execute();

                //display all authors before making changes
                displayRowSet(rowSet, "Before update");

                //delete the second author
                rowSet.absolute(2);
                rowSet.deleteRow();
                rowSet.beforeFirst();

                displayRowSet(rowSet, "After deleting second author");

                //update the first author's details
                rowSet.absolute(1);
                rowSet.updateString("FirstName", "Rex");
                rowSet.updateString("LastName", "Watson");
                rowSet.updateInt("YearBorn", 1999);
                rowSet.updateRow();
                rowSet.beforeFirst();

                displayRowSet(rowSet, "After updating first author");

                //move to the special insert row and create a new author
                rowSet.moveToInsertRow();

                rowSet.updateInt("AuthorID", 14);
                rowSet.updateString("FirstName", "Bertie");
                rowSet.updateString("LastName", "Ahern");
                rowSet.updateInt("YearBorn", 1964);

                rowSet.insertRow();

                //return to the original cursor position
                rowSet.moveToCurrentRow();
                rowSet.beforeFirst();

                displayRowSet(rowSet, "After inserting new author");
            }

            //RowSet is automatically closed due to try-with-resources statement

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    /**
     * Displays all records currently contained in the JdbcRowSet.
     * Iterates through the records using the next() method and
     * prints the AuthorID, FirstName, LastName and YearBorn columns.
     *
     * @param rowSet the JdbcRowSet containing the author records
     * @param heading the heading to display above the records
     * @throws SQLException if a database access error occurs
     */
    private static void displayRowSet(JdbcRowSet rowSet, String heading)
            throws SQLException {

        System.out.println("\n" + heading);
        System.out.println("----------------------------------------");

        while (rowSet.next()) {

            System.out.println(
                    rowSet.getInt("AuthorID") + "\t" +
                            rowSet.getString("FirstName") + "\t" +
                            rowSet.getString("LastName") + "\t" +
                            rowSet.getInt("YearBorn")
            );
        }

        System.out.println();
    }
}
