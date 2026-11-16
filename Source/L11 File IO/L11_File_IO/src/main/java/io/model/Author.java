package io.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @CsvBindByPosition(position = 0) //these annotations are needed for a simplified CSV conversion
//    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByPosition(position = 1)
//    @CsvBindByName(column = "firstName")
    private String firstName;

    @CsvBindByPosition(position = 2)
//    @CsvBindByName(column = "lastName")
    private String lastName;

    @CsvBindByPosition(position = 3)
//    @CsvBindByName(column = "yearBorn")
    private int yearBorn;

    public String toFormattedString() {
        return String.format("%-5d %-15s %-15s %-10d", id, firstName, lastName, yearBorn);
    }

}//end class Author