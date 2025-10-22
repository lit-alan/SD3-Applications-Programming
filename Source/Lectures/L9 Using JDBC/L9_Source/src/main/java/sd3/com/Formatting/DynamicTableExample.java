package sd3.com.Formatting;

import java.sql.*;

//This version prints the contents of the ResultSet to the console neatly as before,
//but will only print a max of 50 characters for the title (47 chars + ...)

public class DynamicTableExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/books";
        String user = "root";
        String password = "";
        try {

            //create the connection object
            //ATTN: username and password must be changed depending on the settings on your database server
            Connection connection = DriverManager.getConnection(url, user, password);

            //create a statement object.
            //We will use this object to carry our query to the database
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //three sample queries to test the display
            String q1 = "SELECT * from titles";
            String q2 = "SELECT Title, EditionNumber, YearPublished, Price from titles";
            String q3 = "SELECT Title, Price from titles";

            ResultSet rs = stmt.executeQuery(q2);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Determine column widths based on the data in teh ResultSet
            int[] columnWidths = new int[columnCount];

            //titleColumnIndex will ne set to -1 if the title col isnt found in the ResultSet
            int titleColumnIndex = -1;

            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnWidths[i - 1] = columnName.length();
                if ("Title".equalsIgnoreCase(columnName)) {
                    titleColumnIndex = i;
                }
            }

            // Check for the width of each row and update columnWidths if necessary
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    if (value != null) {
                        if (i == titleColumnIndex && value.length() > 50) {
                            value = value.substring(0, 47) + "...";
                        }
                        columnWidths[i - 1] = Math.max(columnWidths[i - 1], value.length());
                    }
                }
            }

            if (titleColumnIndex == -1) {
                throw new SQLException("Title column not found in the result set");
            }

            // Reset cursor for printing
            rs.beforeFirst();

            // Printing the table
            printTableHeader(rsmd, columnWidths);
            printTableSeparator(columnWidths);

            while (rs.next()) {
                printRow(rs, columnWidths, titleColumnIndex);
            }

            printTableSeparator(columnWidths);

        }//end try
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void printTableHeader(ResultSetMetaData rsmd, int[] columnWidths) throws SQLException {
        for (int i = 1; i <= columnWidths.length; i++) {
            System.out.printf("| %-" + columnWidths[i - 1] + "s ", rsmd.getColumnName(i));
        }
        System.out.println("|");
    }

    private static void printRow(ResultSet rs, int[] columnWidths, int titleColumnIndex) throws SQLException {
        for (int i = 1; i <= columnWidths.length; i++) {
            String value = rs.getString(i);
            if (value != null && i == titleColumnIndex && value.length() > 50) {
                value = value.substring(0, 47) + "...";
            }
            System.out.printf("| %-" + columnWidths[i - 1] + "s ", value != null ? value : "");
        }
        System.out.println("|");
    }

    private static void printTableSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("+");
            for (int i = 0; i < width + 2; i++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }
}