import java.util.Scanner;

/**
   Sorts-A1b: BinSearch
   @author Jared Lyon
   Learn, understand and implement the binary search algorithm.
*/
interface Finder {
   int find(String[] haystack, String needle);
}

//seq finder from linsearch
class SequentialFinder implements Finder {
   /**
        looks for a given string and returns the location or if it's not found
        @param needle what to look for
        @param haystack where to look
   */
   public int find(String[] haystack, String needle) {
       System.out.println("Checking index: ");
        for (int i = 0; i < haystack.length; i++) {
            System.out.print(i + " ");
            if (haystack[i].equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

//binary for binsearch
class BinaryFinder implements Finder {
    /**
        Create a class BinaryFinder that implements Finder. 
        BinaryFinder shall perform a binary search to look for needle in the haystack.
        @param needle what to look for
        @param haystack where to look
    */
    public int find(String[] haystack, String needle) {
        //create ends
        int leftSearch = 0; //start at beginning
        int rightSearch = haystack.length - 1; //start at end
        int center = (leftSearch + (rightSearch - leftSearch)) / 2; //find center of array
        int marker = needle.compareTo(haystack[center]);
        
        while (rightSearch >= leftSearch) {
            center = leftSearch + (rightSearch - leftSearch) / 2; //update center of array
            marker = needle.compareTo(haystack[center]); //update marker
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

public class BinaryFinder_1LyonV2 {
    public static void main(String[] args) {
        //make the finders
        SequentialFinder finderS = new SequentialFinder();
        BinaryFinder finderB = new BinaryFinder();
        Scanner input = new Scanner(System.in);
        boolean looping = true;

        while (looping) {
            //binary or seq?
            System.out.println("----------");
            System.out.println("Which finder would you like to use?\n'1' for sequential\n'2' for binary");
            int finderChoice = input.nextInt();

            if (finderChoice == 1) {
                System.out.println("----------");

                //ask user for search
                System.out.println("Enter query:");
                String target = input.next();

                //return answer
                System.out.println("Returning query...");
                int output = finderS.find(getList(), target);

                if (output == -1) {
                    System.out.println("Query not found!"); //if not found
                } else {
                    System.out.println("\nTarget found at index " + output + "!"); //if target found
                }

                System.out.println("----------");
            } else if (finderChoice == 2) {
                System.out.println("----------");

                //ask user for search
                System.out.println("Enter query:");
                String target = input.next();

                //return answer
                System.out.println("Returning query...");
                int output = finderB.find(getList(), target);

                if (output == -1) {
                    System.out.println("Query not found!"); //if not found
                } else {
                    System.out.println("\nTarget found at index " + output + "!"); //if target found
                }

                System.out.println("----------");
            } else {
                return;
            }

            System.out.println("Exit program?\n'1' to continue");
            int looperChoice = input.nextInt();
            if (looperChoice != 1) {
                System.out.println("Thanks for playing! Have a great day :)");
                looping = false;
            }
        }
    }

    public static String[] getList() {
        String[] names = { "Adams", "Amarillas", "Baxter", "Duong","Giraudo",   /**indices 0 - 4 */
                           "Gonzalez", "Hansbrough", "Kniffin", "Lindemann",    /**indices 5 - 8 */
                           "Lum", "Mathurin", "McCullough", "Molina",           /**indices 9 - 12 */
                           "Reyerson", "Ward", "Wolf", "Wong", "Zabinski" };    /**indices 13 - 17 */
        return names;
    }
}