import java.util.*;
import java.util.LinkedList;

public class MyStack <AnyType> {
	
	private AnyType leftChild;
	private AnyType rightChild;
	private AnyType element;

	public <AnyType> AnyType build(AnyType x)
	{
		Scanner input = new Scanner((Readable) x);
		Stack<AnyType> stack = new Stack<>();

		while (input.hasNext()){
			AnyType checking = (AnyType) input.next();
			if (checking.equals("/") || checking.equals("*") || 
					checking.equals("+") || checking.equals("-"))
			{
				if (stack.size() > 0)
				{
					leftChild = stack.pop();
					rightChild = stack.pop();
				}
				//call method that makes a new tree with children as arguments
				//add new tree to stack
			}
			else {
				NumStack.addLast(checking);
			}
		}
	}
}