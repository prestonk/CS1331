/**
* Builds a course filled with students, ta's, and a professor
* @author Preston Knibbe
* @version 1
*/
public class Course {
    public String title;
    public Professor professor;
    public TA headTA;
    public TA[] tas;
    public Student[] students;
    /**
    * Constructs Course
    * @param title Course title
    * @param professor professor object
    * @param headTA ta object
    * @param tas array of all tas
    * @param students array of all students
    */
    public Course(String title, Professor professor,
        TA headTA, TA[] tas, Student[] students) {
        if (tas.length < 15 && students.length < 300) {
            this.title = title;
            this.professor = professor;
            this.headTA = headTA;
            this.tas = tas;
            this.students = students;
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
    * Gets course title
    * @return title returns the title
    */
    public String getTitle() {
        return title;
    }
    /**
    * Gets the Professor
    * @return returns the professor object
    */
    public Professor getProfessor() {
        return professor;
    }
    /**
    * Gets the head TA
    * @return headTA returns the head TA
    */
    public TA getHeadTA() {
        return headTA;
    }
    /**
    * Gets array of Ta's
    * @return tas returns array of TA's
    */
    public TA[] getTAs() {
        return tas;
    }
    /**
    * Gets student array
    * @return students returns array of all students
    */
    public Student[] getStudents() {
        return students;
    }
    /**
    * Calculates the average study percentage of all the students
    * @return avg returns the average study percentage
    */
    public double getAverageStudyPercentage() {
        int counter = 0;
        for (int i = 0; i < students.length; i++) {
            counter += students[i].getStudyPercentage();
        }
        double avg = counter / students.length;
        return avg;
    }
    /**
    * Adds a student to the course
    * @param s passes in student obj to be added
    */
    public void addStudent(Student s) {
        if (students.length > 300) {
            Student[] new_students = new Student[students.length + 1];
            for (int i = 0; i <= students.length; i++) {
                new_students[i] = students[i];
            }
            new_students[students.length] = s;
            students = new_students;
        }
    }


}
