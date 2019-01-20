import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;
public class GpaCalc {
    private static boolean semcheck = true;
    public static void main(String args[]) throws FileNotFoundException {
        do {
            processInput();
        } while (semcheck);
    }
    static void processInput() throws FileNotFoundException {
        float points = 0, hours = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Semester Name:");
        String semester = input.nextLine();
        String file = semester.toLowerCase();
        String filen = file.replaceAll("\\s+", "");
        PrintStream output = new PrintStream(new File(filen + ".txt"));
        boolean check = true;
        while (check) {
            System.out.print("Enter Course Name:");
            String course = input.nextLine();
            System.out.print("Enter the number of credits the course is worth:");
            int credits = input.nextInt();
            input.nextLine();
            System.out.print("Enter Grade Recieved (A-4,B-3,C-2,D-1,F-0):");
            int grade = input.nextInt();
            input.nextLine();
            points += credits * grade;
            hours += credits;
            output.println(course + " - " + credits + " credits. Grade: " + grade);
            System.out.print("Calculate another course? (y/n)");
            String response = input.nextLine();
            if (response.equals("n")) {
                check = false;
            }
        }
        double gpa = points / hours;
        System.out.printf("GPA: " + "%.2f%n", gpa);
        output.printf("GPA: " + "%.2f%n", gpa);
        System.out.print("Calculate another semester? (y/n)");
        String resp = input.nextLine();
        if (resp.equals("n")) {
            semcheck = false;
        }
    }
}
