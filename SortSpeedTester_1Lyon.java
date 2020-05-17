import java.util.Random;

/**
 * @author Jared Lyon
 * Sorts-A4: Sort Speed Tester
 * Tests the speed of selection and insertion sorter algorithms in ordered and random arrays
 */
interface Sorter {
    void sort(int[] haystack);
}

class SelectionSorter implements Sorter {
    /**
     * swaps inputted arguments 
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * finds maxPos of inputted array
     * @param arr
     * @param to
     * @return
     */
    public static int maxPosition(int[] arr, int n) {
        int max = 0;
        int maxItem = arr[0];
        for (int i = 1; i <= n; i++) {
            if (maxItem < arr[i]) {
                maxItem = arr[i];
                max = i;
            }
        }
        return max;
    }

    /**
     * sorts the given array via selection
     * @param arr
     */
    public void sort(int[] arr) {
        for (int i = arr.length-1; i >= 0; i--) {
            int j = maxPosition(arr, i);
            swap(arr, j, i);
        }
    }
}

class InsertionSorter implements Sorter {
    /**
     * sorts the given array via insertion
     * @param arr
     */
    public void sort (int[] arr) {
        for (int i = 1; i < arr.length; i++ ) {
            int next = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > next) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = next;
        }
    }
}

public class SortSpeedTester_1Lyon {
    public static void main(String[] args) {
        Sorter sorter = new SelectionSorter();
        System.out.println("----------");
        System.out.println("Testing selection sorter...");
        System.out.println("Random array test:");
        System.out.println(runTest(sorter, 25400, false) + " milliseconds!");
        System.out.println("Ordered array test:");
        System.out.println(runTest(sorter, 25400, true) + " milliseconds!");

        System.out.println("----------");
        System.out.println("Switching to insertion sorter...");
        sorter = new InsertionSorter(); //set sorter to insertion
        System.out.println("Random array test:");
        System.out.println(runTest(sorter, 25400, false) + " milliseconds!");
        System.out.println("Ordered array test:");
        System.out.println(runTest(sorter, 25400, true) + " milliseconds!");
        System.out.println("----------");

        System.out.println("\nThanks for testing and go Bells! :)");
    }

    /**
     * tests the inputted sorter yay woohoo
     * @param sorter
     * @param size
     * @param sorted
     * @return
     */
    public static long runTest(Sorter sorter, int size, boolean sorted) {
        long start = System.currentTimeMillis(); //shoutout to ben for teaching me how to use long
        int[] array = generate(size, sorted); //see below function
        sorter.sort(array); //sort the inputted array
        long finish = System.currentTimeMillis(); //grab the end time
        return (finish - start); //print result
    }
   
    public static int[] generate(int size, boolean sorted) {
        Random randomGenerator = new Random();
        int[] array = new int[size];
        if (sorted) {
            array[0] = randomGenerator.nextInt(Integer.MAX_VALUE / size);
            for (int i = 1; i < size; i++) {
                array[i] = array[i - 1] + randomGenerator.nextInt(Integer.MAX_VALUE / size);
            }
        } else if (!sorted) {
            for (int j = 0; j < size; j++) {
                array[j] = randomGenerator.nextInt(Integer.MAX_VALUE);
            }
        }
        return array;
    }
}