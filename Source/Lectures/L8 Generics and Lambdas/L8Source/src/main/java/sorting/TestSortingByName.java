package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSortingByName {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Justin", "Chancellor", 20, "K00123456", 39.4, "Mobile and Web Computing", 2),
                new Student("Brett", "Anderson", 22, "K00987654", 75.9, "Mobile and Web Computing", 3),
                new Student("Dave", "Rowntree", 19, "K006541278", 55.9, "Software Development", 1),
                new Student("Ciara Mary-Alice", "Thompson", 19, "K00369852", 44.7, "Software Development", 2),
                new Student("Lou", "Barlow", 35, "K00147854", 47.1, "Software Development", 2),
                new Student("Paul", "Banks", 19, "K00147987", 40.7, "Networks & Cyber Security", 4),
                new Student("Justine", "Frischmann", 19, "K006541278", 55.9, "Software Development", 3),
                new Student("Jeff", "Walker", 34, "K00147471", 55.9, "Software Development", 3),
                new Student("Dave", "Mustaine", 21, "K00865687", 75.9, "Software Development", 4),
                new Student("Patti", "Smith", 29, "K00771455", 36.9, "Mobile and Web Computing", 1)
        );

        System.out.println("--------------------------------------------------------");
        //COMPARABLE Example
        Collections.sort(students);
        System.out.println("Students sorted by GPA, then by last name and finally by first name");
        students.forEach(student ->
                System.out.println(student.getLname() + ", " + student.getFname() + ". GPA is " + student.getGpa()));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //COMPARATOR EXAMPLE 1
         System.out.println("--------------------------------------------------------");
        System.out.println("Students sorted by last name");

        // Sort by name using a lambda expression
        students.sort(Comparator.comparing(Student::getLname));
        students.forEach(student ->
                System.out.println(student.getLname() + ", " + student.getFname() + ". GPA is " + student.getGpa()));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //COMPARATOR EXAMPLE 2
        System.out.println("--------------------------------------------------------");
        System.out.println("Students sorted by name in reverse order");
        // Sort by name in reverse order
        students.sort(Comparator.comparing(Student::getLname).reversed());

        // Display sorted list
         students.forEach(student ->
                System.out.println(student.getLname() + ", " + student.getFname() + ". GPA is " + student.getGpa()));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //COMPARATOR EXAMPLE 3
        System.out.println("--------------------------------------------------------");
        System.out.println("Students sorted by course (alphabetically) and then year of study");

        // Custom comparator for sorting by course (in alphabetical order) and then year of study
        Comparator<Student> courseAndYearComparator = Comparator
                .comparing(Student::getCourse)
                .thenComparing(Student::getYearOfStudy);

        students.sort(courseAndYearComparator);

        // Display sorted list
        students.forEach(student ->
                System.out.println(student.getLname() + ", " + student.getFname() + ": " + student.getCourse()
                        + " " + student.getYearOfStudy()));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        //COMPARATOR EXAMPLE 4
        System.out.println("--------------------------------------------------------");
        System.out.println("Students sorted by GPA, the course name length and then their full name");
        //Sort by GPA first, then the course name length, and finally the full name:
        Comparator<Student> complexComparator = Comparator
                .comparing(Student::getGpa)         // Primary: GPA (descending)
                .reversed()
                .thenComparing(                     // Secondary: Course name length (ascending)
                        Comparator.comparingInt(student -> student.getCourse().length())
                )
                .thenComparing(                     // Tertiary: Full name (fname + lname) in alphabetical order
                        Comparator.comparing(student -> (student.getFname() + " " + student.getLname()))
                );

        // Apply the comparator
        students.sort(complexComparator);

        // Display sorted list
        students.forEach(student ->
                System.out.println(student.getFname() + " " + student.getLname() + " - "
                        + student.getGpa() + " - " + student.getCourse() + " " + student.getYearOfStudy()));
    }
}
