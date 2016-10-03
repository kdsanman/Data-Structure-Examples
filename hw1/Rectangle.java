/* 
 * Rectangle.java - A class that implements comparable, has three instance vars
 * and calculates perimeter. Has two accessor methods and has a compareTo
 * method that compares objects by perimeter
 */

public class Rectangle implements Comparable<Rectangle>
{
	private int length;
	private int width;
	private int perimeter;

	//constructor
	public Rectangle(int Length, int Width)
	{
		length = Length; 
		width = Width;
		perimeter = (2*width) + (2*length);
	}

	/* Get length method */
	public int getLength()
	{
		return length;
	}

	/* Get width method */
	public int getWidth()
	{
		return width;
	}
	
	public int compareTo(Rectangle other)
	{
		if(perimeter < other.perimeter)
			return -1;
		else if(perimeter > other.perimeter)
			return 1;
		else
			return 0;
	}
	
}
