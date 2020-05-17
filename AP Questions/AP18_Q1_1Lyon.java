import java.lang.Math;

/**
 * @author Jared Lyon
 * AP18_Q1
 * Make a working demo program using the code in the FRQ
 */
public class AP18_Q1_1Lyon {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            FrogSimulation FrogSim = new FrogSimulation(23, 5);
            FrogSim.runSimulations(10);
            System.out.println("Running simulation test " + (i + 1) + "...");
            System.out.println("Success rate of " +  (100 * FrogSim.runSimulations(50)) + "%");
        }
    }
}

class FrogSimulation {
    private int goalDistance;
    private int maxHops;

    public FrogSimulation(int goalDistance, int maxHops) {
        this.goalDistance = goalDistance;
        this.maxHops = maxHops;
    }

    private int hopDistance() {
        return (int)(Math.random() * 12) + 1; //up to a foot
    }
   
    //part a
    public boolean simulate() {
        int position = 0;
        for (int i = 0; i < maxHops; i++) {
            position += hopDistance();

            if (goalDistance <= position) {
                return true;
            } else if (position < 0) {
                return false;
            }
        }
        return false;
    }

    //part b
    public double runSimulations(int num) {
        int success = 0;
        for (int i = 0; i < num; i++) {
            if (simulate() == true) {
                success++;
            };
        }
        return (double)(success) / num;
    }
}