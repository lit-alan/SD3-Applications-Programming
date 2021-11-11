package sd3.com.usingDBUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Author {

    private int AuthorID;
    private String FirstName;
    private String LastName;
    private int YearBorn;

    public Author() { //DBUtils requires a no args constructor
    }

    public Author(int AuthorID, String FirstName, String LastName, int YearBorn) {
        this.AuthorID = AuthorID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.YearBorn = YearBorn;
    }
  
}//end class Author
