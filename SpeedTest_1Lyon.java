import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

/**
   Sorts-Asg2: Speed Test
   @author Jared Lyon
   testing binary and linear searching with high volumes of data to see which is faster
*/
interface IntFinder {
   int find(int[] haystack, int needle);
}

//seq finder from linsearch
class SequentialFinder implements IntFinder {
   /**
        looks for a given string and returns the location or if it's not found
        @param needle what to look for
        @param haystack where to look
   */
   public int find(int[] haystack, int needle) {
        for (int i = 0; i < haystack.length; i++) {
            System.out.print(i + " ");
            if (haystack[i] == needle) {
                return i;
            }
        }
        return -1;
    }
}

//binary for binsearch
class BinaryFinder implements IntFinder {
    /**
        Create a class BinaryFinder that implements Finder. 
        BinaryFinder shall perform a binary search to look for needle in the haystack.
        @param needle what to look for
        @param haystack where to look
    */
    public int find(int[] haystack, int needle) {
        //create ends
        int leftSearch = 0; //start at beginning
        int rightSearch = haystack.length - 1; //start at end
        int center = (leftSearch + (rightSearch - leftSearch)) / 2; //find center of array
        int marker = (needle - haystack[center]);
        
        while (rightSearch >= leftSearch) {
            center = leftSearch + (rightSearch - leftSearch) / 2; //update center of array
            marker = (needle - haystack[center]); //update marker
            if (marker > 0) {
                leftSearch = center + 1;
            } else if (marker < 0) {
                rightSearch = center - 1;
            } else if (marker == 0) {
                return center;
            }
        }
        return -1; //if not found
    }
}

public class SpeedTest_1Lyon {
    public static void main(String[] args) {
        SequentialFinder finderS = new SequentialFinder();
        BinaryFinder finderB = new BinaryFinder();
      
        System.out.println("Testing Sequential Finder with an array of 25400...");
        System.out.println("Finished in: " + runTest(finderS, 25400) + "  ms");
        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Binary Finder with an array of 25400...");
        System.out.println("Finished in: " + runTest(finderB, 25400) + "  ms");
    }

    public static long runTest(IntFinder finder, int numInts) {
        Random random = new Random(); //create random generator
        int[] array = new int[numInts]; //create int array
        array[0] = random.nextInt(Integer.MAX_VALUE / numInts); //start array[0] as a random int between 0 and Integer.MAX_VALUE/numInts

        //fill out the rest of the array
        for (int i = 1; i < numInts; i++) {
           array[i] = array[i-1] + random.nextInt(Integer.MAX_VALUE / numInts);
        }

        long startTime = System.currentTimeMillis(); //get the current system time (in milliseconds)
        
        //search for 10 random values inside of the array
        for (int i = 0; i < 10; i++) {
           int key = array[random.nextInt(array.length)];
           finder.find(array, key);
        } 

        long endTime = System.currentTimeMillis(); //record end time
        System.out.println("Ten tests finished in " + (endTime - startTime) + " ms!"); //return time elapsed

        //If this completes quickly, then go to 50 or 100 tests.
        if (5 > (endTime - startTime)) {
            System.out.println("Test completed too quickly; conducting one hundred...");
            startTime = System.currentTimeMillis(); //reset start time

            ////search for 100 random values inside of the array
            for (int i = 0; i < 100; i++) {
                int key = array[random.nextInt(array.length)];
                finder.find(array, key);
            }

            endTime = System.currentTimeMillis(); //reset end time
        }
        System.out.println("Tests finished in " + (endTime - startTime) + " ms!"); //return time elapsed
        return endTime - startTime;
    }

    public static String[] getList() {
        String[] names = { "Adams", "Amarillas", "Baxter", "Duong","Giraudo",   /**indices 0 - 4 */
                           "Gonzalez", "Hansbrough", "Kniffin", "Lindemann",    /**indices 5 - 8 */
                           "Lum", "Mathurin", "McCullough", "Molina",           /**indices 9 - 12 */
                           "Reyerson", "Ward", "Wolf", "Wong", "Zabinski" };    /**indices 13 - 17 */
        return names;
    }
}