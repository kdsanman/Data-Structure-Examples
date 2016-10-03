/* 
 * Homework 2
 * TwoStackQueue.java - methods enqueue and dequeue, uses push and pop,
 * builds a queue out of two stacks*/

import java.util.*;

public class TwoStackQueue <AnyType>
{
	
	private LinkedList<AnyType> stack1;
	private LinkedList<AnyType> stack2;
	
	public TwoStackQueue() {
	/* Creates stacks S1 and S2*/
		stack1 = new LinkedList<AnyType>();
		stack2 = new LinkedList<AnyType>();
	}
	
	/* enqueue method - push to S1*/
	public void enqueue(AnyType x)
	{
		stack1.push(x);
	}
	
	/* dequeue method - pop S2*/
	public <AnyType> void dequeue()
	{
		if (stack2.size() > 0){
			System.out.println(stack2.pop());
		}
		else {
			if (stack1.size() >0 )
			{
				while (stack1.size() >0)
				{
					stack2.push(stack1.pop());
				}
				System.out.println(stack2.pop());
			}
			else
				return;
		}
		
	}
}