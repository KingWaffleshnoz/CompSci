import java.lang.Math;
import java.util.Random;

interface Sorter {
    int sort(int[] array, int n);
}

class SelectionSorter implements Sorter {
    /**
     * swaps two objects in an array
     * @param array specify which array to target
     * @param i object 1
     * @param j object 2
     */
    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * sorts an array BACK TO FRONT using a selection algorithm
     * @param array specify target array
     * @param n array length; can use array.length
     */
    public int sort(int[] array, int n) {
        int i; //first placeholder
        int j; //second placeholder
        int max; //current max
  
        for (i = array.length - 1; i >= 1; i--) {  
            max = i;  
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > max) {
                    max = j;
                }
            } 
            swap(array, max, i); //swap
        }  
    }
}

class InsertionSorter implements Sorter {
    /**
     * sorts an array using an insertion algorithm
     * @param array specifies target array
     * @param n array length
     */
    public int[] sort(int[] array, int n) {
        int i; //first placeholder
        int j; //second placeholder
        int min; //current min
        for ( i = 0; i < array.length; i++) {
            min = array[i];
            j = i - 1;

            while (array[j] > min && j >= 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array [j + 1] = min;
        }
    }
}

public class SortSpeedTester_1Lyon {
    int[] nums = new int[100];
    
    public void createNums() {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)((Math.random() * 100) + 1);
        }
    }

    public int[] getNums() {
        return nums;
    }

    public static void main(String[] args) {
        SelectionSorter sorterS = new SelectionSorter();
        InsertionSorter sorterI = new InsertionSorter();
      
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
}