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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SiteScraper_SolutionWithRunnable {

    public static void main(String[] args) {


        // Start the time measurement
        long appStartTime = System.nanoTime();


        Path p = Paths.get("sites.txt");
        List<String> urls = new ArrayList(200);

        try {
           urls = Files.readAllLines(p);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }

        //get the number of cores on the machine
        int availableCores = Runtime.getRuntime().availableProcessors();

        // Start with 2x the cores
        int threadCount = availableCores * 2;

        // Create an ExecutorService to manage a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);


        executor.shutdown();

        // Submit a callable for each URL
        for (String url : urls) {
           executor.submit(new WebTitleRetrieverTask(url));
        }
        try {
            if (executor.awaitTermination(2, TimeUnit.MINUTES)) {
                long appEndTime = System.nanoTime();
                double timeTakenInSeconds = (appEndTime - appStartTime) / 1_000_000_000.0;
                System.out.println("Time taken in seconds: " + timeTakenInSeconds);
            } else {
                System.out.println("Timeout occurred before shutdown");

                //Force shutdown after 2 mins if needed
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Await termination was interrupted");
            Thread.currentThread().interrupt();
        }




    }

    // A Runnable task to print the title of a webpage and measure the time taken
    static class WebTitleRetrieverTask implements Runnable  {
        private String url;

        public WebTitleRetrieverTask(String url) {
            this.url = url;
        }

        @Override
        public void run()  {
            long startTime = System.nanoTime();  // Start the time measurement
            String title = "";
            try {
                // Create an HttpClient
                HttpClient client = HttpClient.newHttpClient();

                // Build the request
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                // Send the request and get the response
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Extract the <title> tag using a regular expression
                title = extractTitle(response.body());
            }
            catch (Exception ex) {
                System.out.println("Error connecting to: " + url);
            }

            long endTime = System.nanoTime();  // End the time measurement
            long timeTaken = (endTime - startTime) / 1_000_000;  // Convert nanoseconds to milliseconds

            // Return the title and the time taken to retrieve it
            System.out.println("Title from " + url + ": " + title + " (Time taken: " + timeTaken + " ms)");
        }

        // Method to extract <title> from HTML content
        private static String extractTitle(String html) {
            // Parse the HTML content with JSoup
            Document doc = Jsoup.parse(html);

            // Use JSoup's built-in method to get the <title> tag content
            String title = doc.title();

            // If the title is empty, return "No title found"
            if (title == null || title.isEmpty()) {
                return "No title found";
            }

            return title;
        }
    }
}
