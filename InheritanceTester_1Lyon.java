/**
 * Jared Lyon
 * Inheritance Tester Lab
 * Creates class Person which is extended by class Student
 */
public class InheritanceTester_1Lyon {
    public static void main(String[] args) {
        Student guy1 = new Student();
        System.out.println(guy1);
        System.out.println("Promoting...");
        guy1.promote();
        System.out.println(guy1);
        System.out.println("Promoting by three grades...");
        guy1.promote();
        guy1.promote();
        guy1.promote();
        System.out.println(guy1);

        System.out.println("----------------");

        Student guy2 = new Student("Cart McBenjamin", 12);
        System.out.println(guy2);
        System.out.println("Changing name...");
        guy2.changeName("McJamin Cartyben");
        System.out.println(guy2);
    }
}

class Person {
    private String name;

    //constructor
    public Person(String name) {
        this.name = name;
    }

    //accessor
    public String toString() {
        return name;
    }

    //mutator
    public void changeName(String newName) {
        name = newName;
    }
}

class Student extends Person {
    private int grade;

    //constructor
    public Student() {
        super("Benjamin McCarty");
    }

    public Student(String name, int gradeLevel) {
        super(name);
        grade = gradeLevel;
    }

    //accessor
    public String toString() {
        String output = "Student " + super.toString() + " in in grade " + grade;
        return output;
    }

    //mutator
    public void promote() {
        grade++;
    }
}