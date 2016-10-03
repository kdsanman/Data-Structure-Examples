TopSort.java - This file contains a program called TopSort. This program
takes in a command line argument of a text file. If an invalid text file is
used, it will throw a FileNotFoundException, and an error message. This
program's main method calls the constructor TopVert from TopVert.java.
To compile and run this program enter commands: javac TopSort.java, 
javac TopVert.java, java TopSort [text file].

TopVert.java - This file contains various methods starting with TopVert.
The constructor TopVert initializes all the instance variables that are used
throughout the algorithm. This constructor takes in a Scanner object. It then
reads each line and calls the method TopVertHandle on each line. The method
TopVertHandle takes in a String[] and an int referred to as indegree as 
arguments. Depending on the number of indegree, two separate algorithms are
performed on the input. This program uses a List of ArrayLists to store the
adjacency lists of each class id. After TopVertHandle does exactly what the 
name suggests (handle each input and sore it in memory), the method topsort()
is called inside the constructor TopVert. The method topsort() creates a queue
and implements the topological sorting algorithm suggested by Weiss on pg. 365.
It has been edited for the input and a counter has not been used because
good input is to be expected (no cycles). topsort() then runs its algorithm
of lowering the indegree of each vertex adjacent to the one being handled,
checks to see if the indegree is 0, and based on that decides to add it to
the queue or not. The purpose of the queue is to lower cost. To run and 
compile this program enter commands: javac TopVert.java javac TopSort.java
java TopSort [text file].

Dijkstra.java - This file contains a program called Dijkstra. This program
has various methods including: computeEuclideanDistance, computeAllEuclidean
Distances, doDijkstra, and getDijkstraPath. These were the only methods that
were edited for this assignment. The method computeAllEuclideanDistances 
calls the method computeEuclideanDistance which calculates the distance
between two cities using their x and y coordinates and the Euclidean
distance formula. The method getDijkstraPath calls doDijkstra which
then assigns every vertex object a distance and a previous field. The
distance assigned to each vertex is the smallest distance to get to that
vertex and the previous field is the vertex through which it is reached.
getDijkstraPath then creates the path using the starting city and the end
city, using the shortest path possible. It accesses the vertices previous
fields. To run and compile this program you need to compile Display.java,
Vertex.java, Edge.java, and Dijkstra.java. To do this enter commands:
javac Display.java, javac Vertex.java, javac Edge.java, javac Dijkstra.java.
To run this program enter command: java Display. This will pop up the GUI.
In this window, press the 'Compute all Euclidean Distances' button, then
select the start and end city and press the 'Draw Dijkstra's path' button.
Make sure the files in the boxes are cityxy.txt and citypairs.txt respectively.
Press the Load / Reset button to delete all the information visible on the map.


Vertex.java - Default file; was not edited.
Edge.java - Default file; was not edited.
Display.java - Default file; was not edited.
citypairs.java - Default file; was not edited.
cityxy.java - Default file; was not edited.
csmajor.txt - Default file; was not edited.
