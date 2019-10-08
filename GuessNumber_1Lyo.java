import java.util.Scanner;
import java.lang.Math; 
//import math random and scanner

/**
 * Jared Lyon
 * Period 1
 * If-A1: Guess A Number
 * This class guesses a number 1-25 and has the user guess until successful
 */
public class GuessNumber_1Lyo {
    public static void main(String[] args) {
        //init scanner and guess var
        Scanner input = new Scanner(System.in);
        int guess = 0;

        //pick number to guess
        int find = (int)(Math.random() * 25) + 1;

        //while loop with conditions
        while (guess != find) {
            System.out.println("Enter your estimation: ");
            guess = input.nextInt();
            System.out.println("You guessed " + input + "!");

            if (guess == find) {
                System.out.println("Wow, you did it! That's the right answer!");
            } else if (guess >= find) {
                System.out.println("Nah, the answer is lower!");
            } else if (guess <= find) {
                System.out.println("It's higher! Try again!");
            }
        }
    }
}