import java.util.*;
import javax.xml.soap.Node;

public class ExpressionTree {

	private Node root;
	
	//constructor
	public ExpressionTree(String x){
		//run stack based algorithm, build an expression tree
		MyStack.build(x);
	}
	
	public class ExpressionNodes {
		
	}
	
	//Return integer associated with evaluating the expression tree
	//calls a private recursive method that takes in the root
	public int eval(ExpressionNodes object){
		
	}
	
	//return a String that contains the postfix expression
	//calls a private recursive method that takes in the root
	public String postfix(){
		StringBuilder sb = new StringBuilder();
		postfix(root, sb);
		return sb.toString().trim();
	}
	
	private void postfix(Node node, StringBuilder sb){
		if (node.left != null){
			postfix(node.left, sb);
		}
		
		if (node.right != null){
			postfix(node.right, sb);
		}
		
		sb.append(node);
		sb.append(" ");
	}
	
	//will return a String that contains prefix expression
	//calls a private recursive method that takes in the root
	public String prefix(){
		StringBuilder sb = new StringBuilder();
		prefix(root, sb);
		return sb.toString().trim();
	}
	
	private void prefix(Node node, StringBuilder sb)
	{
		sb.append(node);
		//add a space in between nodes for clarity
		sb.append(" ");
		
		if (node.left != null){
			prefix(node.left, sb);
		}
		
		if (node.right != null){
			prefix(node.right, sb);
		}
	}
	
	//return a String that contains the corresponding correct infix expression
	// parenthesis will be needed, excessive is tolerated.. 
	//calls a private recursive method that takes in the root
	public String infix(){
		StringBuilder sb = new StringBuilder();
		infix (root, sb);
		return sb.toString().trim();
	}
	
	private void infix(Node node, StringBuilder sb){
		if (node.left != null){
			infix(node.left, sb);
		}
		
		sb.append(node);
		sb.append(" ");
		
		if (node.right != null){
			infix(node.right, sb);
		}
	}
}
