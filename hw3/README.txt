AvlTree.java - This file contains a program called AvlTree.java. This program
is generic and can handle any type of input. In this case, it works with 
Problem2.java and it takes in a word at a time. The program makes a tree and
its nodes. It checks to see if the word on which the methods of the class is 
called on exists in the tree before adding it to the tree. If the word exists
on the tree, then the line number is added to the nodes linked list. The list
is verified before each add to for see the addition of the same line number.
It has various methods that are called within the Problem2.java program. To 
compile this program run command: javac AvlTree.java.

Problem2.java - This file contains a program called Problem2.java. It provides
the main method for AvlTree.java. It is a tester class. It takes in a command
line argument of a text file and reads the file line by line. It keeps a var
for the line number and calls the insert method in the class AvlTree.java
to insert words into an AVL tree. The method printTree is also called in this
program. The program outputs all the words in the file with the according line
numbers in which the words appear. To compile and run this program, enter
'javac Problem2.java' and 'java Problem 2' with a file as a command line 
argument.

