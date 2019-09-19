/**
 * E3.12 - Hybrid Car Build
 * Class-A1: First Class
 * Jared Lyon
 * Period 1
 */
public class CarTester_1Lyon {
    public static void main(String[] args) {
        //object 1
        Car Mazda = new Car(30); //30mpg, like my real Mazda3
        System.out.println("You start with a silver 2014 Mazda3 hatchback that gets an average of 30 miles per gallon.");
        Mazda.addGas(13); //add 13 gallons of gas
        System.out.println("You spend about $46.80 at your local Chevron gas station to fill her up!");
        Mazda.drive(117); //drive 117 miles
        System.out.println("Now, you drive the 117 miles to the California State Capitol from Bellarmine College Preparatory to advocate for better labor laws!");
        double gasLeftMazda = Mazda.getGasInTank(); //return amt of gas left
        System.out.println("The Mazda started with 13 gallons of gas, then drove 117 miles at 30 miles per gallon. It now has about " + gasLeftMazda + " gallons of gas left. Enough to make it home!");

        //divider
        System.out.println("-----");

        //object 2
        Car Toyota = new Car(17, 15); //17mpg, like my fam's old toyota
        System.out.println("You start with a gold 2009 Toyota Highlander that gets an average of 17 miles per gallon and also already has 15 gallons of gas in the tank.");
        Toyota.addGas(4); //add 4 gallons of gas
        System.out.println("You spend about $14.40 at your local Chevron gas station to fill her up!");
        Toyota.drive(181); //drive 181 miles
        System.out.println("Now, you drive the 181 miles to Yosemite Valley from Bellarmine College Preparatory to explore what nature really means!");
        double gasLeftToyota = Toyota.getGasInTank(); //return amt of gas left
        System.out.println("The Toyota started with 15 gallons of gas and then you added another 4 gallons to top her off, then drove 181 miles at 30 miles per gallon. It now has about " + gasLeftToyota + " gallons of gas left. I don't think we'll make it back this time, Sulu...");
    }
}

/**
 * Build car n stuff
 */
class Car {
    private int mpg;
    private int gas;

    //Constructor for just mpg
    public Car(int miles) {
        mpg = miles;
        gas = 0;
    }
    //Constructor for mpg and gas
    public Car(int miles, int priorGas) {
        mpg = miles;
        gas = priorGas;
    }
    

    //Accessors
    public int getGasInTank() {
        return gas;
    }

    //Mutators
    public void addGas(int amt) {
        gas += amt;
    }

    public void drive(int dist) {
        int x = dist / mpg;
        gas -= x;
    }
}