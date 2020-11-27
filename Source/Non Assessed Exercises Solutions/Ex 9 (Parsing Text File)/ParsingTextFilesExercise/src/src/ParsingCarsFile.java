package src;
// ParsingTextFile.java: Process text file using StreamTokenizer

import java.io.*;

public class ParsingCarsFile {
  
    /**Main method*/
  public static void main(String[] args) {
    // Declare file reader and writer streams
    FileReader frs = null;
    FileWriter fws = null;

    // Declare streamTokenizer
    StreamTokenizer in = null;

    // Declare a print stream
    PrintWriter out = null;

    // temp location of the car
    String location = "";
    
    // temp vars for avg computation
    double limerickTotal = 0;
    double corkTotal = 0;
    double dublinTotal = 0;
    int limerickCount = 0;
    int dublinCount = 0;
    int corkCount = 0;
    
    // to hold the avg price of cars in various locations
    double limerickAvg = 0;
    double dublinAvg = 0;
    double corkAvg = 0;
    
    try     {
      // Create file input and output streams
      frs = new FileReader("cars.txt");
      fws = new FileWriter("projections.txt");

      // Create a stream tokenizer wrapping file input stream
      in = new StreamTokenizer(frs);
      out = new PrintWriter(fws);

      //set the - character as a "ordinary" char
      in.ordinaryChar('-');
      
      // Read past col headings.
      in.nextToken();in.nextToken();in.nextToken();in.nextToken();
      in.nextToken();in.nextToken();in.nextToken();in.nextToken();
      
      //read first token of first row (YEAR OF CAR)
      in.nextToken();
      
      
      // Process a record
      while (in.ttype != StreamTokenizer.TT_EOF)     {
        
        //read second token (the first -)
        in.nextToken();
      
        //re ad THIRD (County Code) FOURTH (Second - ) AND FIFTH (Reg Num) tokens
        in.nextToken(); in.nextToken(); in.nextToken();
    
        //read SIXH token (MAKE OF CAR)
        in.nextToken();
      
        //read SEVENTH token (MODEL OF CAR)
        in.nextToken();

        //read EIGHT token (COLOUR OF CAR)
        in.nextToken();            

        //read NINTH token (LOCATION OF CAR)
        in.nextToken();  
        if (in.ttype == StreamTokenizer.TT_WORD)
            location = in.sval;
        else
            System.out.println("Bad file structure");
        
        //read TENTH token (PRICE OF CAR)
        in.nextToken(); 
        if (in.ttype != StreamTokenizer.TT_NUMBER)
          System.out.println("Bad file structure");
        
        
        
        if (location.equalsIgnoreCase("Limerick")) {
            limerickCount++;
            limerickTotal += in.nval;
        }
        else if (location.equalsIgnoreCase("Dublin")) {
            dublinCount++;
            dublinTotal+= in.nval;
        }
        else {
            corkCount++;
            corkTotal+= in.nval;
        }
    
        //read ELEVENTH token (OWNERS OF CAR)
        in.nextToken();            

        //read TWELFTH token (MILEAGE OF CAR)
        in.nextToken();  
        
        //read next token of the next line in the file 
        //while there are records in the file this will return the year of the car
        //otherwise it will return EOF
        in.nextToken();  
      }
      
      //compute avg prices in the three locations
      limerickAvg = limerickTotal / limerickCount;
      dublinAvg = dublinTotal / dublinCount;
      corkAvg = corkTotal / corkCount;
      
      //print info to second file
      out.println("Location    \tAveragePrice");
      out.println("Dublin    " + "\t " + dublinAvg);
      out.println("Cork      " + "\t " + corkAvg);
      out.println("Limerick  " + "\t " + limerickAvg);
      
      
      System.out.println("Parsing file complete  - check projections.dat for summary information");

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