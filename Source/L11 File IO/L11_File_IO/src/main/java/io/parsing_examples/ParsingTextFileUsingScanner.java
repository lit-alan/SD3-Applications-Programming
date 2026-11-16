package io.parsing_examples;

import io.model.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParsingTextFileUsingScanner {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        Path p = Paths.get("in.dat");

        try (Scanner fileScanner = new Scanner(p)) {

            if (!fileScanner.hasNextLine()) {
                System.err.println("ERROR: The requested file appears to be empty");
                return;
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                studentList.add(splitRecord(line));
            }

        } catch (IOException ex) {
            System.err.println(ex);
            return;
        }

        studentList.forEach(System.out::println);
    }

    private static Student splitRecord(String line) {

        try (Scanner scanner = new Scanner(line)) {

            String name = scanner.next();
            int grade1 = scanner.nextInt();
            int grade2 = scanner.nextInt();
            int grade3 = scanner.nextInt();

            return new Student(name, grade1, grade2, grade3);
        }
    }
}
