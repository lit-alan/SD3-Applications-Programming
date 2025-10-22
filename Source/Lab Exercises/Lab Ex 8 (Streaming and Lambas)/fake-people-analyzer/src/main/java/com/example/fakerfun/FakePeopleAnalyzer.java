package com.example.fakerfun;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;

class Person {
    String name;
    String country;
    int age;
    String email;
    String chuckNorrisQuote;
    String simpsonsCharacter;
    String superhero;
    String favoriteBeer;
    String buzzword;

    Person(String name, String country, int age, String email, 
           String chuckNorrisQuote, String superhero, String favoriteBeer, String buzzword) {
        this.name = name;
        this.country = country;
        this.age = age;
        this.email = email;
        this.chuckNorrisQuote = chuckNorrisQuote;
        this.superhero = superhero;
        this.favoriteBeer = favoriteBeer;
        this.buzzword = buzzword;
    }

    /*
        The emoji characters I am using in the toString() are part of the UTF-8 character set, so when your
        .java files are saved as UTF-8 (which IntelliJ does by default), they (should) show up
        fine in both console output and code editors.
    */
    @Override
    public String toString() {
        return String.format("""
                %s (%d)
                🌍 Country: %s
                ✉️ Email: %s
                🦸 Superhero: %s
                💼 Buzzword: %s
                🍺 Favorite Beer: %s
                💬 Chuck Norris says: "%s"
                """, name, age, country, email, superhero, buzzword, favoriteBeer, chuckNorrisQuote);
    }
}
public class FakePeopleAnalyzer {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();

        //Generate fake people
        //Generate a stream of 50 random integers between 18 (inclusive) and 81 (exclusive).
        //Each integer represents a random age for a Person object.
        //This uses the stream-based Random API introduced in Java 8,
        //allowing us to map each random number directly into a new Person instance.
        List<Person> people = new Random().ints(50, 18, 81)
                .mapToObj(age -> new Person(
                        faker.name().fullName(),
                        faker.country().name(),
                        age,
                        faker.internet().emailAddress(),
                        faker.chuckNorris().fact(),
                        faker.superhero().name(),
                        faker.beer().name(),
                        faker.company().buzzword()
                ))
                .collect(Collectors.toList());

        //print the objects -> comment out if you wish
        people.forEach(System.out::println);


        // ---------------------------------------------------------------------
        // Task One: Print all people over age 30, sorted by name
        // Goal: Practice filtering and sorting using Stream operations.
        // ---------------------------------------------------------------------
                System.out.println("\nPeople over 30 (sorted by name):");
                people.stream()
                        .filter(p -> p.age > 30)
                        .sorted(Comparator.comparing(p -> p.name))
                        .forEach(System.out::println);


        // ---------------------------------------------------------------------
        // Task Two: Find the oldest person
        // Goal: Use a Stream to identify the Person with the maximum age.
        // Hint: Use Comparator.comparingInt(...) inside the max() method.
        // ---------------------------------------------------------------------
                System.out.println("\nOldest person:");
        // people.stream()
        //        .max(/* TODO: specify a comparator here */)
        //        .ifPresent(System.out::println);


        // ---------------------------------------------------------------------
        // Task Three: Group people by country (count per country)
        // Goal: Group all Person objects by their country and count how many belong to each.
        // Hint: Use Collectors.groupingBy() with a lambda expression for the key, and Collectors.counting().
        // ---------------------------------------------------------------------
                System.out.println("\nPeople count by country:");
        // Map<String, Long> peopleByCountry = people.stream()
        //        .collect(Collectors.groupingBy(/* TODO: specify a lambda for grouping */, Collectors.counting()));
        // TODO: print each country (key) and its count (value)


        // ---------------------------------------------------------------------
        // Task Four: Group by buzzword (e.g., how many people are “synergizing”)
        // Goal: Group by each Person’s buzzword and count how many share the same one.
        // Hint: This task is almost identical to Task Three, just use the buzzword instead of country.
        // ---------------------------------------------------------------------
                System.out.println("\nPeople grouped by buzzword:");
        // TODO: implement grouping and counting logic here


        // ---------------------------------------------------------------------
        // Task Five: List people whose favorite beer starts with 'B'
        // Goal: Filter the Stream to include only those whose favoriteBeer starts with 'B'.
        // Hint: Use String.startsWith("B") and print the matching Person objects.
        // ---------------------------------------------------------------------
                System.out.println("\nPeople whose favorite beer starts with 'B':");
        // TODO: implement filter and print logic here


        // ---------------------------------------------------------------------
        // Task Six: Display five random unique Chuck Norris quotes
        // Goal: Extract unique Chuck Norris quotes and print the first five distinct ones.
        // Hint: Use map() to extract quotes, distinct() to remove duplicates, and limit(5).
        // ---------------------------------------------------------------------
                System.out.println("\nFive random unique Chuck Norris quotes:");
        // TODO: implement quote extraction and print logic here

    }
}