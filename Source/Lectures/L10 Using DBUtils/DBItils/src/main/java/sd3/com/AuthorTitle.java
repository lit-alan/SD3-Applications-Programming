package sd3.com;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //DBUtils requires a no-args constructor
public class AuthorTitle {

    // From 'titles' table
    private String ISBN;
    private String title;
    private int editionNumber;
    private int yearPublished;
    private int publisherID;
    private double price;

    // From 'authors' table
    private int authorID;
    private String firstName;
    private String lastName;
    private int yearBorn;
}
