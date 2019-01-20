import java.io.File;
import java.util.Scanner;
public class gradeHistogram {
    public static void main(String[] args) throws Exception {
        String file = "";
        file = args[0];

        Scanner grabber = new Scanner(new File(file));
        double count = 0;
        String data = "";
        while (grabber.hasNext()) {
            data = data + grabber.nextLine();
            ++count;
        }
        int i = 0;
        Scanner stringPull = new Scanner(data).useDelimiter("[^0-9]+");
        int[] grades = new int[(int) count];
        for (i = 0; i < count; ++i) {
            grades[i] = stringPull.nextInt();
        }
        Scanner asker = new Scanner(System.in);
        System.out.println("Bucket size?");
        int bucket = asker.nextInt();
        int binNum = 100 / bucket;
        int high = 100;
        int low = 100 - bucket;
        String[] bin = new String[(int) binNum];
        for (int a = 0; a < binNum; ++a) {
            bin[a] = "";
            for (int b = 0; b < count; ++b) {
                if (grades[b] > low && grades[b] < high) {
                    bin[a] = bin[a] + "[]";
                }
            }
            String highString = "" + high;
            String lowString = "" + low;
            if (highString.length() < 3 && highString.length() > 1) {
                highString = " " + high;
            } else if (highString.length() < 2) {
                highString = " " + " " + high;
            }
            if (lowString.length() < 2) {
                lowString = " " + low;
            }

            System.out.print(highString + " - " + lowString + " | ");
            System.out.print(bin[a]);
            System.out.println("");
            high = high - bucket;
            low = low - bucket;
        }



    }
}
