package sd3.books.model;

import lombok.*;


/**
 * Data Transfer Object (DTO) representing a combined view of data
 * from the {@code titles} and {@code authors} tables.
 * <p>
 * Each instance corresponds to one row from a join query between
 * {@code titles}, {@code authorisbn}, and {@code authors}, containing
 * both book and author information.
 * <p>
 * This class is used for transferring joined data from the database
 * and does not represent a persistent entity.
 */


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
