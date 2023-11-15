package io.convertors.csv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import io.model.Author;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class ConvertFromCSV {
    public static void main(String[] args) {
       try (FileReader reader = new FileReader("authors.csv")) {
                List<Author> authorsList = new CsvToBeanBuilder<Author>(reader)
                        .withType(Author.class)
                        .build()
                        .parse();

                System.out.println("CSV file read successfully. Contents:");
                authorsList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
