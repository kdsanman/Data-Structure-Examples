 ### FindPalindromes.java
 Task: Write a program that uses a stack to check for palindromes in each line of a text file. The main method should be in a class called FindPalindromes.java.The text file should be provided as a command line argument (remember String[] args from main). Your program should output the palindromes that it finds in the document. You must write your own MyStack class for this problem. It must be generic, in the sense that you should be able to use this stack with any type of object.  Don't use the built in Stack, instead build your stack from java.util.LinkedList.  Do not use the builtin push/pop methods from LinkedList. 
 
 This file contains a program called FindPalindromes.
 This program takes a command line argument, specifically a text file. If
 the text file provided is not found, it will throw a FileNotFound exception
 to the user. If the the file is found, it will convert every line of the
 file into a String and it will pass that string to a method that will then
 determine if the String is a palindrome. The method that is called is in the
 file MyStack.java. 
 To compile and run this program enter commands with the appropriate command
 line argument (text file) to process.
 ```
 javac FindPalindromes.java
 java FindPalindromes
 ```
 This program is used with MyStack.java.
 Compile MyStack.java prior to using FindPalindromes; enter command: 
 ```
 javac MyStack.java
 ```
 
 ### MyStack.java
 This file contains a program called MyStack. This program 
 contains a method called PalindromeChecker. This method is generic and 
 uses the length of the input (in this case a line) to determine how to 
 proceed with determining if the line is a palindrome or not. First, it
 processes the string and takes out all the spaces and non-characters. It
 also makes the line lower case. The length is then determined and the correct
 implementation of the loop is decided. The method uses stacks (as linked 
 lists) to compare character objects, when determining if the line is a 
 palindrome. It then prints the line if it's a palindrome and does nothing
 if the line is not a palindrome. This program is used with FindPalindromes.
 java. 
 To run and compile this program enter commands (with the appropriate inputfile.txt): 
 ```
 javac MyStack.java
 javac FindPalindromes.java
 java FindPalindromes inputfile.txt
 ```
 
 ### TwoStackQueue.java
 Task: Build a queue out of two completely separate stacks, S1 and S2. Enqueu operations happen by pushing the data on to stack 1.  Dequeue operations are completed with a pop from stack 2.
 
 This file contains a program called TwoStackQueue. This
 program creates two stacks using Linked Lists and implements unique enqueue
 and dequeue methods to work with the stacks. The enqueue method pushes data
 to the stack and the dequeue method pushes to stack 2 the pops from stack 1
 before returning the value. Prints out value to the screen. This program is
 used with tester class: Problem2.java. 
 To compile this program enter commands:
 ```
 javac TwoStackQueue.java
 javac Problem2.java
 ```
 To run enter:
 ```
 java Problem2
 ```
  
 ### Problem2.java (Tester class)
 This file contains a program called Problem2. This program
 creates a TwoStackQueue object, enqueues and dequeue some objects, and prints
 out the appropriate dequeued values. It's a tester class for 
 TwoStackQueue.java, which implements a queue using two stacks. 
 To compile and run, enter commands: 
 ```
 javac Problem2.java
 java Problem2
 ```
 
 ### Problem2.txt
 This file explains the running time for the methods enqueue
 and dequeue implemented in TwoStackQueue.java.  
