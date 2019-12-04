import java.util.Scanner;
import java.lang.Math;
//import scanner and math

/**
 * Jared Lyon
 * LoopsA4: Bell Mkt Coin Chgr
 * This program emulates a simple cash register used for cash purchases
 */
public class CashRegisterTester_1LyonJV2 {
    public static void main(String[] args) {
        CashRegister market = new CashRegister(250, 250, 500, 1000);
        System.out.println("Author: Jared Lyon\n-<>- Teaspoon Cash Register -<>-");
        market.purchase();
    }
}

//yay class!!
class CashRegister {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    Scanner input = new Scanner(System.in);

    //constructor
    public CashRegister(int quarters, int dimes, int nickels, int pennies) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }

    //purchase method
    public void purchase() {
        System.out.println("------\nBeginning new transacation...\n------\nInput purchase amount:");
        double amt = input.nextDouble();
        System.out.println("------\nInput payment amount:");
        double paid = input.nextDouble();

        //do thing?
        if (amt < paid) {
            //yes do thing, calculate change here
            double calc = amt - paid;
            int change = (int)(Math.ceil(calc * 100));
            int q = Math.round((int)change / 25);
            change = change % 25;
            int d = Math.round((int)change / 10);
            change = change % 10;
            int n = Math.round((int)change / 5);
            change = change % 5;
            int p = Math.round((int)change / 1);

            //take monies from till
            quarters += q;
            dimes += d;
            nickels += n;
            pennies += p;

            //die if outta money or keep going
            if (q < -250 || d < -250 || n < -500 || p < -1000) {
                System.out.println("------\nInsufficient till change to complete your purchase!");
                System.out.println("Exiting register...\n------");
            } else if (quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0) {
                System.out.println("The till lacks the needed coins!\nExiting register...\n------");
            } else {
                System.out.println(toString());
                System.out.println("Continue? [1]");
                int yes = input.nextInt();
                if (yes == 1) {
                    purchase();
                } else {
                    return;
                }
            }
        //stop on exact payment
        } else if (amt == paid) {
            System.out.println("------\nYou paid in exact change!");
            System.out.println("Continue? [1]");
            int yes = input.nextInt();
            if (yes == 1) {
                purchase();
            } else {
                return;
            }
        //stop on bad payment
        } else {
            System.out.println("------\nInsufficient payment! Restarting...");
            purchase();
        }
    }

    //return till values
    public String toString() {
        int q = 250 - quarters;
        int d = 250 - dimes;
        int n = 500 - nickels;
        int p = 1000 - pennies;
        return "------\nChange distributed:\n Quarters: " + q + "\nDimes: " + d + "\nNickels: " + n + "\nPennies: " + p + 
                "\n------\nRemaining Change: \nQuarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies + "\n------";
    }
}