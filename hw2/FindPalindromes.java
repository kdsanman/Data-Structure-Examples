/*
 * Homework 2
 * FindPalindromes.java - takes a file as command line argument and calls
 * the method PalindromeChecker from MyStack.java on each line of the file */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FindPalindromes {

	@SuppressWarnings("unchecked")
	public static <AnyType> void main(String[] args) {
		
		//read command line file input
		File inputFile = new File(args[0]);
		try 
		{
			Scanner textFile = new Scanner(inputFile);
			
			while (textFile.hasNextLine())
			{
				String checking = textFile.nextLine();
				MyStack.PalindromeChecker(checking);
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Input file was not found.");
		}
		 
	}
}
