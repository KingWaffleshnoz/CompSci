/**
 * @author Jared Lyon
 * Inherits-A5: Book Pgm - E9.12 from Big Java
 * Makes a class Employee with a name and salary and then makes a class Manager inherit from Employee with String department. Then makes a class Executive inherit from Manager.
 */
public class ManagerInheritanceTester_1Lyon {
    public static void main(String[] args) {
        Employee jack = new Employee("Jack", 42500);
        System.out.println(jack.toString());
        Manager jill = new Manager("Jill" , 83000, "Human Resources");
        System.out.println(jill.toString());
        Manager hill = new Executive("Jonah", 166000, "Mission Success");
        System.out.println(hill.toString());
    }
}

class Employee {
    private String name;
    private int salary;
    
    //constructor
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    //accessors
    public String toString() {
        return "Employee " + name + " has a salary of $" + salary + ".";
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    private String department;

    //constructor
    public Manager(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }

    //accessors
    public String toString() {
        return "Manager " + super.getName() + " from the " + department + " department has a salary of $" + super.getSalary() + ".";
    }

    public String getName() {
        return super.getName();
    }

    public int getSalary() {
        return super.getSalary();
    }

    public String getDepartment() {
        return department;
    }
}

class Executive extends Manager {
    //E9.12 doesnt say to add anything to this class...?
    
    //constructor
    public Executive(String name, int salary, String department) {
        super(name, salary, department);
    }

    //accessor
    public String toString() {
        return "Executive " + super.getName() + " from the " + super.getDepartment() + " department has a salary of $" + super.getSalary() + ".";
    }
}