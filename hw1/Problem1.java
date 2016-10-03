/* 
 * Problem1.java - This program makes an array of rectangle
 * objects and fills it in with some values. It then calls
 * a findMax method that returns the rectangle with the
 * largest parameter
 */
import java.util.ArrayList;

public class Problem1 {
		
	/* Main method */
    public static void main(String [] args)
    {
    		/* Creates an array of rectangle objects*/
            Rectangle [] rectangles = new Rectangle[4];
            
            /* Hardcoded rectangles */
            rectangles [0] = new Rectangle(3,2);
            rectangles [1] = new Rectangle (5,8);
            rectangles [2] = new Rectangle (10,11);
            rectangles [3] = new Rectangle (5,10);
            
            /*Calls the findMax and assigns return value to 
             * new rectangle*/
            Rectangle maxIndex = findMax(rectangles);
            
            /* Prints values of that rectangle*/
            System.out.println("Length: " + maxIndex.getLength() 
            + " Width: " + maxIndex.getWidth());
    }

    public static <AnyType extends Comparable<AnyType>> 
    AnyType findMax(AnyType[] arr)
    {
       int maxIndex = 0;
       for (int i = 1; i < arr.length; i++)
       {
    	   if ( arr[i].compareTo(arr[maxIndex]) > 0 )
    	   {
                maxIndex = i;
    	   }
       }
       return arr[maxIndex];
    }
}