import java.util.*;

public class Problem1 {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		System.out.print("Expression in postfix: ");
		String x = in.nextLine();
		
		//Call the constructor on x
		ExpressionTree.ExpressionTree(x);
	}
}
