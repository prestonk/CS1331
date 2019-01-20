/**
* Makes it possible to create Professors
* @author Preston Knibbe
* @version 1
*/
public class Professor extends Person {
    public double funny;
    public double gpa;

    public Professor(String fname, String lname,
        String username, double funny, double gpa) {
        super(fname, lname, username);
        if (funny < 1 && funny > 0) {
            this.funny = funny;
            int tester = (int) (gpa * 100);
            double tester2 = tester / 100.0;
            if (tester2 == gpa && gpa > 0.0 && gpa < 4.0) {
                this.gpa = gpa;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void setFunnyFactor(double funnyFactor) {
        if (funnyFactor < 1 && funnyFactor > 0) {
            funny = funnyFactor;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void setGPA(double newGpa) {
        int tester = (int) (newGpa * 100);
        double tester2 = tester / 100.0;
        if (newGpa == tester2 && newGpa <= 4 && newGpa >= 0) {
            gpa = newGpa;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public double getFunnyFactor() {
        return funny;
    }
    public double getGPA() {
        return gpa;
    }
}
