package sd3.com.usingDBUtils;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
        
        //my handler will convert rows in the ResultSet to Author objects and place them in a list
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

     ///////////////////////////////////////////////////////////////////////////////////
    static int[] batchAnAuthorInsert(Object [][] params) throws SQLException {
            return runner.batch(connection, "INSERT INTO authors (FirstName, LastName,YearBorn) VALUES (?,?,?)", params);
    }
    
     ///////////////////////////////////////////////////////////////////////////////////
    
    public static List<Author> getAllAuthorsByStrProc() throws SQLException {
       //create the callable statement
       CallableStatement callableStatement = 
               connection.prepareCall("{call getAllAuthors()}");
             
       //my handler will convert rows in the ResultSet to Author objects and place them in a list
       ResultSetHandler<List<Author>> handler = new BeanListHandler(Author.class);
       
       //return a list<Author> 
       return handler.handle(callableStatement.executeQuery());
    }
    
    public static Long countRecords() throws SQLException {

        //for queries that return a single value, use a ScalarHandler
        //the SQL count function returns a Long
        ScalarHandler<Long> handler = new ScalarHandler();

        //execute the query
        return runner.query(connection, "SELECT COUNT(*) FROM authors", handler);
    }

    public static BigDecimal getYearBornAverage() throws SQLException {

        //for queries that return a single value, use a ScalarHandler
        //the SQL AVG function returns a BigDecimal
        ScalarHandler<BigDecimal> handler = new ScalarHandler();

        //execute the query
        return runner.query(connection, "SELECT AVG(YearBorn) FROM authors", handler);
    }
    
    public static BigDecimal sumYearBorn() throws SQLException {

        //for queries that return a single value, use a ScalarHandler
        //the SQL SUM function returns a BigDecimal
        ScalarHandler<BigDecimal> handler = new ScalarHandler();

        //execute the query
        return runner.query(connection, "SELECT SUM(YearBorn) FROM authors", handler);
    }
    
      public static Integer getMaxYearBorn() throws SQLException {

        //for queries that return a single value, use a ScalarHandler
        //the SQL MAX function returns an Integer
        ScalarHandler<Integer> handler = new ScalarHandler();

        //execute the query
        return runner.query(connection, "SELECT MAX(YearBorn) FROM authors", handler);
    }
      
    public static Integer getMinYearBorn() throws SQLException {

        //for queries that return a single value, use a ScalarHandler
        //the SQL MIN function returns an Integer
        ScalarHandler<Integer> handler = new ScalarHandler();

        //execute the query
        return runner.query(connection, "SELECT MIN(YearBorn) FROM authors", handler);
    }
    
}//end AuthorDB