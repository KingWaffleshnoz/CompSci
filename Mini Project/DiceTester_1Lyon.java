import java.util.Random;

/**
 * @author jared lyon
 * Rev-A7 Mini-Proj (P7.2)
 *  Write a program that generates a sequence of 20 random die tosses in an array and
    that prints the die values, marking only the longest run, like this:
    1 2 5 5 3 1 2 4 3 (2 2 2 2) 3 6 5 5 6 3 1
    If there is more than one run of maximum length, mark the first one.
 */
public class DiceTester_1Lyon {
    public static void main(String[] args) {
        //make rolls
        Random rand = new Random();
        int[] array = new int[20];
        int longestRun = 1;
        int currentRun = 1;
        int longestRunStart = 0;
        int currentRunStart = 1;

        System.out.print("Generated array: \n");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(6); //add random number
            System.out.print(array[i] + " "); //print array
            if (i != 0 && array[i - 1] == array[i]) {
                //if new number equals last number...
                currentRun++; //record current run
                if (currentRun > longestRun) {
                    longestRunStart = currentRunStart; //set index to newest run
                    longestRun = currentRun; //set above record to current run
                }
            } else {
                //if new number is different from the last number...
                currentRun = 1; //reset the current run length
                currentRunStart = i; //reset the current run start index
            }
        }

        //record results
        System.out.print("\nIdentifying longest run: \n");
        for (int i = 0; i < longestRunStart; i++) { System.out.print(array[i] + " "); } //prints all number leading up to the run
        System.out.print("( "); //add first parentheses
        for (int i = longestRunStart; i < (longestRunStart + longestRun); i++) { System.out.print(array[i] + " "); } //prints the run itself
        System.out.print(") "); //end parentheses
        for (int i = (longestRunStart + longestRun); i < 20; i++) { System.out.print(array[i] + " "); } //all remaining numbers
    }
}