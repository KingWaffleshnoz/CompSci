import java.util.Scanner;
import java.util.Arrays;

/**
 * Jared Lyon
 * Array-A4: Find Student
 * Helps the user create an array class and search it via index or string
 */
public class TurkeyTester_1Lyon {
    public static void main(String[] args) {
        System.out.println("Welcome to Jared's course creator!\nInput class name:");
        Scanner input = new Scanner(System.in);
        String name = "";
        name = input.next();
        Course obj = new Course(name);
        obj.enroll();
        System.out.println(obj.toString());

        boolean done = false;
        while (!done) {
            System.out.println("Search index:");
            int get = input.nextInt();
            System.out.println(obj.get(get));
            
            System.out.println("Search name:");
            String find;
            find = input.next();
            System.out.println(obj.find(find));

            //done?
            System.out.println("Continue? [1]");
            int yes = input.nextInt();
                if (yes == 1) {
                    done = false;
                } else {
                    System.out.println("Exiting...");
                    return;
                }
        }
    }
}

class Course {
    private String[] students;
    private String name;
    private int temp;

    //Constructor
    public Course(String name) {
        this.name = name;
    }

    //Accessors
    public String get(int index) {
        String x = students[index - 1];
        return x;
    }

    public int find(String name) {
        int len = students.length;
        for (int i = 0; i < len; i++) {
            if (students[i].equals(name)) {
                temp = i;
                break;
            } else {
                temp = 0;
            }
        }
        return temp += 1;
    }

    //Mutator
    public void enroll() {
        System.out.println("Input class size (enter '0' to autogenerate class):");
        Scanner inputSize = new Scanner(System.in);
        int size = inputSize.nextInt();

        if (size == 0) {
            students = new String[] { "Barry", "Larry", "Garry", "Terry", "Carrie", "Robert", "Bert", "Rob", "Bob", "Robbie" };
        } else {
            students = new String[size];
            for (int i = 0; i < size; i++) {
                int z = i + 1;
                System.out.println("Input student " + z + "'s name:");
                Scanner inputStudent = new Scanner(System.in);
                students[i] = inputStudent.next();
            }
        }
    }

    //toString
    public String toString() {
        String output = "Course: " + name + "\n" + Arrays.toString(students);
        return output;
    }
}