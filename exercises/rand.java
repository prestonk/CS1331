import java.util.Random;
import java.util.Scanner;


public class GuessNum {
    private static int randValue;
    private static int guess;
    public void generateRand() {
        Random rand = new Random();
        rand = nextInt(10 - 1) + 1;
        randValue = rand;
    }
    public void prompter() {
        if (guess.equals("quit")) {
            System.out.println("Boo the correct answer is " + randValue);
        } else if (isCorrect(guess)) {
            System.out.println("You guessed it " + randValue + " was right!");
        } else {
            System.out.println("Your guess of " + guess + " is wrong");
            System.out.println("Guess again or type 'quit' to exit");
            Int guess = input.nextInt();
            prompter();
        }
    }
    public boolean isCorrect(int test) {
        if (test == randValue) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        generateRand();
        Scanner input = new Scanner();
        System.out.println("Guess number between 1 and 10");
        guess = input.nextInt();
        prompter();
    }
}
