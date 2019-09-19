//Jared Lyon, Intro-A5 Turtles

import acm.program.GraphicsProgram;
//import graphics window
import acm.graphics.GTurtle;
//import GTurtle
import java.awt.Color;
//import Java color class for pens

/**
   *Jared Lyon
   *Period 1
   *Intro-A5 Turtles
   *This program draws my initials in block letters then draws a quick outline using the acm GTurtle add on
**/
public class Turtle_1Lyon extends GraphicsProgram {
   public static void main(String[] args) {
      new Turtle_1Lyon().start(args);
   }
   
   public void run() {
      //spawns turtles
      GTurtle Barry = new GTurtle(350, 100);
      GTurtle Larry = new GTurtle(400, 100);
      GTurtle Harry = new GTurtle(225, 75);
      
      //set speed for turtles
      Barry.setSpeed(0.25);
      Larry.setSpeed(0.25);
      Harry.setSpeed(0.5);
      
      //add turtles
      add(Barry);
      add(Larry);
      add(Harry);
      
      //define pen colors
      Color pen1 = new Color(138, 43, 226);
      Barry.setColor(pen1);
      Color pen2 = new Color(0, 250, 154);
      Larry.setColor(pen2);
      Color pen3 = new Color(64, 224, 208);
      Harry.setColor(pen3);
            
      //pens down
      Barry.penDown();
      Larry.penDown();
      Harry.penDown();
      
      //draw sequence for initials
      Barry.move(0, 200);
      Larry.move(0, 200);
      Barry.move(-100, 0);
      Larry.move(100, 0);
      Barry.move(0, -75);
      Larry.move(0, -25);
      Barry.move(25, 0);
      Larry.move(-75, 0);
      Barry.move(0, 50);
      Larry.move(0, -175);
      Barry.move(50, 0);
      Larry.move(-25, 0);
      Barry.move(0, -175);
      Barry.move(25, 0);
      
      //box outline
      Harry.move(300, 0);
      Harry.move(0, 250);
      Harry.move(-300, 0);
      Harry.move(0, -250);
      
      //remove turtles from frame   
      Barry.hideTurtle();
      Larry.hideTurtle();
      Harry.hideTurtle();
   }
}