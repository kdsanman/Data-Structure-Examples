/* 
 * Homework 2
 * MyStack.java - contains a method PalindromChecker that checks any line 
 * to see if it's a palindrome*/
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collection;

public class MyStack <AnyType> {
	// do not use built-in push/pop methods from LinkedList
	//don't use the built in stack
	//build own stack
	
	public static <AnyType> void PalindromeChecker(AnyType checking)
	{
		LinkedList<AnyType> list1 = new LinkedList<AnyType> ();
		list1.add(checking);
				
		AnyType line1 = list1.removeFirst();
		String line2 = ((String) line1).replaceAll("[^A-Za-z]+","")
				.toLowerCase();
		
		int middle = 0;
		// if the line length is even
		if (line2.length() % 2 == 0)
		{
			middle = line2.length()/2;
			LinkedList<AnyType> list2 = new LinkedList<AnyType>();
			
			for (int i = 0; i < line2.length(); i++)
			{
				char ch = line2.charAt(i);
				String PretoAdd = Character.toString(ch);
				AnyType toAdd = (AnyType) PretoAdd;
				list2.addLast(toAdd);
			}
			
			boolean isNOTPalindrome = false;
			
			LinkedList<AnyType> stack = new LinkedList<AnyType>();

			//lets add to a the stack
			if (list2.size() > 0)
			{
				for(int k = 0; k < middle; k++){
				
					AnyType addToStack = list2.removeFirst();
					stack.addFirst(addToStack);
				}
			}
				
			//checking characters to see if palindrome			
			while (list2.size() > 0 && stack.size() > 0 && !isNOTPalindrome)
			{
				
				if (stack.removeFirst().equals(list2.removeFirst()))
				{
					isNOTPalindrome = false;
				}
				else 
					isNOTPalindrome = true;
					break;
			}
			
			if (!isNOTPalindrome)
			{
				System.out.println("'" + checking+ "' is a Palindrome");
			}
			else
				return;
		}
		
		// if the line length is odd
		else if (line2.length() % 2 == 1)
		{
			middle = line2.length()/2 +1;
			
			
			LinkedList<AnyType> list2 = new LinkedList<AnyType>();
			
			for (int i = 0; i < line2.length(); i++)
			{
				char ch = line2.charAt(i);
				String PretoAdd = Character.toString(ch);
				AnyType toAdd = (AnyType) PretoAdd;
				list2.addLast(toAdd);
			}
			
			/* check boolean to decide what to print
			 gets changed to true if it's NOT a palindrome */
			boolean isNOTPalindrome = false;
			
			LinkedList<AnyType> stack = new LinkedList<AnyType>();

//			//lets add to a the stack
			if (list2.size() > 0)
			{
				for(int k = 0; k < middle -1; k++){
				
					AnyType addToStack = list2.removeFirst();
					stack.addFirst(addToStack);
				}
				//removes middle character
				list2.removeFirst();
			}
//				
//			//checking characters to see if palindrome			
			while (list2.size() > 0 && stack.size() > 0 && !isNOTPalindrome)
			{
				if (stack.removeFirst().equals(list2.removeFirst()))
				{
					isNOTPalindrome = false;
				}
				else 
					isNOTPalindrome = true;
					break;
			}
			
			if (!isNOTPalindrome)
			{
				System.out.println("'" + checking+ "' is a Palindrome");
			}
			else
				return;
		}
	}
}
