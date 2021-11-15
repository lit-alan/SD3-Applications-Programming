/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd3.com.UsingResultSets;

/**
 *
 * @author Alan.Ryan
 */
public class Author {
    private int AuthorID;
    private String FirstName;
    private String LastName;
    private int YearBorn;

    public Author() {
    }

    public Author(int AuthorID, String FirstName, String LastName, int YearBorn) {
        this.AuthorID = AuthorID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.YearBorn = YearBorn;
    }

    /**
     * @return the AuthorID
     */
    public int getAuthorID() {
        return AuthorID;
    }

    /**
     * @param AuthorID the AuthorID to set
     */
    public void setAuthorID(int AuthorID) {
        this.AuthorID = AuthorID;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the YearBorn
     */
    public int getYearBorn() {
        return YearBorn;
    }

    /**
     * @param YearBorn the YearBorn to set
     */
    public void setYearBorn(int YearBorn) {
        this.YearBorn = YearBorn;
    }

    @Override
    public String toString() {
        return "Author{" + "AuthorID=" + AuthorID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", YearBorn=" + YearBorn + '}';
    }
    
    
}
