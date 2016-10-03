 
 FindPalindromes.java - This file contains a program called FindPalindromes.
 This program takes a command line argument, specifically a text file. If
 the text file provided is not found, it will throw a FileNotFound exception
 to the user. If the the file is found, it will convert every line of the
 file into a String and it will pass that string to a method that will then
 determine if the String is a palindrome. The method that is called is in the
 file MyStack.java. To compile and run this program enter commands: 'javac
 FindPalindromes.java' and 'java FindPalindromes' with the appropriate command
 line argument (text file) to process. This program is used with MyStack.java.
 Compile MyStack.java prior to using FindPalindromes; enter command: 'javac 
 MyStack.java'.
 
 MyStack.java - This file contains a program called MyStack. This program 
 contains a method called PalindromeChecker. This method is generic and 
 uses the length of the input (in this case a line) to determine how to 
 proceed with determining if the line is a palindrome or not. First, it
 processes the string and takes out all the spaces and non-characters. It
 also makes the line lower case. The length is then determined and the correct
 implementation of the loop is decided. The method uses stacks (as linked 
 lists) to compare character objects, when determining if the line is a 
 palindrome. It then prints the line if it's a palindrome and does nothing
 if the line is not a palindrome. This program is used with FindPalindromes.
 java. To run and compile this program enter commands: javac MyStack.java, 
 javac FindPalindromes.java, and java FindPalindromes (with the appropriate
 input file). 
 
 TwoStackQueue.java - This file contains a program called TwoStackQueue. This
 program creates two stacks using Linked Lists and implements unique enqueue
 and dequeue methods to work with the stacks. The enqueue method pushes data
 to the stack and the dequeue method pushes to stack 2 the pops from stack 1
 before returning the value. Prints out value to the screen. This program is
 used with tester class: Problem2.java. To compile this program enter commands:
 javac TwoStackQueue.java and javac Problem2.java. To run enter java Problem2.
  
 Problem2.java - This file contains a program called Problem2. This program
 creates a TwoStackQueue object, enqueues and dequeue some objects, and prints
 out the appropriate dequeued values. It's a tester class for 
 TwoStackQueue.java, which implements a queue using two stacks. To compile
 and run, enter commands: javac Problem2.java and java Problem2.
 
 Problem2.txt - This file explains the running time for the methods enqueue
 and dequeue implemented in TwoStackQueue.java.  