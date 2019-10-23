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
 * This program builds a racetrack for three turtles, the first of which to win will do a victory dance! 
 * Of course, there's some great commentary in the command lines :)
 */

 public class TurtleRun_1LyonJ extends GraphicsProgram {
    public void run() {
        setSize(1200, 500);
        GRect r = new GRect(700, 50, 20, 350);
        r.setColor(new Color(0, 0, 0));
        r.setFilled(true);
        r.setFillColor(new Color(0, 0, 0));
        add(r);
        
        GTurtle Barry = new GTurtle(100, 100);
        GTurtle Larry = new GTurtle(100, 225);
        GTurtle Harry = new GTurtle(100, 350);
        add(Barry);
        add(Larry);
        add(Harry);
        
        System.out.println("Our racers are as follows: Barry in lane one, Larry in lane two, and Harry in lane three!");
        System.out.println("As of last night, the Vegas odds heavily favored Barry, the previous Turtle Derby 500 champion, by a margin of +172!!");
        System.out.println("They're off! Barry out with a great opening, but the challengers are just pixels behind him...who will win?!");

        boolean hasReachedEdgeB = false;
        boolean hasReachedEdgeL = false;
        boolean hasReachedEdgeH = false;
        boolean bVictory = false;
        boolean lVictory = false;
        boolean hVictory = false;
        int i = 2;
        while (!hasReachedEdgeB || !hasReachedEdgeL || !hasReachedEdgeH) {
            Barry.pause(500);
            Larry.pause(500);
            Harry.pause(500);
            if (Barry.getX() < 720) {
                int x = (int)(Math.random() * (50 - 10 + 1)) + 10;
                Barry.move(i*x, 0);
            } else {
                hasReachedEdgeB = true;
                if (!hasReachedEdgeL && !hasReachedEdgeH) {
                    bVictory = true;
                }
            }
            if (Larry.getX() < 720) {
                int y = (int)(Math.random() * (50 - 10 + 1)) + 10;
                Larry.move(i*y, 0);
            } else {
                hasReachedEdgeL = true;
                if (!hasReachedEdgeB && !hasReachedEdgeH) {
                    lVictory = true;
                }
            }
            if (Harry.getX() < 720) {
                int z = (int)(Math.random() * (50 - 10 + 1)) + 10;
                Harry.move(i*z, 0);
            } else {
                hasReachedEdgeH = true;
                if (!hasReachedEdgeL && !hasReachedEdgeB) {
                    hVictory = true;
                }
            }
        }
        while (hasReachedEdgeB && hasReachedEdgeL && hasReachedEdgeH) {
            if (bVictory) {
                Barry.move(100, 0);
                Barry.move(0, -50);
                System.out.println("And Barry takes the win! He manages to hold onto his title for another year!");
                while (bVictory) {
                    Barry.move(0, 100);
                    Barry.move(100, 0);
                    Barry.move(0, -100);
                    Barry.move(-100, 0);
                }
            } else if (lVictory) {
                Larry.move(100, 0);
                Larry.move(0, -50);
                System.out.println("Larry with the upset! I tell ya, folks, we haven't seen something like this since the 1973 Winter Open!");
                while (lVictory) {
                    Larry.move(0, 100);
                    Larry.move(100, 0);
                    Larry.move(0, -100);
                    Larry.move(-100, 0);
                }
            } else if (hVictory) {
                Harry.move(100, 0);
                Harry.move(0, -50);
                System.out.println("The Idaho Rookie scrapes by with the victory! What an upset! No one could have seen this coming, not even Harry himself!");
                while (hVictory) {
                    Harry.move(0, 100);
                    Harry.move(100, 0);
                    Harry.move(0, -100);
                    Harry.move(-100, 0);
                }
            }
        }
    }
    public static void main(String[] args) {
        new TurtleRun_1LyonJ().start(args);
    }
}