import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

/* 
 * Homework 5
 * TopSort.java - A program that implements topological sorting
 * to find a sequence of courses for the CS major that satisfies
 * all prerequisite requirements, takes in a command line argument
 */
public class TopSort {
	public static void main(String [ ] args )
    {    	
    	//take command argument text file
    	File inputFile = new File(args[0]);
		try 
		{
			Scanner textFile = new Scanner(inputFile);
			
			new TopVert(textFile);
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Input file was not found.");
		}
    }
}
