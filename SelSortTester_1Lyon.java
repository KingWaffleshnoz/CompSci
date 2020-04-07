import java.lang.Math;
import java.util.Random;

/**
 * @author Jared Lyon
 * Sorts-A3: Selection Sorter
 * implementing a selection sorter that finds the largest element and moves it to the back of a list of elements
 */
public class SelSortTester_1Lyon {
    /**
     * swaps two objects in an array
     * @param array specify which array to target
     * @param i object 1
     * @param j object 2
     */
    public static void swap(String array[], int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * sorts an array BACK TO FRONT using a selection algorithm
     * @param array specify target array
     * @param n array length; can use array.length
     */
    public static void selSort(String array[], int n) {
        int i; //first placeholder
        int j; //second placeholder
        int max; //current max
  
        for (i = array.length - 1; i >= 1; i--) {  
            max = i;  
            for (j = i - 1; j >= 0; j--) {
                if (array[j].compareTo(array[max]) > 0) {
                    max = j;
                }
            } 
            
            swap(array, max, i);
        }  
    }

    //test selsort method
    public static void main(String[] args) {
        String[] names = {"Darwin", "Daly", "Curie", "Archimedes", "Newton", "Einstein", "Roebling", "Hopper", "Tesla", "Galileo"}; //declare array

        //print original (above)
        System.out.println("Array:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }

        //shuffle it
        Random rand = new Random();
        for (int i = 0; i < names.length; i++) {
            int target = rand.nextInt(names.length);

			String temp = names[target];
			names[target] = names[i];
			names[i] = temp;
        }

        //print shuffled array
        System.out.println("\nRandomized Array:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }

        selSort(names, names.length); //sort

        //print sorted array
        System.out.println("\nSorted Array:");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + " ");
        }
    }
}