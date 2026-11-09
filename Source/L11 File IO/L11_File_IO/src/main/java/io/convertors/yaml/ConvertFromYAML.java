package io.convertors.yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.model.Author;

import java.io.File;
import java.util.List;

public class ConvertFromYAML {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            List<Author> authorsList = mapper.readValue(new File("authors.yaml"), new TypeReference<List<Author>>(){});

            System.out.println("YAML file read successfully. Contents:");
            authorsList.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
