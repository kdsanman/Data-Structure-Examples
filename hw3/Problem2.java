import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Problem2 {
	 
	public static void main(String [ ] args )
    {
    	AvlTree<String> t = new AvlTree<>( );
    	
    	//take command argument text file
    	File inputFile = new File(args[0]);
		try 
		{
			Scanner textFile = new Scanner(inputFile);
			
			int line_number = 1;
			while (textFile.hasNextLine())
			{
				String line = textFile.nextLine();
				line = line.replaceAll("\\p{P}", "");
				line = line.toLowerCase();
				
				Scanner checkLine = new Scanner(line);
				
				while (checkLine.hasNext()){
					String check = checkLine.next();
					t.insert(check, line_number);
				}
				line_number++;
			}
			t.printTree();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Input file was not found.");
		}	
    }
}
