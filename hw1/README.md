### Problem1.java
Task: Define a rectangle class that provides a getLength method and and a getWidth method.  Rectangle should also implement the Comparable class; it should compare by perimeter. Create another class called Problem1 that has the findMax routine (included below) and add a main method that creates an array of Rectangle objects and finds the largest Rectangle on the bases of its perimeter.

This file contains a program called Problem1. It creates an 
array of Rectangle objects and hardcodes some initial values to the array.
It then calls a findMax method that returns an index reference to the object
in the array of maximum perimeter. It therefore compares the objects on their
perimeter values.Then it prints out the length and width of the corresponding
object.  
To compile this program enter commands: 
```javac Problem1.java```
Make sure you have also previously compiled Rectangle.java by entering commands: 
```javac Rectangle.java```
To run this program simply compile and run the tester class:
```
javac Problem1.java
java Problem1
```

### Rectangle.java
This file contains a program called Rectangle. It has a 
constructor for Rectangle objects using initial values for length and width.
It then calculates the perimeter of the respective object and saves it, along
with its length and width. It implements Comparable and compares objects by
their perimeter values. It has two accessor methods: getWidth and getLength.

To compile this program enter command: 
```
javac Rectangle.java
```
It runs along with tester class Problem1.java.
Compile by entering command: 
```
javac Problem1.java
```
run entering command: 
```
java Problem1
```

### Problem2.java
Task: This method should then search the array recursively for the value x.  Create a main method that builds an array of rectangles (use your class from problem 1) and then sort that array with Arrays.sort.  Demonstrate your recursive binarySearch method on this array.

This file contains a program called Problem2. It implements
a binary search using recursion. The binarySearch method calls another
search method that implements recursion and the binary search algorithm
to find x. This search method compares objects by their perimeter. It
returns the index of the object in the array after it's been sorted if
the object is found. Else, it returns "Not found" to the user.

### Problem3.java
Task: Implement the three code fragments from written problem 3.  Have your code repeatedly run each fragment on various values of n.  Time each run and see if the progression of timings as n increases matches the predicted run times from your written assignment.  Place the results of your timing and your explanation in a file called Problem3.txt.  For the third fragment, set k equal to 2 for all of your testing


This file contains a program called Problem3.java. It has 3
distinct methods that are called repeatedly with varying inputs. It calculates
and prints the time that each individual method run takes. I used nanoTime
in this program to calculate start time and end time. This approx. data 
is in the Problem3.txt file. Each trial produces a different but somewhat 
precise result.

### Problem3.text
This file contains the results of the times obtained for the
running of the code fragments that appeared in the written problem 3. It also
includes an explanation for the times obtained. Values for n may vary.
