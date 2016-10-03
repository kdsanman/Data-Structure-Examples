/* 
 * Homework 2
 * Problem2.java - Tester class for TwoStackQueue, calls methods enqueue
 * and dequeue */

public class Problem2 {

	public static void main(String[] args) 
	{
		TwoStackQueue a = new TwoStackQueue();
		
		/* Enqueue some objects */
		a.enqueue("2:50AM");
		a.enqueue("Cesar");
		a.enqueue("Kim");
		
		/* Dequeue some objects */
		a.dequeue();
		a.dequeue();
		
		a.enqueue("It workssssss");
		a.enqueue("Uh la la");
		a.dequeue();
		a.dequeue();
		
	}

}
