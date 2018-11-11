package sd3.com.usingDBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class AuthorDB {
    
    static Connection connection;
    static QueryRunner runner;
        
    ///////////////////////////////////////////////////////////////////////////////////
    public static void doConnection() {
        try {
            //connect to DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "");
            //create runner
            runner = new QueryRunner();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//end doConnection
    
    ///////////////////////////////////////////////////////////////////////////////////
    public static void closeConnection() {
        try {
            DbUtils.close(connection);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//end closeConnection
    
    ///////////////////////////////////////////////////////////////////////////////////
    public static Author getAuthorByID(int id) throws SQLException {
        ResultSetHandler<Author> handler = new BeanHandler(Author.class);
        return runner.query(connection, "SELECT * FROM authors WHERE AuthorID = ?", handler, id);
    }//end getAuthorByID
    
    ///////////////////////////////////////////////////////////////////////////////////
    public static List<Author> getAllAuthors() throws SQLException {
        
        //my handler will convert rows in the DB to Author objects and place them in a list
        ResultSetHandler<List<Author>> handler = new BeanListHandler(Author.class);
        
        //execute the query and populate the list
        List<Author> list = runner.query(connection, "SELECT * FROM authors", handler);
        
        return list;
    }//end getAllAuthors
    
    ///////////////////////////////////////////////////////////////////////////////////    
    public static int insertAnAuthor(String firstName, String lastName, int yearBorn) throws SQLException {
    
        return runner.update(connection,"INSERT INTO authors (LastName, FirstName,YearBorn) VALUES (?,?,?)",
                                                                                firstName, lastName,yearBorn);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    public static int deleteAnAuthor(int id) throws SQLException {
        return runner.update(connection,"DELETE FROM authors WHERE AuthorID = ?", id);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    public static int updateAnAuthor(int id, String firstName, String lastName, int yearBorn) throws SQLException {
    
     return runner.update(connection,"UPDATE authors SET FirstName=?,LastName=?, YearBorn =?  WHERE AuthorID=?",
                                                                                firstName, lastName,yearBorn,id );
    }  
}//end AuthorDB