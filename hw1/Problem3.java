/* 
 * Problem3.java - Calculates run time for different loops
 * and prints it out
 */

public class Problem3 
{
	public static void main(String [] args) 
	{
		
		System.out.println("First fragment");
		
		System.out.println();
		System.out.println("N is 1");
		int starTime = (int) System.nanoTime(); //make not in README
		firstfrag(1);
		int endTime = (int) System.nanoTime();
		int totalTimeElapsed = endTime - starTime;
		System.out.println("Time elapsed: " + totalTimeElapsed);
		
		System.out.println("N is 2");
		starTime = (int) System.nanoTime(); //make not in README
		firstfrag(2);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 4");
		starTime = (int) System.nanoTime(); //make not in README
		firstfrag(4);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 16");
		starTime = (int) System.nanoTime(); //make not in README
		firstfrag(16);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 32");
		starTime = (int) System.nanoTime(); //make not in README
		firstfrag(32);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 100");
		starTime = (int) System.nanoTime(); //make not in README
		firstfrag(100);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.println("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("Second fragment");
		System.out.println();
		System.out.println("N is 1");
		starTime = (int) System.nanoTime(); //make not in README
		secondfrag(1);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 2");
		starTime = (int) System.nanoTime(); //make not in README
		secondfrag(2);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 4");
		starTime = (int) System.nanoTime(); //make not in README
		secondfrag(4);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 8");
		starTime = (int) System.nanoTime(); //make not in README
		secondfrag(8);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 16");
		starTime = (int) System.nanoTime(); //make not in README
		secondfrag(16);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 32");
		starTime = (int) System.nanoTime(); //make not in README
		secondfrag(32);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.println("Time elapsed: " + totalTimeElapsed);
		
		System.out.println("Third fragment");
		
		System.out.println();
		System.out.println("N is 1");
		starTime = (int) System.nanoTime(); //make not in README
		foo(1,2);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);

		System.out.println();
		System.out.println("N is 2");
		starTime = (int) System.nanoTime(); //make not in README
		foo(2,2);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 4");
		starTime = (int) System.nanoTime(); //make not in README
		foo(4,2);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 16");
		starTime = (int) System.nanoTime(); //make not in README
		foo(16,2);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
		
		System.out.println();
		System.out.println("N is 32");
		starTime = (int) System.nanoTime(); //make not in README
		foo(32,2);
		endTime = (int) System.nanoTime();
		totalTimeElapsed = endTime - starTime;
		System.out.print("Time elapsed: " + totalTimeElapsed);
	}
	
	public static void firstfrag (int n)
	{
		int sum = 0;
		for (int i = 0; i < 23; i++){
			for (int j = 0; j < n; j++){
				sum = sum + 1;
			}
		}
	}
	public static void secondfrag (int n)
	{
		int sum = 0;
		for (int i = 0; i < n ; i++){
			for (int k = i; k < n; k++){
				sum = sum + 1;
			}
		}
	}
	public static int foo (int n, int k)
	{
		if (n <= k)
			return 1;
		else
			return foo(n/k, k) + 1;
	}
}
