/* 
 * Problem2.java - this programs calls a binary search method
 * that calls another binary search method that recursively 
 * searches for an object in an array and compares objects 
 * by their perimeter
 */
import java.util.Arrays;
import java.util.Collections;

public class Problem2 
{
	public static <AnyType extends Comparable<AnyType>> 
	int binarySearch(AnyType [] a, AnyType x)
	{
		/* call another method that can be more useful*/
		return search(a, 0, a.length, x);
	}
	
	private static <AnyType extends Comparable<AnyType>> 
	int search(AnyType[] arr, int low, int high, AnyType x)
	{	
		if (low > high)
			return -1;
		
		int mid = (low + high) / 2;
		
		if (arr[mid]==x)
			return mid;
 
		if (arr[mid].compareTo(x) < 0)
			return search(arr, mid+1, high, x);
		else if (arr[mid].compareTo(x) > 0)
			return search(arr, low, mid-1, x);
		else
			return mid;
		
		
//		return (Integer) null;
	}
	
	 /*Main method that builds an array of rectangles */
	 public static void main(String [] args)
	 {
		/* Creates an array of rectangle objects*/
        Rectangle [] rectangles = new Rectangle[4];
        
        /* Hardcoded rectangles */
        rectangles [0] = new Rectangle(3,2);
        rectangles [1] = new Rectangle (5,8);
        rectangles [2] = new Rectangle (10,11);
        rectangles [3] = new Rectangle (5,10);
        
       /* Sort array*/
        Arrays.sort(rectangles);
        
        /* Call binarySearch method and make the return the int index*/
        int index = binarySearch(rectangles, new Rectangle(10,11));
        
        if (index == -1){
        	System.out.println("Not found");
        	return;
        }
        
        System.out.println("Found rectangle at position " + index);
	  }
}
