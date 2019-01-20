/**
* Tests code
* @author Preston Knibbe
* @version 1
*/
public class testerFile {
  /**
  * Implements code and creates a course
  */
    public static void main(String[] args) {
        Student ben = new Student("Benjamin", "Franklin", "founding_father");
        ben.relax(2);
        ben.study(10);
        UndergradStudent john = new UndergradStudent("Jack", "Kennedy",
            "jfk");
        john.study(4);
        john.relax(10);
        john.eatPizza(2);
        GradStudent albert = new GradStudent("Albert", "Einstein", "emc2");
        albert.study(20);
        albert.relax(0);
        Professor mark = new Professor("Mark", "Twain", "tom_sawyer",
            0.9, 3.9);
        TA ernest = new TA("Ernest", "Hemmingway", "sun_also_rises",
            0.5, 0.7, 0.9);
        TA george = new TA("George", "Washington", "prez",
            0.1, 0.7, 0.8);
        TA[] ta_lister = {ernest, george};
        Student[] student_lister = {ben, john, albert};
        Course hist101 = new Course("American History 101", mark, ernest,
            ta_lister, student_lister);
        System.out.println("Course Avg Study Percent"
            + hist101.getAverageStudyPercentage());
        System.out.println("Student " + ben.fname + ben.lname);
    }

}
