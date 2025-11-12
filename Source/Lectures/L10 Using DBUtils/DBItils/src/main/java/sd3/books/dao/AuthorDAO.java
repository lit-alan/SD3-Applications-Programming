package sd3.books.dao;

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
import sd3.books.model.Author;
import sd3.books.model.AuthorTitle;

public class AuthorDAO {
    
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


    /**
     * Retrieves a combined list of book and author data from the database.
     * <p>
     * Executes a join query across the {@code titles}, {@code authorisbn}, and
     * {@code authors} tables, mapping each resulting row to an
     * {@link AuthorTitle} object that contains both book and author details.
     * <p>
     * This method uses Apache Commons DBUtils to execute the query and map the
     * results automatically.
     *
     * @return a list of {@link AuthorTitle} objects, each representing one
     *         book–author combination
     * @throws SQLException if a database access error occurs
     */

    public static List<AuthorTitle> getAuthorsAndTitles() throws SQLException {

        ResultSetHandler<List<AuthorTitle>> handler = new BeanListHandler(AuthorTitle.class);

        String query = """
                        SELECT
                            t.ISBN,
                            t.Title,
                            t.EditionNumber,
                            t.YearPublished,
                            t.PublisherID,
                            t.Price,
                            a.AuthorID,
                            a.FirstName,
                            a.LastName,
                            a.YearBorn
                    FROM titles t
                    INNER JOIN authorisbn ai ON t.ISBN = ai.ISBN
                    INNER JOIN authors a ON ai.AuthorID = a.AuthorID;
                    """;
        return runner.query(connection, query, handler);

    }

    
}//end AuthorDAO