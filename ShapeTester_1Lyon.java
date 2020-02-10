import java.awt.Color;

/**
 * Jared Lyon
 * Inherits-A3: In class lab
 * Extends a class shape into cool other stuff
 */
public class ShapeTester_1Lyon {
    public static void main(String[] args) {
        System.out.println("Making new shape:");
        Shape square = new Shape(1, 2);
        System.out.println("X: " + square.getX());
        System.out.println("Y: " + square.getY());

        Color b = new Color(255, 255, 255);
        System.out.println("Creating circle:");
        Circle circle = new Circle(2, 1, b, 6);
        System.out.println("X: " + circle.getX());
        System.out.println("Y: " + circle.getY());
        System.out.println("Area: " + circle.getArea());
    }   
}

class Shape {
    private int xLoc;
    private int yLoc;
    private Color color;


    public Shape( int xLocation, int yLocation ) {
    	xLoc = xLocation;
    	yLoc = yLocation;
    }
    public int getX() {return xLoc;}
    public int getY() {return yLoc;}
    /**
     2) Write an alternate constructor that takes the x, y location AND
     	a color object and initializes all instance variables.
    */
    public Shape( int xLocation, int yLocation, Color c) {
        xLoc = xLocation;
        yLoc = yLocation;
        c = color;
    }

    public double getArea() { return 0; }

} // end class Shape

/** 3) Write a class Circle that has an instance field for radius and
	   inherits the x,y and color from the Shape class. 
      (3b) Write a constructor for Circle that initializes all instance variables,
	   including location.
      (3c) Write a getArea method that returns the area of the circle

*/

class Circle extends Shape {
    private int radius;

    public Circle(int xL, int yL, int r) {
        super(xL, yL);
        radius = r;
    }

    public Circle(int xL, int yL, Color c, int r) {
        super(xL, yL, c);
        radius = r;
    }

    public double getArea() { 
        return Math.PI * radius * radius;    
    }
}





















/** 5) Create a public tester class: ShapeTester_Lastna
       Create a few objects, print out thier areas
*/