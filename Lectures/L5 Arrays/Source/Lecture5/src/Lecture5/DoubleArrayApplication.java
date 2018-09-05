package Lecture5;

import java.util.Scanner;

public class DoubleArrayApplication {

    static int grades[][] = {{77, 68, 86, 73},
    {76, 87, 89, 81},
    {70, 90, 86, 81},
    {34, 56, 79, 67}};

    static String names[] = {"Alan", "John", "Aoife", "Lisa"};
    static String subjects[] = {"English", "Maths", "French", "Irish"};

    static int numberOfStudents, numberOfExams;
    static String output;

    //define the main method
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        //figure out how many students you are dealing with
        numberOfStudents = names.length;

        //figure out how many students you are dealing with
        numberOfExams = subjects.length;

        output = "The Results Are: \n\n";

        //call method buildString
        buildString();

        // call methods minimum and maximum
        output += "\n\n" + minimum() + "\n" + maximum() + "\n";

        // call method average to calculate each student's average
        for (int counter = 0; counter < grades.length; counter++) {
            output += "\nAverage for " + names[counter] + " is " + average(grades[counter]);

        }//end for

        output += "\n";
        System.out.println(output);
        System.exit(0);

    } //end doubleArrayApplication constructor

    // find minimum grade
    public static String minimum() {

        // assume first element of grages array is smallest
        int lowGrade = grades[0][0];
        String op = "The student with the worst grade is " + names[0] + " and that grade was achieved  in " + subjects[0] + ":" + grades[0][0];

        // loop through rows of grades array
        for (int row = 0; row < numberOfStudents; row++) // loop through columns of current row
        {
            for (int column = 0; column < numberOfExams; column++) // Test if current grade is less than lowGrade.
            // If so, assign current grade to lowGrade.
            {
                if (grades[row][column] < lowGrade) {
                    lowGrade = grades[row][column];
                    op = "The student with the worst grade is " + names[row] + " and that grade was achieved  in " + subjects[column] + ":" + grades[row][column];
                }
            }
        }

        return op;  // return string outlining the student with the worst grade

    }//end minimum

    // find maximum grade
    public static String maximum() {
        // assume first element of grages array is largest
        int highGrade = grades[0][0];
        String op = "The student with the best grade is " + names[0] + " and that grade was achieved  in " + subjects[0] + ":" + grades[0][0];

        // loop through rows of grades array
        for (int row = 0; row < numberOfStudents; row++) // loop through columns of current row
        {
            for (int column = 0; column < numberOfExams; column++) // Test if current grade is greater than highGrade.
            // If so, assign current grade to highGrade.
            {
                if (grades[row][column] > highGrade) {
                    highGrade = grades[row][column];
                    op = "The student with the best grade is " + names[row] + " and that grade was achieved  in " + subjects[column] + ":" + grades[row][column];

                }
            }
        }

        return op;  // return string outlining the student with the best grades
    }//end maximum

    // determine average grade for each student
    public static double average(int setOfGrades[]) {
        int total = 0;  // initialize total

        // sum grades for one student
        for (int count = 0; count < setOfGrades.length; count++) {
            total += setOfGrades[count];
        }

        // return average of grades
        return (double) total / setOfGrades.length;
    }//end average

    // build output string
    public static void buildString() {

        // create column heads
        for (int counter = 0; counter < numberOfExams; counter++) {
            output += "\t" + subjects[counter];
        }

        // create rows/columns of text representing array grades
        for (int row = 0; row < grades.length; row++) {
            output += "\n" + names[row];

            for (int column = 0; column < numberOfExams; column++) {
                output += "\t" + grades[row][column];
            }

        }//end for
    }//end buildString
}//end class DoubleArrayApplication
