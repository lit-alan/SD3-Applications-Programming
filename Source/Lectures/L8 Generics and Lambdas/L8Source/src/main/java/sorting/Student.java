package sorting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private String fname;
    private String lname;
    private int age;
    private String studentID;
    private double gpa;
    private String course;
    private int yearOfStudy;
    // Implementing the compareTo method

    @Override
    public int compareTo(Student other) {

        //EXAMPLE 1
        // Compare by GPA in descending order
        // int gpaComparison = Double.compare(other.gpa, this.gpa);

        //EXAMPLE 2
        //Students sorted by GPA, then by last name and finally by first name
        int gpaComparison = Double.compare(other.gpa, this.gpa);
        if (gpaComparison != 0) {
            return gpaComparison;
        }

        // If GPA is the same, compare by last name in ascending order
        int lnameComparison = this.lname.compareTo(other.lname);
        if (lnameComparison != 0) {
            return lnameComparison;
        }

        // If last name is the same, compare by first name in ascending order
        return this.fname.compareTo(other.fname);
    }

}

