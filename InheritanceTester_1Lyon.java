public class InheritanceTester_1Lyon {
    public static void main(String[] args) {
        Student guy1 = new Student();
        System.out.println(guy1);

        Student guy2 = new Student("Cart McBenjamin", 12);
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

    public Student() {
        super("Benjamin McCarty");
    }

    public Student(String name, int gradeLevel) {
        super(name);
        grade = gradeLevel;
    }

    public String toString() {
        String output = "Student " + super.toString() + " in in grade " + grade;
        return output;
    }
}