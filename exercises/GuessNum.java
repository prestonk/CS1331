import java.util.Random;


public class GuessNum {
    private static int randValue = generateRand();
    public static int generateRand() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }
    public static void prompter(String guess) {
        if (guess.equalsIgnoreCase("quit")) {
            System.out.println("Boo the correct answer is " + randValue);
        } else if (isCorrect(guess)) {
            System.out.println("Your guess " + randValue + " was right!");
        } else {
            System.out.println("Your guess of " + guess + " is wrong");
            System.out.println("Guess again or type 'quit' to exit");
            guess = System.console().readLine();
            prompter(guess);
        }
    }
    public static boolean isCorrect(String test) {
        if (Integer.parseInt(test) == randValue) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int randValue = generateRand();
        System.out.println("Guess number between 1 and 10");
        String guess = System.console().readLine();
        prompter(guess);
    }
}
