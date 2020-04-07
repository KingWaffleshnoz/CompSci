import java.lang.Math;
import java.util.Random;

/**
 * @author Jared Lyon
 * Sorts-A3: Selection Sorter
 * implementing a selection sorter that finds the largest element and moves it to the back of a list of elements
 */
public class SelSortTester_1Lyon {
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
            
            String temp = array[max];
            array[max] = array[i];
            array[i] = temp;
        }  
    }

    public static void main(String[] args) {
        String[] names = {"Darwin", "Daly", "Curie", "Archimedes", "Newton", "Einstein", "Roebling", "Hopper", "Galileo", "Tesla"}; //declare array

        //print
        System.out.println("Array:");
        for (int i = 0; i < names.length - 1; i++) {
            System.out.print(names[i] + " ");
        }

        //shuffle
        Random rand = new Random();
        for (int i = 0; i < names.length; i++) {
            int target = rand.nextInt(names.length);

			String temp = names[target];
			names[target] = names[i];
			names[i] = temp;
        }

        //print
        System.out.println("\nRandomized Array:");
        for (int i = 0; i < names.length - 1; i++) {
            System.out.print(names[i] + " ");
        }

        selSort(names, names.length); //sort

        //print
        System.out.println("\nSorted Array:");
        for (int i = 0; i < names.length - 1; i++) {
            System.out.print(names[i] + " ");
        }
    }
}