package sd3.com.model;

public class Name {
    private String timeZone;
    private String gender; //could use a char instead of a String
    private int year;
    private String name;
    private int occurrences;

    public Name(String timeZone, String gender, int year, String Name, int occurrences) {
        this.timeZone = timeZone;
        this.gender = gender;
        this.year = year;
        this.name = Name;
        this.occurrences = occurrences;
    }

    /**
     * @return the timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * @param timeZone the timeZone to set
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the name to set
     */
    public void setName(String Name) {
        this.name = Name;
    }

    /**
     * @return the occurrences
     */
    public int getOccurrences() {
        return occurrences;
    }

    /**
     * @param occurrences the occurrences to set
     */
    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    @Override
    public String toString() {
    
        return timeZone + "\t" + gender + "\t" + year + "\t" + name + "\t" + occurrences; 
    }
    
}
