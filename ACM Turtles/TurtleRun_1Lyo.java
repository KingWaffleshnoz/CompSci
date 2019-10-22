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

/**
 * Jared Lyon
 * Period 1
 * LoopsA1: Turtle Run (ACM)
 * This program builds a racetrack for three turtles
 */

 public class TurtleRun_1Lyo extends GraphicsProgram {
    public void run() {
        setSize(1200, 1200);
        GRect r = new GRect(20, 30, 20, 30);
        r.setColor(new Color(255, 128, 33));
        r.setFilled(true);
        r.setFillColor(new Color(54, 33, 229));
        add(r);

        boolean hasNotReachedEdge = true;
        int j = 2;
        while(hasNotReachedEdge) {
            r.move(j*4, j*2);
            if (r.getX() > 800 || r.getY() > 800) {
                hasNotReachedEdge = false;
            }
            pause(100);
        }
        /*
        for (int i = 0; i < 20; i++) {
            r.move(i*4, i*2);
            pause(100);
        }
        */
    }
    public static void main(String[] args) {
        new TurtleRun_1Lyo().start(args);
    }
}