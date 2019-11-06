import java.util.Scanner;
import java.lang.Math;

public class CashRegisterTester_1LyonJ {
    public static void main(String[] args) {
        CashRegister market = new CashRegister(40, 100, 100, 100);
        market.purchase();
    }
}

class CashRegister {
    public boolean done;
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

    public void purchase(double amt, double paid) {
        amt = input.nextDouble();
        paid = input.nextDouble();

        double calc = amt - paid;
        if (amt < paid) {
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
                done = true;
            } else {
                purchase();
            }
        } else if (amt == paid) {
            System.out.println("You paid in exact change!");
        } else {
            System.out.println("Insufficient payment!");
            System.out.println("Resubmit funds:");
        }
    }

    public String toString() {
        String output = "Quarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies;
        return output;
    }
}