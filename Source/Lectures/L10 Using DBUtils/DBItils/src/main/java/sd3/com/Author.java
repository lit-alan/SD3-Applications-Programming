package sd3.com;

import lombok.*;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //DBUtils requires a no-args constructor
public class Author {

    private int AuthorID;
    private String FirstName;
    private String LastName;
    private int YearBorn;


  
}//end class Author

