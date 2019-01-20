/**
* Creates a person.
* @author Preston Knibbe
* @version 1
*/
public class Person {
    public String fname;
    public String lname;
    public String username;
    /**
    * constructs person
    * @param fname first name of person
    * @param lname last name of person
    * @param username username of person
    */
    public Person(String fname, String lname, String username) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
    }
    /**
    * Gets the first name
    * @return fname returns first name
    */
    public String getFirstName() {
        return fname;
    }
    /**
    * Gets last name
    * @return lname returns last name
    */
    public String getLastName() {
        return lname;
    }
    /**
    * Gets username
    * @return username returns the username
    */
    public String getUserName() {
        return username;
    }

}
