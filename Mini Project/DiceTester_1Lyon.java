import java.lang.Math;
import java.util.ArrayList;

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
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            rolls.add((int)(Math.random() * 6 + 1));
        }

        System.out.println(rolls);
    }
}