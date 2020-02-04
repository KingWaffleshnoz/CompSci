import java.util.Scanner;
import java.util.Arrays;

/**
 * Jared Lyon
 * AListA1: List o'Students LAB
 * This program can auto-generate a course or allow the user to create a course with student objects that contain names, GPAs, and heights.
 * The program can search via index, student name, and will report the tallest student in the course.
 */
public class StudentListTester_1Lyon {
    public static void main(String[] args) {
        System.out.println("Welcome to Jared's Xmas course creator version 2!\nInput class name:");
        Scanner input = new Scanner(System.in);
        String name = "";
        name = input.next();
        Course obj = new Course(name);
        obj.enroll();
        obj.findTallest();
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
    private double gpa; //out of 4
    private int height; //in cm

    //Constructor
    public Student(String name, double gpa, int height) {
        this.name = name;
        this.gpa = gpa;
        this.height = height;
    }

    //Mutators
    public void changeName(String input) {
        name = input;
    }

    public void changeGPA(double input) {
        gpa = input;
    }

    public void changeHeight(int input) {
        height = input;
    }

    //Accessors
    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        String output = "Student " + name + " is " + height + " cm tall and has a GPA of " + gpa;
        return output;
    }
}

class Course {
    private Student[] studentlist;
    private String name;
    private String tallestStudent;
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
            if (studentlist[i].getName().equals(name)) {
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
            studentlist = new Student[] { new Student("Carrie", 3.60, 170), new Student("Terry", 3.70, 175), new Student("Garry", 3.80, 180), new Student("Larry", 3.90, 185), new Student("Barry", 4.00, 190) };
        } else {
            studentlist = new Student[size];
            for (int i = 0; i < size; i++) {
                int z = i + 1;
                Scanner inputStudent = new Scanner(System.in);
                System.out.println("Input student " + z + "'s name:");
                String name = inputStudent.next();
                System.out.println("Input student " + z + "'s GPA (4.00 format, ex: 3.64):");
                double gpa = inputStudent.nextDouble();
                System.out.println("Input student " + z + "'s height (in cm, ex: 174):");
                int height = inputStudent.nextInt();
                studentlist[i] = new Student(name, gpa, height);
            }
        }
    }

    public void findTallest() {
        int max = 0;
        String output = "";

        for (int i = 0; i < studentlist.length; i++) {
            if (studentlist[i].getHeight() > max) {
                max = studentlist[i].getHeight();
                output = studentlist[i].getName();
            }
        }

        tallestStudent = output;
    }

    //toString
    public String toString() {
        String output = "Course: " + name + "\n" + Arrays.toString(studentlist) + "\n" + tallestStudent + " is the tallest student in the course.";
        return output;
    }
}