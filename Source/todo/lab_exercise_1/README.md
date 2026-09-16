# Lab Exercise 1 — Chuck Norris Joke Analyzer  :smiley:

## Overview

In this exercise you will create a Java application that retrieves "jokes" from an online API and analyses the jokes using your own Java methods.

The exercise is designed to give you practice with:

- writing methods
- passing parameters to methods
- returning values from methods
- using loops
- working with arrays
- working with `String` values
- making an HTTP API request
- processing JSON
- using the Jackson library to map JSON to Java objects

The main objective is **not** to build a complicated API client. The API is being used to provide some interesting data for your Java program to process.

---

## 1. The Chuck Norris API

You will use the Chuck Norris API:

https://api.chucknorris.io/

The API can return a random joke using the following endpoint:

```text
https://api.chucknorris.io/jokes/random
```

If you open this URL in a browser, you will receive a JSON response similar to:

```json
{
  "categories": [],
  "created_at": "2020-01-05 13:42:19.324003",
  "icon_url": "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
  "id": "abc123",
  "updated_at": "2020-01-05 13:42:19.324003",
  "url": "https://api.chucknorris.io/jokes/abc123",
  "value": "Chuck Norris can divide by zero."
}
```

The field that you are interested in is:

```json
"value"
```

This contains the actual joke.

You should **not** manually extract the joke using `substring()`, `split()`, regular expressions or similar techniques. Instead we will use Jackson to convert the JSON into a Java object. Jackson is a Java library used to convert JSON data into Java objects and Java objects back into JSON.

---

# 2. Maven Dependencies

Create a Maven Java project. Maven is used to manage a project’s dependencies (and build configuration) automatically.

Add the following dependency to your `pom.xml`:

```xml
<dependencies>

    <!-- Jackson JSON processing -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.19.2</version>
    </dependency>

 </dependencies>
```

Maven will download the required libraries automatically.

---

# 3. Create a Joke Class

Create a Java class called `Joke`. You only need the properties that your program requires.

For this exercise, the only property we need in the `Joke` class is a property called `value`:

```java
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Ignore any JSON properties that are not defined in the Joke class.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
```

The JSON returned by the API contains a field called `value`.

Jackson will use this matching field name to populate the Java object.

You do not need to create properties for every field returned by the API.

---

# 4. Create a `Main` class

Create a class called `Main`.

For this exercise, your `Main` class will contain the `main()` method where you can test the Jackson JSON mapping.

Start with the following:

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String json = """
                {
                    "value": "Chuck Norris can divide by zero."
                }
                """;

        Joke joke = mapper.readValue(json, Joke.class);

        System.out.println(joke.getValue());
    }
}
```

_At this stage, all we are doing is testing that Jackson can convert JSON into your Java object. You will use the same approach later when you retrieve the JSON from the Chuck Norris API._

---

# 5. Making an API Request

You can now replace the sample JSON from Step 4 with JSON retrieved from the Chuck Norris API.

You need to make an HTTP `GET` request to:

```text
https://api.chucknorris.io/jokes/random
```

Java provides an HTTP client as part of the standard library, so you do **not** need to add another Maven dependency for making the API request.

Add the following imports to your `Main` class:

```java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
```

Inside your `main()` method, add the following code:

```java
//Create an HTTP client.
//The client will be used to communicate with the API.
HttpClient client = HttpClient.newHttpClient();

//Create an HTTP GET request.
//The URI specifies the API endpoint that we want to call.
HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.chucknorris.io/jokes/random"))
        .GET()
        .build();

//Send the request to the API.
//BodyHandlers.ofString() tells Java that we want the response body
//returned as a String.
HttpResponse<String> response =
        client.send(request, HttpResponse.BodyHandlers.ofString());

//Get the JSON returned by the API from the response body.
String json = response.body();

//Display the JSON so that you can see what the API has returned.
System.out.println(json);
```

Run the program.

You should see a JSON response similar to:

```json
{
  "id": "abc123",
  "value": "Chuck Norris can divide by zero.",
  "url": "https://api.chucknorris.io/jokes/abc123"
}
```

The exact response will be different because the API returns a random joke.

## Checking the Response

Before processing the JSON, you should check that the API request was successful.

For example:

```java
//A status code of 200 means that the request was successful.
if (response.statusCode() == 200) {

    System.out.println(json);

} else {

    //The request was not successful.
    System.out.println("API request failed. Status code: "
            + response.statusCode());
}
```

In the next step, you will use Jackson's `ObjectMapper` to convert the JSON into a Java `Joke` object.
# 6. Get One Joke

You have successfully made a request to the Chuck Norris API and displayed the JSON response.

You will now place this functionality inside a method.

Create the following method:

```java
public static String getJoke() throws Exception
```

The method must:

1. Make a `GET` request to the Chuck Norris API.
2. Retrieve the JSON response.
3. Use Jackson's `ObjectMapper` to convert the JSON into a `Joke` object.
4. Return the joke text as a `String`.

You have already written the code required to make the API request and process the JSON in Step 5. Move that code into your new method.

Your method should return the joke rather than printing it.

For example:

```java
return joke.getValue();
```

The method should therefore return something similar to:

```text
Chuck Norris can divide by zero.
```

## Calling the Method

Your `main()` method should call `getJoke()` and store the returned value in a variable:

```java
String joke = getJoke();

System.out.println("Joke:");
System.out.println(joke);
```

Example output:

```text
Joke:
Chuck Norris can divide by zero.
```

The actual joke will be different because the API returns a random joke.

### Important

`getJoke()` should **return** the joke.

It should not simply print the joke from inside the method.

The responsibility of `getJoke()` is to retrieve and return the data. The `main()` method can then decide what to do with the returned value.


---

# 7. Get Multiple Jokes

Create the following method:

```java
public static String[] getJokes(int numberOfJokes) throws Exception
```

The parameter specifies how many jokes should be retrieved.

For example:

```java
String[] jokes = getJokes(10);
```

should return an array containing 10 jokes.

You **must use a loop** to retrieve the jokes.

Your method should call the `getJoke()` method that you created in Step 6.

For example, the basic structure should be similar to:

```java
String[] jokes = new String[numberOfJokes];

for (int i = 0; i < jokes.length; i++) {
    jokes[i] = getJoke();
}

return jokes;
```

Do not make ten separate calls to `getJoke()`.

The purpose of this part is to practise using a loop to repeatedly call a method.

---

# 8. Display the Jokes

Create the following method:

```java
public static void displayJokes(String[] jokes)
```

The method should use a loop to display every joke.

The output should be clearly labelled.

For example:

```text
========== JOKES ==========

Joke 1:
Chuck Norris can divide by zero.

Joke 2:
Chuck Norris doesn't wear a watch. He decides what time it is.

Joke 3:
...
```

The method should not retrieve the jokes.

It should receive the array of jokes as a parameter and display them.

This demonstrates the separation between:

- retrieving data
- processing data
- displaying data

---

# 9. Count Jokes Containing a Word

Create:

```java
public static int countJokesContaining(
        String[] jokes,
        String word)
```

The method should return the number of jokes that contain the specified word.

The search must be **case-insensitive**.

For example:

```java
int count = countJokesContaining(jokes, "chuck");
```

If 7 out of 10 jokes contain the word `chuck`, the method should return:

```text
7
```

You will need to use a loop to examine every joke.

You may find the following `String` methods useful:

```java
toLowerCase()
contains()
```

For example:

```java
String lowerCaseJoke = joke.toLowerCase();
```

and:

```java
if (lowerCaseJoke.contains(word.toLowerCase())) {
    // word was found
}
```

---

# 10. Find the Longest Joke

Create:

```java
public static String getLongestJoke(String[] jokes)
```

The method should return the longest joke in the array.

You will need to:

1. Keep track of the longest joke found so far.
2. Loop through the jokes.
3. Compare their lengths.
4. Update the longest joke when a longer joke is found.
5. Return the longest joke.

You can determine the length of a `String` using:

```java
joke.length()
```

Do not sort the array to find the longest joke.

The purpose of this exercise is to practise solving the problem using a loop.

---

# 11. Calculate Average Joke Length

Create:

```java
public static double calculateAverageLength(String[] jokes)
```

The method should calculate and return the average number of characters per joke.

For example, if three jokes have the following lengths:

```text
50
80
70
```

the average is:

```text
66.666...
```

Do not use a stream (Java's equivalent of LINQ) or another library method to calculate the average.

The objective is to practise using a loop to perform a calculation.

---
# 12. Find the Shortest Joke

Create the following method:

```java
public static String getShortestJoke(String[] jokes)
```

The method should return the shortest joke in the array.

You will need to:

1. Keep track of the shortest joke found so far.
2. Loop through the jokes.
3. Compare the length of each joke.
4. Update the shortest joke when a shorter joke is found.
5. Return the shortest joke.

You can determine the length of a `String` using:

```java
joke.length()
```

Do not sort the array to find the shortest joke.

The purpose of this step is to practise using a loop to find a particular value in an array.

---

# 13. Produce a Report

Your `main()` method should now use the methods you have created to produce a report similar to:

```text
========================================
       CHUCK NORRIS JOKE ANALYZER
========================================

Number of jokes retrieved: 10

Jokes:

Joke 1:
Chuck Norris can divide by zero.

Joke 2:
Chuck Norris doesn't wear a watch.
He decides what time it is.

...

========================================
             ANALYSIS
========================================

Jokes containing "chuck": 9

Average joke length: 76.4 characters

Shortest joke:
Chuck Norris can divide by zero.

Longest joke:
Chuck Norris once...

Longest joke length: 143 characters
```

The actual jokes and results will vary because the API returns random jokes.

Your `main()` method should call your other methods to obtain the required results.

For example, it should:

- retrieve the jokes
- display the jokes
- count jokes containing a specified word
- calculate the average joke length
- find the shortest joke
- find the longest joke

The calculations and searching should be performed by your methods rather than directly inside `main()`.


# 14. Required Methods

Your program must contain the following methods:

```java
public static String getJoke() throws Exception
```

```java
public static String[] getJokes(int numberOfJokes) throws Exception
```

```java
public static void displayJokes(String[] jokes)
```

```java
public static int countJokesContaining(
        String[] jokes,
        String word)
```

```java
public static String getLongestJoke(String[] jokes)
```

```java
public static String getShortestJoke(String[] jokes)
```

```java
public static double calculateAverageLength(String[] jokes)
```


---

# 15. Program Structure

Your program should have a clear separation between the different tasks.

A possible structure is:

```text
main()
 |
 +-- getJokes()
 |      |
 |      +-- getJoke()
 |
 +-- displayJokes()
 |
 +-- countJokesContaining()
 |
 +-- getLongestJoke()
 |
 +-- getShortestJoke()
 |
 +-- calculateAverageLength()
```

The important idea is that `main()` should **coordinate** the program rather than contain all of the processing logic.

For example:

```java
String[] jokes = getJokes(10);

displayJokes(jokes);

int count = countJokesContaining(jokes, "chuck");

String longest = getLongestJoke(jokes);

String shortest = getShortestJoke(jokes);

double average = calculateAverageLength(jokes);
```

---

# 16. Error Handling

Your API request can fail.

For example, the API may be unavailable or the request may return a status code other than `200`.

Your program should handle this appropriately.

At a minimum, your API method should check the response status:

```java
if (response.statusCode() == 200) {
    //Process the JSON
} else {
    //Handle the failed request
}
```

> [!IMPORTANT]
> You should not allow your program to continue as though a joke was successfully retrieved when the API request failed.
> You should also handle exceptions associated with making the HTTP request and parsing the JSON.

---

# 17. Restrictions

For this exercise:

- You must use methods for the tasks specified above.
- You must use loops where specified.
- You must use Jackson to parse the JSON.
- You must make the API request programmatically.
- You must not manually parse the JSON using `substring()`, `split()`, regular expressions, etc.
- Do not use Java Streams to replace the required loops.
- Do not use sorting to find the longest or shortest joke.
- Do not put all of the logic into `main()`.

You may use other Java classes and methods where appropriate.

---


# 18. What You Are Practising

Although this exercise uses an online API, the main programming concepts are still fundamental Java concepts.

You should be able to identify where your program demonstrates:

- method parameters
- return values
- method calls
- loops
- arrays
- conditional statements
- `String` methods
- numerical calculations
- object creation
- JSON-to-object mapping
- HTTP requests
- exception handling

_The API is simply providing real data for your Java program to process._
