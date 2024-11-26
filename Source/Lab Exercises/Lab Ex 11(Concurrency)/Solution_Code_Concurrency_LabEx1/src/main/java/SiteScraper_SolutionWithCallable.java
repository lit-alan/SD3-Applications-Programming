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
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SiteScraper_SolutionWithCallable {

    public static void main(String[] args) {
        //Start the time measurement
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

        //Create an ExecutorService to manage a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<String>> futures = new ArrayList();

        //Submit a callable for each URL
        for (String url : urls) {
            Future<String> future = executor.submit(new WebTitleRetrieverTask(url));
            futures.add(future);
        }

        //Retrieve and print results from each callable
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get()); // Print the result (title and time taken)
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

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

    //A Callable task to retrieve the title of a webpage and measure the time taken
    static class WebTitleRetrieverTask implements Callable<String> {
        private String url;

        public WebTitleRetrieverTask(String url) {
            this.url = url;
        }

        @Override
        public String call() throws Exception {
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
            return "Title from " + url + ": " + title + " (Time taken: " + timeTaken + " ms)";
        }

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
