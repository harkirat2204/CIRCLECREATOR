import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.Collections;


public class DrawPanel extends JPanel{
 	private ArrayList<ColorCircle> circles;
 	/** Constructor
 	*/
 	public DrawPanel(){
 		circles = new ArrayList<ColorCircle>();
 	}/** Adds circles to the arraylist
 	@param randomRadius randomly generate dradius which is to be set as the radius of new circle
 	@param randomX randomly generated x cordinate for the center of the circle
 	@param randomY randomly generated y cordinate for the center of the circle
 	*/ 
 	public void create(int randomRadius,int randomX,int randomY) {
 		circles.add( new ColorCircle(randomX,randomY,randomRadius));
 		repaint();
	}
	/** Paint component that paints the panel
	*/
 	public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 for(ColorCircle c: circles)
		 	c.fill(g);
	}
	/** Sorts all the circles based on radius using comparator
	*/

	 public void sort() {
	 // sorts the objects
	 	if(circles.size()>0)
	 	Collections.sort(circles, new ColorCircleComparator());
	 		repaint();
	}
	/** Moves all the circles to center of the frame.
	*/

	public void movee() {
	 // moves the object
	 	for(ColorCircle c: circles)
	   	 	c.move(getWidth()/2,getHeight()/2);
	   	repaint();
	}/** Removes all the circles in the arraylist.
	*/
	public void reset() {
	 // resets the ArrayList
	 	 for(int i = circles.size()-1; i >=0;i--)
	   		circles.remove(i);
	   	repaint();
	}
}


