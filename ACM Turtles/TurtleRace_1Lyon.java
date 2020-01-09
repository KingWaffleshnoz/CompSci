//Jared Lyon, LoopsA1: Turtle Run (ACM)

import acm.program.GraphicsProgram;
//import graphics window - make sure to add the classpath
import acm.graphics.GTurtle;
//import GTurtle
import acm.graphics.GRect;
//import rectangle stuff
import java.awt.Color;
//import Java color class for pens
import java.util.Random;
//need random for turtle movement
import javax.swing.JOptionPane;
//import window thingie

/**
 * Jared Lyon
 * Period 1
 * Arrays-A1: Turtle Racing
 * This program builds a racetrack for three turtles, the first of which to win will do a victory dance! 
 * Of course, there's some great commentary in the command lines :)
 */

 public class TurtleRace_1Lyon extends GraphicsProgram {
    public void run() {
        setSize(1200, 1200);
        GRect r = new GRect(700, 50, 20, 350);
        r.setColor(new Color(0, 0, 0));
        r.setFilled(true);
        r.setFillColor(new Color(0, 0, 0));
        add(r);

        String inputFromUser = JOptionPane.showInputDialog("Enter number (2-9):");
        int input = Integer.parseInt( inputFromUser );
        if (input > 9 || input < 2) {
            System.out.println("Out of range!");
            return;
        } else {
            System.out.println("Creating " + input + " turtles...");
        }
        
        for (int i = 0; i <= input; i++) {
            GTurtle i = new GTurtle(100, 100 + 125*i);
            add(i);
        }

        boolean finished = false;
        int check = 0;
        int victory = 0;
        while (!finished) {
            for (int i = 0; i <= input; i++) {
                if (i.getX() < 720) {
                    int x = (int)(Math.random() * (50 - 10 + 1)) + 10;
                    i.move(2*x, 0);
                } else {
                    check++;
                    if (check == 0) {
                        victory = i;
                    } else if (check == 9) {
                        finished = true;
                    }
                }
            }
        }

        while (finished) {
            victory.move(0, 100);
            victory.move(100, 0);
            victory.move(0, -100);
            victory.move(-100, 0);
        }
    }
    public static void main(String[] args) {
        new TurtleRace_1Lyon().start(args);
    }
}