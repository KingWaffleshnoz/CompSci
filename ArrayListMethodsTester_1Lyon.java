import java.util.ArrayList;

public class ArrayListMethodsTester_1Lyon {
    public static void main( String[] args ) {
        int[] testData = {3, 6, 9, 2, 1, 9, 4, 7, 5};
        ArrayListMethods methods = new ArrayListMethods( testData );
        System.out.println("Swapping first and last elements:");
        methods.swapFirstAndLast();
        methods.display();
        System.out.println("Right shifting all elements:");
        methods.rightShift();
        methods.display();
        System.out.println("Removing the middle element(s):");
        methods.removeMiddle();
        methods.display();

        System.out.println("List is sorted in increasing order: " + methods.isIncreasing());
        System.out.println("List has 2 adjacent duplicate elements: " + methods.hasAdjacentDuplicates());
        System.out.println("List has 2 duplicate elements: " + methods.hasDuplicates();
        System.out.println("2nd largest element: " + methods.find2ndLargest();

        System.out.println("Move even values to front, otherwise preserving the ordering:");
        methods.moveEvens();
        methods.display();
        System.out.println("Replacing each element except the first and last by the larger of its two neighbors:");
        methods.replaceViaNeighbor();
        methods.display();
        System.out.println("Replacing all elements with zero:");
        methods.replaceWithZero();
        methods.display();
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

    }

    public boolean hasDuplicates() {
        
    }

    public int find2ndLargest() {
        int largest = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (largest < values.get(i)) largest = values.get(i);
        }

        int output = largest;
        for (int i = 0; i < values.size(); i++) {
            int diff = Math.abs(largest - values.get(i));
            if (diff < output && diff != 0) output = values.get(i);
        }
        
        return output;
    }

    public boolean isIncreasing() {
        
    }

    //mutators
    public void swapFirstAndLast() {
        int temp = values.get(0);
        values.set(0, values.size()-1);
        values.set(values.size()-1, temp);
    }

    public void rightShift() {
        int temp = values.get(values.size()-1);
        for (int i = 0; i < values.size(); i++) {
            values.set(i+1, i);
        }
        values.set(0, temp);
    }

    public void replaceWithZero() {
        
    }

    public void replaceViaNeighbor() {
        
    }

    public void removeMiddle() {
        
    }

    public void moveEvens() {
        
    }
}