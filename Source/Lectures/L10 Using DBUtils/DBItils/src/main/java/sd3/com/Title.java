package sd3.com;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //DBUtils requires a no-args constructor
public class Title {
    private String ISBN;
    private String title;
    private int editionNumber;
    private int yearPublished;
    private int publisherID;
    private double price;
}
