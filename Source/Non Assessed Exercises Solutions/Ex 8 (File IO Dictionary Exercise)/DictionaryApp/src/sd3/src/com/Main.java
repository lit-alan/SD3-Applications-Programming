package sd3.src.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alan.Ryan
 */
public class Main {

    //const to dictate how many words I will generate
    static final int NUMBER_OF_WORDS = 200_000;
                                  
    
    //array to store the letters of the alphabet - used to generate 4 letter words
    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
    //List to store my generated words
    static List<String> generatedWords = new ArrayList(NUMBER_OF_WORDS);
    
    //List to store the words from my dictionary
    //These words will be read from a file
    static List<String> dictionaryWords;
    
    //List to store any words I generate that are found in the dictionary
    static List<String> matches = new ArrayList();

    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Generate random words
        ////////////////////////////////////////////////////////////////////////////////////////////////
        
        String aWord = "";

        Random r = new Random();

        for (int j = 0; j < NUMBER_OF_WORDS; j++) {
            for (int i = 0; i <= 3; i++) {
                aWord += String.valueOf(alphabet[r.nextInt(26)]);
            }//end inner for

            generatedWords.add(aWord);

            aWord = "";

        }//end outer for

        //remove and duplicates from the generatedWords List and store the unique words in a collection called generatedWordsNoDups
        Collection<String> generatedWordsNoDups = new HashSet(generatedWords);
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        //Read the words from the dictionary (file) into an ArrayList
        ////////////////////////////////////////////////////////////////////////////////////////////
        
        
        //create a path to the file that store my words in the dictionary
        Path pathToFile = Paths.get("dictionary.txt");

        try {
            //read all lines(words) from the file into the ArrayList
            dictionaryWords = Files.readAllLines(pathToFile);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        //tell the user how many words are in my dictionary
        System.out.println(dictionaryWords.size() + " words in my dictionary");

        ////////////////////////////////////////////////////////////////////////////////////////////////
        //Add the generated words that are found in the dictionary to another list called matches
        ////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println(generatedWordsNoDups.size() + " words generated (duplicated removed)");
        
        //iterate over the generatedWords list and check if each word in it is within the dictionaryWords list
        for (String s : generatedWordsNoDups) {
            if (dictionaryWords.contains(s)) {
                matches.add(s); //add the matched word to the matches ArrayList
            }
        }

      
        //do output
        if (matches.size() > 0) {
            System.out.println("There were " + matches.size() + " generated word(s) found in the dictionary and they are (duplicates removed)\n");
            System.out.println(matches);
        } else {
            System.out.println("No matches found");
        }
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        
        System.out.println("\nExecution time " + duration + "ms");
        System.exit(0);

    }

}
