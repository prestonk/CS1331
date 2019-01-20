/**
* Makes it possible to create Student objects
* @author Preston Knibbe
* @version 1
*/
public class Student extends Person {
    public int studyHours = 0;
    public int nonStudyHours = 0;
    public double perc;

    public Student(String fname, String lname,
        String username) {
        super(fname, lname, username);
    }
    public int getStudyHours() {
        return studyHours;
    }
    public int getNonStudyHours() {
        return nonStudyHours;
    }
    public double getStudyPercentage() {
        int total = studyHours + nonStudyHours;
        perc = studyHours / total * 100;
        return perc;
    }
    public void study(int hours) {
        if (hours >= 0) {
            studyHours += hours;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void relax(int hours) {
        if (hours >= 0) {
            nonStudyHours += hours;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
