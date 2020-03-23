import java.util.Scanner;

/**
   Sorts-Asg1: LinSearch
   @author Jared Lyon
   Practice working with interfaces while learning different ways to search for things in an array.
*/
interface Finder {
   int find(String[] haystack, String needle);
}

class SequentialFinder implements Finder {
   /**
      looks for a given string and returns the location or if it's not found
      @param needle what to look for
      @param haystack where to look
   */
   public int find(String[] haystack, String needle) {
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i].equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

public class SequentialFinder_1Lyon {
    public static void main(String[] args) {
        //make things
        SequentialFinder finderS = new SequentialFinder();
        Scanner input = new Scanner(System.in);

        //ask user for search
        System.out.println("Enter query:");
        String target = input.next();

        //return answer
        System.out.println("Returning query...");
        int output = finderS.find(getList(), target);

        if (output == -1) {
            System.out.println("Query returned null."); //if not found
        } else {
            System.out.println("Target found at index " + output + "!"); //if target found
        }
    }

    public static String[] getList() {
        String[] names = { "Adams", "Amarillas", "Baxter", "Duong","Giraudo", 
                           "Gonzalez", "Hansbrough", "Kniffin", "Lindemann",
                           "Lum", "Mathurin", "McCullough", "Molina", 
                           "Reyerson", "Ward", "Wolf", "Wong", "Zabinski" };
        return names;
    }
}