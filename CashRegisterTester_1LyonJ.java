import java.util.Scanner;
import java.lang.Math;

public class CashRegisterTester_1LyonJ {
    public static void main(String[] args) {
        CashRegister market = new CashRegister(40, 100, 100, 100);
        System.out.println("Author: Jared Lyon\n-<>- Bellarmine Market -<>-");
        market.purchase();
    }
}

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

    public void purchase() {
        System.out.println("Input purchase amount:");
        double amt = input.nextDouble();
        System.out.println("Input payment amount:");
        double paid = input.nextDouble();

        if (amt < paid) {
            double calc = amt - paid;
            int change = (int)(Math.ceil(calc * 100));
            int q = Math.round((int)change / 25);
            change = change % 25;
            int d = Math.round((int)change / 10);
            change = change % 10;
            int n = Math.round((int)change / 5);
            change = change % 5;
            int p = Math.round((int)change / 1);

            quarters =- q;
            dimes =- d;
            nickels =- n;
            pennies =- p;

            if (q == 0 && d == 0 && n == 0 && p == 0) {
                System.out.println("Insufficient till change!");
            } else {
                toString();
                System.out.println("Continue? [1]");
                int yes = input.nextInt();
                if (yes == '1') {
                    purchase();
                } else {
                    return;
                }
            }
        } else if (amt == paid) {
            System.out.println("You paid in exact change!");
        } else {
            System.out.println("Insufficient payment!");
            System.out.println("------\nRestarting...\n------");
            purchase();
        }
    }

    public String toString() {
        return "Quarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies;
    }
}