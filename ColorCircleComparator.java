import java.util.Comparator;

public class ColorCircleComparator implements Comparator <ColorCircle>{
	/** this is the abstract method of comparator
	@param c1 object 1 that is used to get desired result
	@param c2 object 2 that is used to get desired result
	*/
	public int compare(ColorCircle c1, ColorCircle c2){
		if(c1.getRadius()> c2.getRadius())
			return -1;
		if(c1.getRadius() < c2.getRadius())
			return 1;
		return 0;

	}
}