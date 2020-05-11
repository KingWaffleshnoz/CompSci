import java.lang.Math;

/**
 * @author Jared Lyon
 * Rev-A7 Mini-Proj (P12.1)
 *  Write a program that simulates a vending machine. Products can be purchased by
    inserting coins with a value at least equal to the cost of the product. A user selects a
    product from a list of available products, adds coins, and either gets the product or
    gets the coins returned. The coins are returned if insufficient money was supplied
    or if the product is sold out. The machine does not give change if too much money
    was added. Products can be restocked and money removed by an operator. Follow
    the design process that was described in this chapter. Your solution should include a
    class VendingMachine that is not coupled with the Scanner or PrintStream classes.
 */
public class VendingMachineTester_1Lyon {
    public static void main(String[] args) {
        System.out.println("Jared Lyon\nP12.1\nVending Machine Sim\n");
        VendingMachine vendini = new VendingMachine(0, 3, 3);
        System.out.println(vendini);
        System.out.println("You insert three quarters and try to buy some chips:");
        System.out.println(vendini.buy("chips", 3));
        System.out.println("Oops, you try again with five quarters:");
        System.out.println(vendini.buy("chips", 5));
        System.out.println(vendini);
        System.out.println("Success! Let's buy some cookies now.");
        System.out.println("...");
        System.out.println("I think I put one too many quarters in. It needs six, not seven!");
        System.out.println(vendini.buy("cookies", 7));
        System.out.println(vendini);
        System.out.println("Hey! It stole my money! I'm getting the operator!");
        System.out.println("...");
        System.out.println("The operator opens the machine and takes the quarters.");
        System.out.println(vendini.collect());
        System.out.println(vendini);
        System.out.println("He gives me my extra quarter back and then restocks the machine;");
        System.out.println(vendini.restock("chips", 5));
        System.out.println(vendini);
        System.out.println(vendini.restock("cookies", 4));
        System.out.println(vendini);
        System.out.println("\nEnd sim.");
    }
}

class VendingMachine {
    private int quarters;
    private int chips;
    private int cookies;

    /**
     * creates a new class vendingmachine
     * @param quarters
     * @param chips
     * @param cookies
     */
    public VendingMachine(int quarters, int chips, int cookies) {
        this.quarters = quarters;
        this.chips = chips;
        this.cookies = cookies;
    }

    /**
     * takes quarters for a purchase
     * @param item
     * @param quartersInserted
     * @return
     */
    public String buy(String item, int quartersInserted) {
        if (item.equals("chips")) {
            if (quartersInserted >= 5 ) {
                chips--;
                quarters += quartersInserted;
                return "You bought some chips for " + quartersInserted + " quarters!";
            } else {
                return "Insufficient funds, five quarters are needed!";
            }
        } else if (item.equals("cookies")) {
            if (quartersInserted >= 6 ) {
                cookies--;
                quarters += quartersInserted;
                return "You bought some cookies for " + quartersInserted + " quarters!";
            } else {
                return "Insufficient funds, six quarters are needed!";
            }
        } else {
            return "Error, please specify the item you'd like to buy: cookies or chips.";
        }
    }

    /**
     * collects all quarters
     * @return
     */
    public String collect() {
        int temp = quarters;
        quarters = 0;
        return "Took " + temp + " quarters!";
    }

    /**
     * restocks an item with a given amount
     * @param item
     * @param amount
     * @return
     */
    public String restock(String item, int amount) {
        if (item.equals("chips")) {
            chips += amount;
            return "Restocked " + amount + " chips!";
        } else if (item.equals("cookies")) {
            cookies += amount;
            return "Restocked " + amount + " cookies!";
        } else {
            return "Error, please specify the item you'd like to restock: cookies or chips.";
        }
    }

    /**
     * to string yayyy
     */
    public String toString() {
        return "Quarters: " + quarters + " Chips: " + chips + " Cookies: " + cookies;
    }
}