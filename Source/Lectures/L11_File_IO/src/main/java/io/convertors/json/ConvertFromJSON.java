package io.convertors.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.model.Author;

import java.io.File;
import java.util.List;

public class ConvertFromJSON {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Reading from the JSON file and convert to a list of Author objects
            List<Author> authorsList = mapper.readValue(new File("authors.json"), new TypeReference<List<Author>>(){});
            System.out.println("JSON file read successfully. Contents:");

            authorsList.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
