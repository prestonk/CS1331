
/**
*  Person class
*  @author Preston Knibbe
*  @version 1
*/

public class Person implements Comparable<Person> {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public int compareTo(Person p) {
        return (this.name.compareTo(p.getName()));
    }
    @Override
    public boolean equals(Object p2) {
        if (this == p2) {
            return true;
        } else if (p2 == null || !(p2 instanceof Person)) {
            return false;
        }
        Person that = (Person) p2;
        return this.name.equals(that.name);
    }
    @Override
    public int hashCode() {
      int num = 17;
      num = 31 * num + name.hashCode();
      num = 31 * num + email.hashCode();
      return num;

    }
    @Override
    public String toString() {
        return name;
    }
}
