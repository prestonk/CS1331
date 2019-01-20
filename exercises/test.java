import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
      Set<String> stringSet = new HashSet<>(Arrays.asList("meow", "meow"));
      System.out.print(stringSet.size());
    }
}
