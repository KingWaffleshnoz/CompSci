/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture ben = new Picture("ben.jpg");
    Picture smallBen = ben.scale(0.25,0.25);
    smallBen.explore();
    smallBen.zeroBlue();
    smallBen.explore();
  }

  /** test gray scale */
  public static void testGrayScale() {
    Picture ben = new Picture("ben.jpg");
    Picture smallBen = ben.scale(0.25,0.25);
    smallBen.explore();
    smallBen.makeGrayScale();
    smallBen.explore();
  }

  /** test fixUnderwater */
  public static void testUnderwater() {
    Picture fish = new Picture("water.jpg");
    fish.explore();
    fish.fixUnderwater();
    fish.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  /**test keep only blue */
  public static void testKeepOnlyBlue() {
    Picture d = new Picture("dieggo.jpg");
    Picture smallDieggo = d.scale(0.25,0.25);
    smallDieggo.explore();
    smallDieggo.keepOnlyBlue();
    smallDieggo.explore();
  }

/**test negate */
  public static void testNegate() {
    Picture d = new Picture("dieggo.jpg");
    Picture smallDieggo = d.scale(0.25,0.25);
    smallDieggo.explore();
    smallDieggo.negate();
    smallDieggo.explore();
  }

/** test mirror */
  public static void testMirrorHorizontal() {
    Picture c = new Picture("cat.jpg");
    c.explore();
    c.mirrorHorizontalBotToTop();
    c.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args) {
    testMirrorHorizontal();
  }
}