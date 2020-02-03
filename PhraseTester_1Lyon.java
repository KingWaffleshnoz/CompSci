/**
 * Jared Lyon
 * Loops-A11: FRQ practice
 * A short program that makes a string, replaces some of it, and prints a lot of it
 */

public class PhraseTester_1Lyon {
    //main
    public static void main(String[] args) {
       Phrase yes = new Phrase("This is a test that is mediocre.");
       System.out.println(yes);
       System.out.println("'is' occurs a second time at index " + yes.findNthOccurrence("is", 2) + ".");
       yes.replaceNthOccurrence("is", 2, "be");
       System.out.println(yes + " And now it also has poor grammar.");
       System.out.println("The final appearance of 'is' is at index " + yes.findLastOccurrence("is") + ".");
    }
 }
 
class Phrase {
    private String str;

    //constructor
    public Phrase(String str) {
       this.str = str;
    }
 
    //accessors
    public int findNthOccurrence(String x, int n) {
       int occ = str.indexOf(x);

       for (int i = 1; i < n; i++) {
          if (occ < 0) break;
          occ = str.indexOf(x, occ + 1);
       }

       return occ;
    }

    public int findLastOccurrence(String x) {
        boolean z = false;
        int i = str.length() - 1;
        int iCheck = -1;
 
        while (!z) {
           if (str.substring(i).indexOf(str) != -1) {
              z = true;
              iCheck = i;
           }
 
           i -= 1;
        }
 
        return iCheck;
     }

    //mutator
    public void replaceNthOccurrence(String x, int n, String y) {
       int yRep = findNthOccurrence(x, n);

       if (yRep != -1) {
          str = str.substring(0, yRep) + y +
                          str.substring(yRep + y.length());
       }
    }
 
    //toString
    public String toString() {
       return str;
    }
 }