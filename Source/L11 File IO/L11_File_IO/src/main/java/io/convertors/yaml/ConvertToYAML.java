package io.convertors.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.model.Author;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConvertToYAML {
    public static void main(String[] args) {
        List<Author> authorsList = new ArrayList();

        authorsList.add(new Author(1, "J.K.", "Rowling", 1965));
        authorsList.add(new Author(2, "Stephen", "King", 1947));
        authorsList.add(new Author(3, "George", "Orwell", 1903));
        authorsList.add(new Author(4, "Agatha", "Christie", 1890));
        authorsList.add(new Author(5, "Haruki", "Murakami", 1949));

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File("authors.yaml"), authorsList);

            System.out.println("YAML file created successfully.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
