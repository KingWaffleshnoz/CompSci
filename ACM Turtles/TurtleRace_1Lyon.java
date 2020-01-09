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
        int count1 = 0;
        int count2 = 0;
        int tiebreak = 0;
        boolean celebration = false;
        boolean done = false;
        boolean[] finished;
        int[] x;
        GTurtle[] turts;
        int[] victor;
  
        //set finish line
        setSize(1200, 1200);
        GRect r = new GRect(700, 50, 20, 1100);
        r.setColor(new Color(0, 0, 0));
        r.setFilled(true);
        r.setFillColor(new Color(0, 0, 0));
        add(r);
  
        //user interface
        String inputFromUser = JOptionPane.showInputDialog("Enter number (2-9):");
        int input = Integer.parseInt( inputFromUser );
        System.out.println("Racing " + input + " turtles..." );
        victor = new int[input];
        turts = new GTurtle[input];
        finished = new boolean[input];

        //add cuties
        for (int i = 0; i < input; i++) {
           turts[i] = new GTurtle(100, 100 + 50*i);
           add(turts[i]);
        }

        //race them
        while (!done) {
           for(int i = 0; i < input; i++) {
              if (turts[i].getX() < 720) {
                 turts[i].forward((int)(Math.random() * (50 - 10 + 1)) + 10);
              } else if (finished[i] == false) {
                if (tiebreak == 0) {
                    finished[i] = true;
                    tiebreak = 1;
                    count1++;
                }

                if (tiebreak == -1) {
                    finished[i] = true;
                    count1++;
                }

                if (tiebreak == 1) {
                    finished[i] = true;
                    victor[count2] = i;
                    count2++;
                }
              }
           }
           
           //tiebreaker
           if (tiebreak == 1 && count2 > 1) {
              System.out.println("Calculating a tiebreak...");
           }

           if (tiebreak == 1) {
              tiebreak = -1;
              System.out.println("Tiebreak resolved...");
           }

           if (count1 == input) {
              done = true;
              System.out.println("Ending race...");
              
              if (count2 == 1) {
                 System.out.println("Turtle " + victor[0] + " has finished first.");
              }
              
              if (count2 > 1) {
                 System.out.println("All tying turtles:\n");
                 for (int i = 0; i < count2; i++) {
                    System.out.print((victor[i] + 1) + " ");
                 }
              }
           }
        }

        //victory dance for winner
        for (int i = 0; i < count2; i++) {
         turts[victor[i]].setLocation(100, 100 + 50*i);
        }
        
        int timer = 0;
        while (timer < 24) {
            timer++;
            for (int i = 0; i < count2; i++) {
                turts[victor[i]].move(0, 100);
                turts[victor[i]].move(100, 0);
                turts[victor[i]].move(0, -100);
                turts[victor[i]].move(-100, 0);
            }
        }
     }
    public static void main(String[] args) {
        new TurtleRace_1Lyon().start(args);
    }
}