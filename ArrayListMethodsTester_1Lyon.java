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
        System.out.println("List has 2 duplicate elements: " + methods.hasDuplicates());
        System.out.println("2nd largest element: " + methods.find2ndLargest());

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
            if(exValues.contains(n)) {
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
        values.set(0, values.size()-1);
        values.set(values.size()-1, temp);
    }

    public void rightShift() {
        int temp = values.get(values.size()-1);
        for (int i = 0; i < values.size()-1; i++) {
            values.set(i+1, i);
        }
        values.set(0, temp);
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
                int temp = values.get(i);
                for (int o = 0; o < values.size()-1; o++) {
                    values.set(o+1, o);
                }
                values.set(0, temp);
            }
        }
    }
}