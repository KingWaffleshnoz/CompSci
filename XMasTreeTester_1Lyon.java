import java.util.Scanner;
import java.util.Arrays;

/**
 * Jared Lyon
 * Arrays-A9: Student Array (XMasTree)
 * Helps the user create an array class and search it via index or string
 */
public class XMasTreeTester_1Lyon {
    public static void main(String[] args) {
        System.out.println("Welcome to Jared's Xmas course creator!\nInput class name:");
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

class Student {
    private String name;

    //Constructor
    public Student(String name) {
        this.name = name;
    }

    //Mutator
    public void changeName(String input) {
        name = input;
    }

    //Accessors
    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}

class Course {
    private Student[] studentlist;
    private String name;
    private int temp;

    //Constructor
    public Course(String name) {
        this.name = name;
    }

    //Accessors
    public String get(int index) {
        return studentlist[index - 1].toString();
    }

    public int find(String name) {
        int len = studentlist.length;
        for (int i = 0; i < len; i++) {
            if (studentlist[i].toString().equals(name)) {
                temp = i;
                break;
            } else {
                temp = -1;
            }
        }
        return temp += 1;
    }

    //Mutator
    public void enroll() {
        System.out.println("Input your class size (enter '0' to autogenerate class):");
        Scanner inputSize = new Scanner(System.in);
        int size = inputSize.nextInt();

        if (size == 0) {
            studentlist = new Student[] { new Student("Barry"), new Student("Larry"), new Student("Garry"), new Student("Terry"), new Student("Carrie") };
        } else {
            studentlist = new Student[size];
            for (int i = 0; i < size; i++) {
                int z = i + 1;
                System.out.println("Input student " + z + "'s name:");
                Scanner inputStudent = new Scanner(System.in);
                studentlist[i] = new Student(inputStudent.next());
            }
        }
    }

    //toString
    public String toString() {
        String output = "Course: " + name + "\n" + Arrays.toString(studentlist);
        return output;
    }
}