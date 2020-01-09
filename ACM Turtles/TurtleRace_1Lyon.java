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
        boolean[] done;
        GTurtle[] turts;
        int[] victory;
        boolean finished;
        int champ = 0;
        String winner;

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
        
        victory = new int[input];
        turts = new GTurtle[input];
        done = new boolean[input];
        for (int i = 0; i < input; i++) {
            turts[i] = new GTurtle(100, 100 + 125 * i);
            add(turts[i]);
        }

        while (!finished) {
            for (int i = 0; i < input; i++) {
                if (turts[i].getX() < done) {
                   turts[i].forward((int)(Math.random() * (75 - 10 + 1)) + 10);
                } else if (done[i] == false) {
                    done[i] = true;
                    champ++;
                    if (champ == 1) {
                        winner = turts[i];
                    }
                }
            }

            if (turts[] == done[]) {
                finished = true;
            }
        }

        while (finished) {
            winner.move(0, 100);
            winner.move(100, 0);
            winner.move(0, -100);
            winner.move(-100, 0);
        }
    }
    public static void main(String[] args) {
        new TurtleRace_1Lyon().start(args);
    }
}