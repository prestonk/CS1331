import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class csvReader {
    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("array-data.csv");
        Scanner reader = new Scanner(data);
        reader.useDelimiter("[,\n]");
        int[] list = new int[15];
        for (int i = 0; i < 14; i++) {
            list[i] = Integer.parseInt(reader.next());
            System.out.print(list[i]);
        }
    }
}
