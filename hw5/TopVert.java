import java.util.*;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Queue;

/* 
 * Homework 5
 * TopVert.java - A program that implements top sort using an
 * adjancency list representation to store a graph. uses a HashMap
 * to map from class id to TopVert object, uses the Queue based implementation
 * of TopSort
 */
public class TopVert {
	
	List<ArrayList<String>> adj;
	ArrayList<Integer> indegrees;
	ArrayList<String> classes;
	Queue<String> queue;
	ArrayList<String> list;
	int indegree;
	Object clas;
	
	public void TopVertHandle (String[] a, int indegree){
		if (indegree != 0){
			clas = a[0];

			//Add the class to the classes list
			classes.add((String) clas);

			//Add the indegree to the indegrees list
			indegrees.add(indegree);

			list.clear();
			/* Add a space for the class, which right now is not a pre-req
			 for any other class, so their adj is null */
			adj.add(list);

			//Go through the pre-requisites, and add the class to their adj list
			for (int i = 1; i < a.length; i++){
				list.clear();

				//Get the index of when the pre-req has everything stored
				int indexToAdd = classes.indexOf(a[i]);

				/* If -1 is returned, the pre-req was not in the input file
				first than the class, so ask for better input */
				if (indexToAdd == -1){
					System.out.println("Please provide organized input file");
					break;
				}

				/*Go to the adjacency list array, add class to the pre-req's
				adj list */

				//get the current adjancency list
				list = adj.get(indexToAdd);
				ArrayList<String> tmp = new ArrayList<>(list);
				//Add the class to the list
				tmp.add((String) clas);

				//Put the new list back to the adj list
				adj.set(indexToAdd, tmp);
			}
		}
		
		if (indegree == 0) 
		{
			clas = a[0];
			//Add class to queue with indegrees 0
			queue.add((String) clas);
			classes.add((String) clas);
			list.clear();
			if (list.isEmpty())
				adj.add(list);
			indegrees.add(indegree);
		}
	}

	void topsort () {
		//set the queue to the classes that have indegree of 0
		Queue<String> q = new LinkedList<>(queue);
//		System.out.println("q: " + q);
		
		//while the queue of indegree 0 is not empty
		while (!q.isEmpty()){
			String v = q.remove();
			System.out.print(v + ", ");
			
			int index = classes.indexOf(v);
			List<String> adjList = adj.get(index);
			
			if (!adjList.isEmpty()){
				for (int i = 0; i < adjList.size(); i++){
					int indexx = classes.indexOf(adjList.get(i));
					int tempp = indegrees.get(indexx);
					indegrees.set(indexx, tempp-1);
					if (indegrees.get(indexx) == 0){
						q.add(adjList.get(i));
					}
				}
			}
		}
	
	}
	
	public TopVert(Scanner textFile) {
		//Initializing instance variables
		queue = new LinkedList<String>();
		classes = new ArrayList();
		adj = new ArrayList<>();
		indegree = -1;
		indegrees = new ArrayList();
		list = new ArrayList();
		
		while (textFile.hasNextLine())
		{
			String line = textFile.nextLine();
			
			Scanner checkLine = new Scanner(line);
			List<String> tmp = new ArrayList<String>();

			while (checkLine.hasNext()){
				String check = checkLine.next();
				tmp.add(check);
			}
			String[] temp = new String[tmp.size()];
			temp = tmp.toArray(temp);
			TopVertHandle(temp, temp.length - 1);
			
		}
		topsort();
	}
}

