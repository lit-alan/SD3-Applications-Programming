package supplementary_exercises;

import java.util.Arrays;
import java.util.Random;

public class Exercise2 {

        //application constants
    final static int NUMBER_OF_TICKETS = 5000; //number of tickets to generate
    final static int RANGE_OF_NUMBERS = 46; //generates numbers in range 0 - 45
    final static int MAX_NUMBER_SELECTION = 6; //6 numbers per ticket

    public static void main(String[] args) {

        Random r = new Random();
        
        //arrays to store application data
        int[][] tickets = new int[NUMBER_OF_TICKETS][MAX_NUMBER_SELECTION];
        String[] ticketNumbers = new String[NUMBER_OF_TICKETS];
        int[] winningNumbers = new int[MAX_NUMBER_SELECTION];
        int[] mostPayed = new int[RANGE_OF_NUMBERS];
        boolean[] usedNumbers = new boolean[RANGE_OF_NUMBERS];
        
        //array to help generate ticket number
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        
        //fill most played array with 0's
        Arrays.fill(mostPayed, 0);

        //start calling the methods to run the application
        generateTicketNumbers(r, alphabet, ticketNumbers);

        generateLottoNumbers(usedNumbers, r, tickets);

        sortLottoNumbersOnTicket(tickets);

        generateWinningTicket(usedNumbers, r, winningNumbers);

        //sort numbers in winning ticket
        Arrays.sort(winningNumbers); 

        displayTickets(ticketNumbers, tickets);
       
        System.out.println("\nWinning Numbers Are: " + Arrays.toString(winningNumbers) + "\n");

        checkForWinner(tickets, winningNumbers, ticketNumbers);
        
        
        calculateNumberFrequency(tickets, mostPayed);
        
        displayedFrequency(mostPayed);
        
        

    }//end main

    ///////////////////////////////////////////////////////////////////////////
    //generate the numbers for each ticket
    ///////////////////////////////////////////////////////////////////////////
    private static void generateLottoNumbers(boolean[] usedNumbers, Random r, int[][] tickets) {

        int generatedNum = 0;
        Arrays.fill(usedNumbers, false);
        
        for (int row = 0; row < NUMBER_OF_TICKETS; row++) {
            for (int col = 0; col < MAX_NUMBER_SELECTION; col++) {
                
                do {
                    generatedNum = r.nextInt(RANGE_OF_NUMBERS);
                    
                    if (generatedNum ==0)
                        generatedNum++;
                    
                } while (usedNumbers[generatedNum] == true);
                
                tickets[row][col] = generatedNum;
                usedNumbers[generatedNum] = true;
                
            }//end for
            
            generatedNum = 0;
            Arrays.fill(usedNumbers, false); 
        }//end for
    }//end method generateLottoNumbers
    
    ///////////////////////////////////////////////////////////////////////////
    //generate ticket numbers
    ///////////////////////////////////////////////////////////////////////////
    private static void generateTicketNumbers(Random r, char[] alphabet, String[] ticketNumbers) {

        String tNum;
        for (int j = 0; j < NUMBER_OF_TICKETS; j++) {
            tNum = "" + r.nextInt(100);
            for (int i = 0; i <= 3; i++) {
                tNum += alphabet[r.nextInt(26)];
            }//end inner for
            
            ticketNumbers[j] = tNum;
            
        }//end outer for
    }//end method generateTicketNumbers
    
    ///////////////////////////////////////////////////////////////////////////
    //generate winning ticket
    ///////////////////////////////////////////////////////////////////////////
    private static void generateWinningTicket(boolean[] usedNumbers, Random r, int[] winningNumbers) {
        int generatedNum;
        
        Arrays.fill(usedNumbers, false);
        generatedNum = 0;
        for (int i = 0; i < MAX_NUMBER_SELECTION; i++) {
            do {
                generatedNum = r.nextInt(RANGE_OF_NUMBERS);
                if (generatedNum ==0)
                    generatedNum++;
            } while (usedNumbers[generatedNum] == true);
            winningNumbers[i] = generatedNum;
            usedNumbers[generatedNum] = true;
        }//end for
    }//end method generateWinningTicket
    
    ///////////////////////////////////////////////////////////////////////////
    //display each ticket number and its associated numbers
    ///////////////////////////////////////////////////////////////////////////
    private static void displayTickets(String[] ticketNumbers, int[][] tickets) {

        for (int row = 0; row < NUMBER_OF_TICKETS; row++) {
            System.out.print("Ticket " + ticketNumbers[row] + ": ");
            for (int col = 0; col < MAX_NUMBER_SELECTION; col++) {
                System.out.print(tickets[row][col] + " ");
                
            }//end inner for
            System.out.println("");
            
        }//end outer for
    
    }//end method displayTickets
    
    /////////////////////////////////////////////////////////////////////////// 
    //check for a winner - if there is a winner output its ticket number
    ///////////////////////////////////////////////////////////////////////////
    private static void checkForWinner(int[][] tickets, int[] winningNumbers, String[] ticketNumbers) {
        int currentNumber, countMatches = 0;
        boolean winner = false;
        for (int row = 0; row < NUMBER_OF_TICKETS; row++) {

            for (int col = 0; col < MAX_NUMBER_SELECTION; col++) {

                currentNumber = tickets[row][col];

                if ((currentNumber == winningNumbers[0]) || (currentNumber == winningNumbers[1]) || (currentNumber == winningNumbers[2]) || (currentNumber == winningNumbers[3]) || (currentNumber == winningNumbers[4]) || (currentNumber == winningNumbers[5])) {
                    countMatches++;
                }//end if

            }//end for

            if (countMatches == MAX_NUMBER_SELECTION) {
                System.out.println("Winning ticket number is " + ticketNumbers[row]);
                winner = true;
            }//end if

            countMatches = 0;

        }//end for
        
        if (!winner)
            System.out.println("\n*****There was no winner this time****\n");
        
    }//end method checkForWinner

    /////////////////////////////////////////////////////////////////////////// 
    //calculate the frequency of each number in the draw
    ///////////////////////////////////////////////////////////////////////////
    public static void calculateNumberFrequency(int numbers[][], int mostPlayed[]) {
        
        System.out.println("\n");

        for (int row = 0; row < NUMBER_OF_TICKETS; row++) {

            for (int col = 0; col < MAX_NUMBER_SELECTION; col++) {
                
                int n = numbers[row][col];
                
                mostPlayed[n]++;

            }//end for
        }//end for

    }//end method calculateNumberFrequency

    /////////////////////////////////////////////////////////////////////////// 
    //sort each ticket into ascending order
    /////////////////////////////////////////////////////////////////////////// 
    public static void sortLottoNumbersOnTicket(int numbers[][]) {
        for (int[] row : numbers) {
            Arrays.sort(row);
        }//end for
    }//end method sortLottoNumbersOnTicket

   
    
    /////////////////////////////////////////////////////////////////////////// 
    //display the frequency of each number in the draw
    /////////////////////////////////////////////////////////////////////////// 
    private static void displayedFrequency(int[] mostPayed) {
        for (int i =1; i < mostPayed.length; i++) {
            
            System.out.println(i + " was drawn " + mostPayed[i] + " times");
        }//end for
    }//end method displayedFrequency
    
}
