## Lab Exercise 7️⃣ - JDBC, ResultSet, RowSet and Advanced SQL Exercises.


## Part 1: Using a `ResultSet`

Create an IntelliJ project and add a class with a `main` method. Then, using a `ResultSet`, carry out tasks 1–9 using the **Books** database.

1. For every record (book) in the `titles` table, display the `ISBN`, `Title`, `EditionNumber`, `YearPublished`, `PublisherID` and `Price`, in ascending order by `Title`. There are 22 records that meet this criterion.
2. Display the `Title` and `Price` for all records (books) in the `titles` table where the `Title` contains the word **Java**. There are 8 records that meet this criterion.
3. Display the `Title`, `ISBN` and `YearPublished` for all records (books) in the `titles` table that were published before 1997. There are 3 records that meet this criterion.
4. Display the `Title`, `ISBN` and `YearPublished` for records (books) in the `titles` table that were published between 1994 and 1998. There are 13 records that meet this criterion.
5. Display the average `Price` of a book in the `titles` table. The average is €24.00.
6. Display a count of the records in the `titles` table that have a `Price` greater than or equal to 40. There are 3 records that meet this criterion. **You must use a prepared statement for this query.**

Tasks 1–6 all return a `ResultSet`. Write a method called `displayRecords` that accepts a `ResultSet` as an argument and has a return type of `void`. The method should take the supplied `ResultSet`, display its column names, and then display the details in each row.

7. Execute an SQL statement from within your Java code to add a column called `CopiesSold` to the `titles` table. The column should be of type `DOUBLE`. Once the column has been added, its value in each existing row will be `NULL`.
8. Execute an SQL statement to increase the `Price` of all books in the `titles` table that were published in 1994 or earlier by 10%. **You must use a prepared statement for this query.**
9. Execute an SQL statement from within your Java code to update the `CopiesSold` column in the `titles` table with a random value in the range 0–100. Consider using MySQL's `FLOOR` and `RAND` functions to assist with this task.

## Part 2: Using a `RowSet`

Add another `Main` class to your project. Using a `RowSet`, carry out tasks 10–12 using the **Books** database.

10. Add a complete record to the `authors` table. Invent the data to be inserted.
11. For every ISBN in the `authorisbn` table, display the ISBN along with the corresponding `FirstName` and `LastName` from the `authors` table.
12. For every ISBN in the `authorisbn` table, display the ISBN along with the corresponding `FirstName` and `LastName` from the `authors` table, and the `Title` from the `titles` table.

## Part 3: Queries, Batch Processing and Stored Procedures

Add another `Main` class to your project and carry out tasks 13–16 using the **Books** database.

13. Write a query to determine the most expensive book or books in the `titles` table. Print each book's `Title` and `Price` to the screen.
14. Write a query to determine the oldest book or books in the `titles` table. Print each book's `Title` and `YearPublished` to the screen.
15. Add the following statements to a batch:
    1. Delete all records from the `titles` table that were published before 1993.
    2. Insert a new record into the `publishers` table. Invent the data to be inserted.
    3. Insert two new records into the `titles` table. Invent the data to be inserted, and set the `PublisherID` for both records to the ID of the new publisher inserted in the previous step.
    4. Change the `Price` of all books in the `titles` table that have sold fewer than 10 copies to `0.99`.

    Execute the batch statement and print status information to the screen, indicating how many statements succeeded or failed.

16. Create a stored procedure in the database. The procedure should accept two parameters: a publication year and a publisher ID. It should return all records that match both parameter values. Test or call this procedure from within your Java code.

---

## SQL Tutorial



