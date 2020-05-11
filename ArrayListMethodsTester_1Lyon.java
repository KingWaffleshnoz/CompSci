import java.util.ArrayList;

/**
 * Jared Lyon
 * AList-A4: Methods w/ArrayList
 * Creates and arraylist and tests multiple accessors and mutators
 */
public class ArrayListMethodsTester_1Lyon {
    public static void main( String[] args ) {
        //init arraylist
        int[] testData = {3, 6, 9, 2, 1, 9, 4, 7, 5};
        ArrayListMethods methods = new ArrayListMethods(testData);
        System.out.println("Array list:");
        methods.display();

        System.out.println("-----------------------------");

        //test all accessors
        System.out.println("List is sorted in increasing order: " + methods.isIncreasing());
        System.out.println("List has 2 adjacent duplicate elements: " + methods.hasAdjacentDuplicates());
        System.out.println("List has 2 duplicate elements: " + methods.hasDuplicates());
        System.out.println("2nd largest element: " + methods.find2ndLargest());

        System.out.println("-----------------------------");

        //mutators that move/remove items
        System.out.println("Swapping first and last elements:");
        methods.swapFirstAndLast();
        methods.display();
        System.out.println("Right shifting all elements:");
        methods.rightShift();
        methods.display();
        System.out.println("Removing the middle element(s):");
        methods.removeMiddle();
        methods.display();

        System.out.println("-----------------------------");

        //retest all accessors
        System.out.println("List is sorted in increasing order: " + methods.isIncreasing());
        System.out.println("List has 2 adjacent duplicate elements: " + methods.hasAdjacentDuplicates());
        System.out.println("List has 2 duplicate elements: " + methods.hasDuplicates());
        System.out.println("2nd largest element: " + methods.find2ndLargest());

        System.out.println("-----------------------------");

        //mutators that would otherwise break accessors
        System.out.println("Move even values to front, otherwise preserving the ordering:");
        methods.moveEvens();
        methods.display();
        System.out.println("Replacing each element except the first and last by the larger of its two neighbors:");
        methods.replaceViaNeighbor();
        methods.display();
        System.out.println("Replacing all elements with zero:");
        methods.replaceWithZero();
        methods.display();

        System.out.println("-----------------------------");

        //retest all accessors with mutated stuff
        System.out.println("List is sorted in increasing order: " + methods.isIncreasing());
        System.out.println("List has 2 adjacent duplicate elements: " + methods.hasAdjacentDuplicates());
        System.out.println("List has 2 duplicate elements: " + methods.hasDuplicates());
        System.out.println("2nd largest element: " + methods.find2ndLargest());
    }
}

class ArrayListMethods {
    private ArrayList<Integer> values;

    //constructor
    public ArrayListMethods( int[] data ) {
        values = new ArrayList<Integer>();
        for( int i : data ) values.add( i );
    }

    //accessors
    public void display() {
        System.out.println(values);
    }

    public boolean hasAdjacentDuplicates() {
        int duplicate = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) != duplicate) {
                duplicate = values.get(i);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicates() {
        ArrayList<Integer> exValues = new ArrayList<Integer>();
        for (int n : values) {
            if (exValues.contains(n)) {
                return true;
            } else {
                exValues.add(n);
            }
        }
        return false;
    }

    public int find2ndLargest() {
        int largest = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (largest < values.get(i)) {
                largest = values.get(i);
            }
        }

        int largest2 = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (largest2 < values.get(i) && values.get(i) < largest) {
                largest2 = values.get(i);
            }
        }

        return largest2;
    }

    public boolean isIncreasing() {
        int largest = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > largest) {
                largest = values.get(i);
            } else {
                return false;
            }
        }
        return true;
    }

    //mutators
    public void swapFirstAndLast() {
        int temp = values.get(0);
        values.set(0, values.get(values.size()-1));
        values.set(values.size()-1, temp);
    }

    public void rightShift() {
        int last = values.get(values.size()-1);
        for (int i = values.size()-2; i >= 0; i--) {
            values.set(i+1, values.get(i));
        }
        values.set(0, last);
    }

    public void replaceWithZero() {
        for (int i = 0; i < values.size(); i++) {
            values.set(i, 0);
        }
    }

    public void replaceViaNeighbor() {
        for (int i = 0; i < values.size(); i++) {
            if (i != values.size() - 1 && values.get(i) < values.get(i+1)) {
               values.set(i, values.get(i+1));
            }

            if (i != 0 && values.get(i) < values.get(i-1)) {
               values.set(i, values.get(i-1));
            }
        }
    }

    public void removeMiddle() {
        int size = values.size();
        if (size % 2 == 0) {
            values.remove(size / 2);
            values.remove((size / 2) + 1);
        } else if (size % 2 != 0) {
            values.remove(size / 2);
        }
    }

    public void moveEvens() {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) % 2 == 0) {
               values.add(0, values.get(i));
               values.remove(i+1);
               i -= 1;
            }
        }
    }
}