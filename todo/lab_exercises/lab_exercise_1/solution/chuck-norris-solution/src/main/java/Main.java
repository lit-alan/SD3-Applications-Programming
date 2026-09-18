import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final HttpClient client = HttpClient.newHttpClient();

    public static String getJoke() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.chucknorris.io/jokes/random"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("API request failed. Status code: "
                    + response.statusCode());
        }

        Joke joke = mapper.readValue(response.body(), Joke.class);

        return joke.getValue();
    }

    public static String[] getJokes(int numberOfJokes) throws Exception {

        if (numberOfJokes < 1) {
            throw new IllegalArgumentException("Number of jokes must be at least 1.");
        }

        String[] jokes = new String[numberOfJokes];

        for (int i = 0; i < jokes.length; i++) {
            jokes[i] = getJoke();
        }

        return jokes;
    }

    public static void displayJokes(String[] jokes) {

        System.out.println("========== JOKES ==========");

        for (int i = 0; i < jokes.length; i++) {
            System.out.println();
            System.out.println("Joke " + (i + 1) + ":");
            System.out.println(jokes[i]);
        }
    }

    public static int countJokesContaining(String[] jokes, String word) {

        int count = 0;
        String searchWord = word.toLowerCase();

        for (String joke : jokes) {
            if (joke.toLowerCase().contains(searchWord)) {
                count++;
            }
        }

        return count;
    }

    public static String getLongestJoke(String[] jokes) {

        if (jokes.length == 0) {
            throw new IllegalArgumentException("Joke array cannot be empty.");
        }

        String longestJoke = jokes[0];

        for (int i = 1; i < jokes.length; i++) {
            if (jokes[i].length() > longestJoke.length()) {
                longestJoke = jokes[i];
            }
        }

        return longestJoke;
    }

    public static double calculateAverageLength(String[] jokes) {

        if (jokes.length == 0) {
            throw new IllegalArgumentException("Joke array cannot be empty.");
        }

        int totalLength = 0;

        for (String joke : jokes) {
            totalLength += joke.length();
        }

        return (double) totalLength / jokes.length;
    }

    public static String getShortestJoke(String[] jokes) {

        if (jokes.length == 0) {
            throw new IllegalArgumentException("Joke array cannot be empty.");
        }

        String shortestJoke = jokes[0];

        for (int i = 1; i < jokes.length; i++) {
            if (jokes[i].length() < shortestJoke.length()) {
                shortestJoke = jokes[i];
            }
        }

        return shortestJoke;
    }

    public static void main(String[] args) throws Exception {

        int numberOfJokes = 10;
        String searchWord = "chuck";

        String[] jokes = getJokes(numberOfJokes);

        displayJokes(jokes);

        int count = countJokesContaining(jokes, searchWord);
        double average = calculateAverageLength(jokes);
        String shortest = getShortestJoke(jokes);
        String longest = getLongestJoke(jokes);

        System.out.println();
        System.out.println("========================================");
        System.out.println("             ANALYSIS");
        System.out.println("========================================");

        System.out.println();
        System.out.println("Jokes containing \"" + searchWord + "\": " + count);

        System.out.printf("Average joke length: %.1f characters%n", average);

        System.out.println();
        System.out.println("Shortest joke:");
        System.out.println(shortest);

        System.out.println();
        System.out.println("Longest joke:");
        System.out.println(longest);

        System.out.println();
        System.out.println("Longest joke length: " + longest.length() + " characters");
    }
}
