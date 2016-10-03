/* 
 * Homework 4
 * KBestCounter.java - keeps track of the k-largest elements seen so far
 * in a set of data; works with a tester class
 */
import java.util.PriorityQueue;
import java.util.*;

public class KBestCounter<T extends Comparable<? super T>> {
	
	PriorityQueue<T> heap1; 
	int k; 
	
	// assigns k a value
	public KBestCounter(int k){ 
		this.k = k;
		heap1 = new PriorityQueue();
	} 
	
	// add an element
	public void count(T x){ 
		if (heap1.size() < k){
			heap1.add(x);
		}
		else {
			heap1.add(x);
			Object[] sortThis = heap1.toArray();
			Arrays.sort(sortThis);
			heap1.clear();
			int e = sortThis.length - 1;
			while (heap1.size() < k){
				heap1.add((T) sortThis[e]);
				e--;
			}
			this.heap1 = heap1;
		}
	}
	//return a sorted (largest to smallest) list of the k largest elements
	@SuppressWarnings("null")
	public List kbest() { 
		// sort the queue
		Object[] sortThis = heap1.toArray();
		Arrays.sort(sortThis);
		List<Object> toPrint = Arrays.asList(sortThis);
		
		if (toPrint.size() < k){			
			// reverse the ordering of the numbers in the list
			List<Object> reverseList = new ArrayList();
			for (int r = toPrint.size() - 1; r >= 0; r--){
				reverseList.add(toPrint.get(r));
			}
			return reverseList;
		}
		while (toPrint.size() == k){
			// reverse the ordering of the numbers in the list
			List<Object> reverseList = new ArrayList();
			for (int r = toPrint.size() - 1; r >= 0; r--){
				reverseList.add(toPrint.get(r));
			}
			return reverseList;
		}
		return null;
	}	   
}