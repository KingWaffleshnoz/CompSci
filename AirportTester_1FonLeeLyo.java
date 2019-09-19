package CompSci;

/**
 * Antonio Fontan, Allan Lee, Jared Lyon
 * Class-A7: Demo Class
 * Models an airport where an employee upgrades the tester class and adds fuel
 */
public class AirportTester_1FonLeeLyo {
    public static void main(String[] args) {
        //Object A
        Plane p1 = new Plane(189, 750, "Boeing 737-800");
        System.out.println(p1);
        System.out.println("Your boss tells you to upgrade one of the rows of seats so the plane can " +
                            "hold five more passengers.");
        p1.upgrade();
        System.out.println("Now the plane needs about five thousand more pounds of fuel to fly another hour south. " +
                            "You fill the plane with 750 gallons of fuel.");
        p1.fill(750);
        System.out.println(p1);

        //divider
        System.out.println("------");

        //Object B
        Plane p2 = new Plane(525, 81000, "Airbus A380");
        System.out.println(p2);
        System.out.println("Your boss tells you to upgrade one of the rows of seats so the plane can " +
                            "hold five more passengers.");
        p2.upgrade();
        System.out.println("You also need to top off the tank for an 8000 nautical mile flight. " +
                            "You fill the plane with 890 gallons of fuel.");
        p2.fill(890);
        System.out.println(p2);
    }
 }
 
/**
 * Creates a class plane with passenger capacity, fuel, and model name
 */
class Plane {
    private int capacity;
    private int fuel;
    private String model;

    //constructors
    public Plane(int capacity, int fuel, String model) {
        this.capacity = capacity;
        this.fuel = fuel;
        this.model = model;
    }

    //accessors
    public String toString() {
        String output = "Model: " + model + "\nCapacity: " + capacity + " passengers" + 
                        "\nCurrent Fuel: " + fuel + " gallons";
        return output;
    }

    //mutators
    public void fill(int amt) {
        fuel = fuel + amt;
    }
    public void upgrade() {
        capacity = capacity + 5;
    }
}