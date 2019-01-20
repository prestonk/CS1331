public class Palindrome {
    public static boolean isPalindrome(String test) {
        String newString = "";
        String[] testArray = test.split("");
        for (int i = testArray.length - 1; i > -1; i--) {
            newString += testArray[i];
        }
        if (newString.equalsIgnoreCase(test)) {
            return true;
        } else {
            return false;
        }

    }
    public static void main(String[] args) {
        String tester = args[0];
        tester.replaceAll("\\s","");
        if (isPalindrome(tester)) {
            System.out.println("This is a palindrome");
        } else {
            System.out.println("This isn't a palindrome.");
        }
    }
}
