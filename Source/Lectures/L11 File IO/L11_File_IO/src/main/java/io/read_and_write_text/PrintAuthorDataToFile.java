package io.read_and_write_text;

import io.model.Author;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PrintAuthorDataToFile {
    public static void main(String[] args) {
        List<Author> authorsList = new ArrayList<>();
        authorsList.add(new Author(1, "J.K.", "Rowling", 1965));
        authorsList.add(new Author(2, "Stephen", "King", 1947));
        authorsList.add(new Author(3, "George", "Orwell", 1903));
        authorsList.add(new Author(4, "Agatha", "Christie", 1890));
        authorsList.add(new Author(5, "Haruki", "Murakami", 1949));

        try {
            PrintWriter writer = new PrintWriter("authors.txt");

            // Write column headers
            writer.printf("%-5s %-15s %-15s %-10s\n", "ID", "First Name", "Last Name", "Birth Year");

            for (Author author : authorsList) {
                writer.println(author.toFormattedString());
            }

            writer.close();

            System.out.println("File created");
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
