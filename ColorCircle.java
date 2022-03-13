import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class ColorCircle extends Circle {
 private Color color;
 private Random rand;
 // Constructor
 public ColorCircle(int x, int y, int r) {
 	super(x,y,r);
 	rand = new Random();
 	color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
 // creates a circle object and assigns a random color to color
 }

 //--------
 /** This method draws circles
 @param g brush for the drawing.
 */
 public void fill(Graphics g) {
 // draw and fill the circle with myColor
 	Graphics2D g2 = (Graphics2D) g;
 	Ellipse2D.Double c = new Ellipse2D.Double(getCentre().getX()-getRadius(),getCentre().getY()-getRadius(),2*getRadius(),2*getRadius());
	   g2.setColor(color);
	   g2.fill(c);
	   g2.draw(c);
 }

}
