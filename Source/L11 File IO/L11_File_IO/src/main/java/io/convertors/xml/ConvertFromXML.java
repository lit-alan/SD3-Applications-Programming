package io.convertors.xml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.model.Author;

import java.io.File;
import java.util.List;

public class ConvertFromXML {

    public static void main(String[] args) {

        XmlMapper xmlMapper = new XmlMapper();

        //Reading from the XML file and convert to a list of Author objects
        try {
            List<Author> authorsList = xmlMapper.readValue(new File("authors.xml"), new TypeReference<List<Author>>(){});

            System.out.println("XML file read successfully. Contents:");
            authorsList.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
