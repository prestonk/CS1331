/**
* Makes it possible to create Grad Student objects
* @author Preston Knibbe
* @version 1
*/
public class GradStudent extends Student {
    public GradStudent(String fname, String lname,
        String username) {
        super(fname, lname, username);
    }
    public void relax(int hours) {
        if (hours != 0) {
            throw new IllegalArgumentException();
        }
    }
}
