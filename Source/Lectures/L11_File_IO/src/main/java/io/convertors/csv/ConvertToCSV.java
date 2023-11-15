package io.convertors.csv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.model.Author;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ConvertToCSV {
    public static void main(String[] args) {

        List<Author> authorsList = new ArrayList();
        authorsList.add(new Author(1, "J.K.", "Rowling", 1965));
        authorsList.add(new Author(2, "Stephen", "King", 1947));
        authorsList.add(new Author(3, "George", "Orwell", 1903));
        authorsList.add(new Author(4, "Agatha", "Christie", 1890));
        authorsList.add(new Author(5, "Haruki", "Murakami", 1949));

        try {
            // Writing the list to a CSV file
            try (Writer writer = new FileWriter("authors.csv")) {
                StatefulBeanToCsv<Author> beanToCsv = new StatefulBeanToCsvBuilder<Author>(writer).build();
                beanToCsv.write(authorsList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("CSV file created successfully.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
