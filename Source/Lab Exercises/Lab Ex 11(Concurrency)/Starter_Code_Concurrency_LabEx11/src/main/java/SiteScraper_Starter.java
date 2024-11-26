import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SiteScraper_Starter {

    public static void main(String[] args) {
        //Start the time measurement for the entire app
        long appStartTime = System.nanoTime();

        Path p = Paths.get("sites.txt");
        List<String> urls = new ArrayList(200);

        try {
            //Read all URLs from the file "sites.txt"
            urls = Files.readAllLines(p);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        //Process each URL sequentially
        for (String url : urls) {
            //Retrieve and print the result (title and time taken)
            try {
                String result = retrieveWebTitle(url);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Error processing site: " + url);
                e.printStackTrace();
            }
        }
        //End the time measurement as we have processed all the urls
        long appEndTime = System.nanoTime();

        //Convert nanoseconds to seconds with decimal precision
        double timeTakenInSeconds = (appEndTime - appStartTime) / 1_000_000_000.0;

        System.out.println("The application took " + timeTakenInSeconds + "seconds to complete");
    }

    //A method to retrieve the title of a webpage and measure the time taken
    private static String retrieveWebTitle(String url) {
        long startTime = System.nanoTime(); // Start the time measurement for processing this url
        String title = "";
        try {
            //Create an HttpClient
            HttpClient client = HttpClient.newHttpClient();

            //Build the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            //Send the request and get the response back
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Extract the <title> tag using Jsoup
            title = extractTitle(response.body());
        } catch (Exception ex) {
            System.out.println("Error with site: " + url);
        }

        long endTime = System.nanoTime();  //End the time measurement for processing this url
        long timeTaken = (endTime - startTime) / 1_000_000;  //Convert nanoseconds to milliseconds

        //Print the contents of the title tag and the time taken to retrieve it for the current url
        return "Title from " + url + ": " + title + " (Time taken: " + timeTaken + " ms)";
    }

    private static String extractTitle(String html) {
        //Parse the HTML content with JSoup
        Document doc = Jsoup.parse(html);

        //Use JSoup's built-in method to get the <title> tag content
        String title = doc.title();

        //If the title is empty, return "No title found"
        if (title == null || title.isEmpty()) {
            return "No title found";
        }

        return title;
    }
}
