package Lecture5;

// AssignGrade.java: Assign grade
import java.util.Scanner;
import javax.swing.*;

public class AssignGrade {

    /**
     * Main method
     */
    public static void main(String[] args) {
        int numOfStudents = 0; // The number of students
        int[] scores; // Array scores
        char grade = ' '; // The grade
        String output = "";

        Scanner sc = new Scanner(System.in);

        // Get number of students
        System.out.println("Please enter number of students");
        numOfStudents = sc.nextInt();

        // Create array scores
        scores = new int[numOfStudents];

        // Read scores and find the best score
        //JOptionPane.showMessageDialog(null"Please enter " + numOfStudents + " scores");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Enter Score " + (i + 1));
            scores[i] = sc.nextInt();

        }//end for

        // Assign and display grades
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 85) {
                grade = 'A';
            } else if (scores[i] <= 84 && scores[i] >= 70) {
                grade = 'B';
            } else if (scores[i] <= 69 && scores[i] >= 50) {
                grade = 'C';
            } else if (scores[i] <= 49 && scores[i] >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            output += "Student " + (i + 1) + "'s score is " + scores[i] + " and grade is " + grade + "\n";

        }//end for

        System.out.println(output);
        System.exit(0);

    }//end main

}//end class AssignGrade
