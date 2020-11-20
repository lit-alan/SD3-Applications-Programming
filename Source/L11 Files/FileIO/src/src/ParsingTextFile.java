package src;

// ParsingTextFile.java: Process text file using StreamTokenizer

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


public class ParsingTextFile {
  /**Main method*/
  public static void main(String[] args) {
    // Declare file reader and writer streams
      
                  
    FileReader frs = null;
    FileWriter fws = null;

    // Declare streamTokenizer
    StreamTokenizer in = null;

    // Declare a print stream
    PrintWriter out = null;

    // Four input file fields: student name, midterm1,
    // midterm2, and final exam score
    String sname = null;
    double midterm1 = 0;
    double midterm2 = 0;
    double finalScore = 0;

    // Computed total score
    double total = 0;

    try     {
      // Create file input and output streams
      frs = new FileReader("in.dat");
      fws = new FileWriter("out.dat");

      // Create a stream tokenizer wrapping file input stream
      in = new StreamTokenizer(frs);
      out = new PrintWriter(fws);

   
      // Read first token
      in.nextToken();

      // Process a record
      while (in.ttype != StreamTokenizer.TT_EOF)     {
        // Get student name
        if (in.ttype == StreamTokenizer.TT_WORD)
          sname = in.sval;
        else
          System.out.println("Bad file format");

        // Get midterm1
        if (in.nextToken() == StreamTokenizer.TT_NUMBER)
          midterm1 = in.nval;
        else
          System.out.println("Bad file format");

        // Get midterm2
        if (in.nextToken() == StreamTokenizer.TT_NUMBER)
          midterm2 = in.nval;
        else {
            System.out.println("Bad file format");
            
        }
        // Get final score
        if (in.nextToken() == StreamTokenizer.TT_NUMBER)
          finalScore = in.nval;
        else 
          System.out.println("Bad file format");
        
        
        total = midterm1*0.3 + midterm2*0.3 + finalScore*0.4;
        out.println(sname + " " + total);

        in.nextToken();
      }
    }
    catch (FileNotFoundException ex)   {
      System.out.println("File not found: in.dat");
    }
    catch (IOException ex)   {
      System.out.println(ex.getMessage());
    }
    finally   {
      try     {
        if (frs != null) frs.close();
        if (fws != null) fws.close();
      }
      catch (IOException ex)  {
        System.out.println(ex);
      }
    }
  }
}