import Java.util.Scanner;

public class CashRegisterTester_1LyonJ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Till market = new Till(40, 100, 100, 100);

        while(tillVal > 0) {
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
        
    }
}