import java.util.Scanner;
import java.lang.Math;

public class CashRegisterTester_1LyonJ {
    public static void main(String[] args) {
        Till market = new Till(40, 100, 100, 100);
        Scanner input = new Scanner(System.in);
        System.out.println("Input purchase price:");
        amt = input.nextInt();
        System.out.println("Input amount paid:");
        paid = input.nextInt();

        if (amt > paid) {
            System.out.println("Insufficient payment!");
        } else {
            Till.purchase();
        }

        while(tillVall > 0) {
            System.out.println("Enter purchase: ");
            input = input.nextInt();
            System.out.println("You guessed " + input + "!");

            if (tillVall = 0) {
                System.out.println("Wow, you did it! That's the right answer!");
            } else if (guess >= find) {
                System.out.println("Nah, the answer is lower!");
            } else if (guess <= find) {
                System.out.println("It's higher! Try again!");
            }
        }
    }

    class Till {
        private int quarters;
        private int dimes;
        private int nickels;
        private int pennies;

        //constructor
        public Till(int quarters, int dimes, int nickels, int pennies) {
            this.quarters = quarters;
            this.dimes = dimes;
            this.nickels = nickels;
            this.pennies = pennies;
        }

        public void purchase(double amt, double paid) {
            double calc = amt - paid;

            int change = (int)(Math.ceil(calc*100));
            int q = Math.round((int)change/25);
            change=change%25;
            int d = Math.round((int)change/10);
            change=change%10;
            int n = Math.round((int)change/5);
            change=change%5;
            int p = Math.round((int)change/1);
        
            System.out.println("Quarters: " + q);
            System.out.println("Dimes: " + d);
            System.out.println("Nickels: " + n);
            System.out.println("Pennies: " + p);
        }
    }
}