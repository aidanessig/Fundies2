import tester.*;
import javalib.worldimages.*;
import javalib.worldcanvas.WorldCanvas;
import javalib.funworld.*;
import java.awt.Color;

interface ITree {
  // the draw function
  WorldImage draw();

  // determines if any branches are drooping
  boolean isDrooping();

  // combines two trees
  ITree combine(int leftLength, int rightLength, double leftTheta, double rightTheta,
      ITree otherTree);

  // helper function for the combine method that adjusts trees
  ITree modifyBranch(double theta);

  // method to find total width of a tree
  double getWidth();

  // method to find width of left tree
  double getLeftWidth();

  // method to find width of right tree
  double getRightWidth();

  // method to find the base length of a branch
  double computeBase();
}

class Leaf implements ITree {
  int size; // represents the radius of the leaf
  Color color; // the color to draw it

  Leaf(int size, Color color) {
    this.size = size;
    this.color = color;
  }
  
  /* TEMPLATE:
   * Fields:
   * ... this.size ... -- integer
   * ... this.color ... -- color
   * 
   * Methods:
   * ... this.draw() ... -- WorldImage
   * ... this.isDrooping() ... -- boolean
   * 
   * Methods for Fields:
   * 
   */
  
  // returns a circle representing a leaf in a tree
  public WorldImage draw() {
    WorldImage result = new VisiblePinholeImage(
        new CircleImage(this.size, OutlineMode.SOLID, this.color));

    return result;
  }

  // determines any angles are drooping
  public boolean isDrooping() {
    return false;
  }

  // combines two ITrees
  public ITree combine(int leftLength, int rightLength, double leftTheta, double rightTheta,
      ITree otherTree) {
    return this;
  }
  
  //helper function for the combine method that adjusts trees
  public ITree modifyBranch(double theta) {
    return this;
  }

  // method to find total width of a tree
  public double getWidth() {
    return this.getRightWidth() - this.getLeftWidth();
  }

  // method to find width of left tree
  public double getLeftWidth() {
    return -(double) Math.abs(size);
  }

  // method to find width of right tree
  public double getRightWidth() {
    return (double) Math.abs(size);
  }
  
  // finds the width of a base of two stems
  public double computeBase() {
    return 0;
  }
}

class Stem implements ITree {

  int length; // how long this stick is
  double theta; // the angle (in degrees) of this stem, relative to the +x axis
  ITree tree; // the rest of the tree

  Stem(int length, double theta, ITree tree) {
    this.length = length;
    this.theta = theta;
    this.tree = tree;
  }
  
  /* TEMPLATE:
   * Fields:
   * ... this.length ... -- integer
   * ... this.theta ... -- double
   * ... this.tree ... -- ITree
   * 
   * Methods:
   * ... this.draw() ... -- WorldImage
   * ... this.isDrooping() ... -- boolean
   * 
   * Methods for Fields:
   * ... this.tree.draw() ... -- WorldImage
   * ... this.tree.isDrooping() ... -- boolean
   */
  
  // draw function to display trees
  public WorldImage draw() {

    int x = (int) (length * Math.cos(Math.toRadians(theta)));
    int y = (int) (length * Math.sin(Math.toRadians(-theta)));

    WorldImage result = new VisiblePinholeImage(
        new LineImage(new Posn(x, y), Color.BLACK).movePinhole(.5 * x, .5 * y));
    return new OverlayImage(tree.draw(), result);
  }

  // determines if any two angles are drooping
  public boolean isDrooping() {
    if (theta > 180 && theta < 360) {
      return true;
    }
    else {
      return this.tree.isDrooping();
    }
  }

  // combines two ITrees
  public ITree combine(int leftLength, int rightLength, double leftTheta, double rightTheta,
      ITree otherTree) {
    return this;
  }
  
  //helper function for the combine method that adjusts trees
  public ITree modifyBranch(double theta) {
    return new Stem(this.length, this.theta - theta, this.tree);
  }

  // method to find total width of a tree
  public double getWidth() {
    return Math.abs(Math.max(this.getRightWidth() - this.getLeftWidth(), this.tree.getWidth()));
  }

  // method to find width of left tree
  public double getLeftWidth() {
    if (this.theta > 90) {
      return this.computeBase() + tree.getLeftWidth();
    }
    else {
      return 0.0;
    }
  }

  // method to find width of right tree
  public double getRightWidth() {
    if (this.theta < 90) {
      return this.computeBase() + tree.getRightWidth();
    }
    else {
      return 0.0;
    }
  }

  // method to find the base
  public double computeBase() {
    return this.length * Math.cos(Math.toRadians(this.theta));
  }
}

class Branch implements ITree {
  // how long the left and right branches are
  int leftLength;
  int rightLength;
  // the angle (in degrees) of the two branches, relative to the +x axis,
  double leftTheta;
  double rightTheta;
  // the remaining parts of the tree
  ITree left;
  ITree right;

  Branch(int leftLength, int rightLength, double leftTheta, double rightTheta, ITree left,
      ITree right) {
    this.leftLength = leftLength;
    this.rightLength = rightLength;
    this.leftTheta = leftTheta;
    this.rightTheta = rightTheta;
    this.left = left;
    this.right = right;
  }
  
  /* TEMPLATE:
   * Fields:
   * ... this.leftLength ... -- integer
   * ... this.rightLength ... -- integer
   * ... this.leftTheta ... -- double
   * ... this.rightTheta ... -- double
   * ... this.left ... -- ITree
   * ... this.right ... -- ITree
   * 
   * Methods:
   * ... this.draw() ... -- WorldImage
   * ... this.isDrooping() ... -- boolean
   * 
   * Methods for Fields:
   * ... this.left.draw() ... -- WorldImage
   * ... this.right.draw() ... -- WorldImage
   * ... this.left.isDrooping() ... -- boolean
   * ... this.right.isDrooping() ... -- boolean
   */
  
  // draws a ITree
  public WorldImage draw() {
    int leftX = (int) (leftLength * Math.cos(Math.toRadians(leftTheta)));
    int leftY = (int) (leftLength * Math.sin(Math.toRadians(-leftTheta)));
    int rightX = (int) (rightLength * Math.cos(Math.toRadians(rightTheta)));
    int rightY = (int) (rightLength * Math.sin(Math.toRadians(-rightTheta)));

    ITree stemLeft = new Stem(leftLength, leftTheta, left);
    ITree stemRight = new Stem(rightLength, rightTheta, right);

    WorldImage leftGood = stemLeft.draw().movePinhole(-leftX, -leftY);
    WorldImage rightGood = stemRight.draw().movePinhole(-rightX, -rightY);

    return (new OverlayImage(leftGood, rightGood));
  }

  // determines if any angles are drooping
  public boolean isDrooping() {
    if (leftTheta > 180 && leftTheta < 360 || rightTheta > 180 && rightTheta < 360
        || rightTheta < 0) {
      return true;
    }
    else {
      return this.left.isDrooping() || this.right.isDrooping();
    }
  }

  // combines two ITrees
  public ITree combine(int leftLength, int rightLength, double leftTheta, double rightTheta,
      ITree otherTree) {

    ITree newLeft = this.modifyBranch(leftTheta);
    ITree newRight = otherTree.modifyBranch(rightTheta);

    return new Branch(leftLength, rightLength, leftTheta, rightTheta, newLeft, newRight);
  }
  
  //helper function for the combine method that adjusts trees
  public ITree modifyBranch(double theta) {
    return new Branch(this.leftLength, this.rightLength, leftTheta - 2 * theta,
        rightTheta - 2 * theta, this.left.modifyBranch(theta), this.right.modifyBranch(theta));
  }

  // method to find total width of a tree
  public double getWidth() {
    return this.computeBase() + Math.abs(this.left.getLeftWidth()) + this.right.getRightWidth();
  }

  // method to find width of left tree
  public double getLeftWidth() {
    ITree stemLeft = new Stem(this.leftLength, this.leftTheta, this.left);

    return stemLeft.getLeftWidth();
  }

  // method to find width of right tree 
  public double getRightWidth() {

    ITree stemRight = new Stem(this.rightLength, this.rightTheta, this.right);

    return stemRight.getRightWidth();
  }

  // method to find the base
  public double computeBase() {
    return (this.rightLength * Math.cos(Math.toRadians(this.rightTheta)))
        + Math.abs(this.leftLength * Math.cos(Math.toRadians(this.leftTheta)));
  }

}

class ExamplesTree {
  ITree leaf1 = new Leaf(20, Color.blue);
  ITree leaf2 = new Leaf(20, Color.red);
  ITree branch1 = new Branch(60, 60, 160, 35, leaf1, leaf2);

  ITree tree1 = new Branch(30, 30, 135, 40, new Leaf(10, Color.RED), new Leaf(15, Color.BLUE));

  ITree tree2 = new Branch(30, 30, 140, 65, new Leaf(15, Color.GREEN), new Leaf(8, Color.ORANGE));

  ITree tree3 = new Branch(30, 30, 135, -40, leaf1, leaf2);

  ITree branch2 = new Branch(40, 50, 150, 30, tree1, tree2);
  ITree stem1 = new Stem(80, 110, leaf1);

  // tests the Draw function
  boolean testDraw(Tester t) {
    WorldCanvas c = new WorldCanvas(500, 500);
    WorldScene s = new WorldScene(500, 500);

    return c.drawScene(s.placeImageXY(new Branch(40, 50, 150, 30, tree1, tree2).draw(),
        250, 250)) && c.show();
  }

  // tests the isDrooping function
  boolean testIsDrooping(Tester t) {
    return t.checkExpect(tree1.isDrooping(), false) 
        && t.checkExpect(tree2.isDrooping(), false)
        && t.checkExpect(tree3.isDrooping(), true);
  }

  // tests the getWidth function
  boolean testGetWidth(Tester t) {
    return t.checkInexact(branch2.getWidth(), 129.834, .001);
  }
}