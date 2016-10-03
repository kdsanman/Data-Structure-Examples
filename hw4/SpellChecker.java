/* 
 * Homework 4
 * SpellChecker.java - This program uses a dictionary to spell check a file
 * It uses two hash tables to store both files.
 */

import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {

	public static void main(String[] args) throws FileNotFoundException{
		
		// if it has the dictionary and the checking file
	    if(args.length < 2){
	         System.out.println("Use command line arguments for dictionary"
	        		+ "and text file to check");
		    return;
	    }
	   
	    // puts the dictionary into a list
	    LinkedList<String> dictionary = new LinkedList<>();  
	    Scanner input = new Scanner(new FileInputStream(args[0]));
        while (input.hasNextLine()){
              String nextLine = input.nextLine();
              dictionary.add(nextLine);
        }
        input.close();
	    
		// puts the checking file into a list
	    LinkedList<String>checking = new LinkedList<>(); 
	    Scanner input2 = new Scanner(new FileInputStream(args[1]));
        while (input2.hasNextLine()){
              String nextLine = input2.nextLine();
              checking.add(nextLine);
        }
        input2.close();
	    
        // calls the checker
		SpellChecker check = new SpellChecker();
		check.readDictionary(dictionary);
		
		LinkedList<String> mismatch = check.readFile(checking);
		
		// print the words
		for (int i=0; i<mismatch.size(); i++)
		{
			System.out.println(mismatch.get(i));
		}	
	}
	hashTable hashDictionary = new hashTable();
	
	// constructor
	public SpellChecker(){
	}
	
	// adds each word in the file to a hash table
	public void readDictionary(LinkedList<String> list){
		
		for (int i=0; i<list.size(); i++){
			String next = list.get(i).replaceFirst("^[^a-zA-Z']+", "")
    	    	    .replaceAll("[^a-zA-Z']+$", "").
    	    	    toLowerCase().replace("’","'");
		    hashDictionary.insert(next);
		}
	}
	
	public boolean findWord(String word){
		return hashDictionary.contains(word);
	}
	
	public LinkedList<String> readFile(LinkedList<String> list){
		
		LinkedList<String> misspelledW = new LinkedList<>();
		for (int i=0; i<list.size(); i++){
			String newLine = list.get(i);
			StringTokenizer st = new StringTokenizer(newLine);
			
   	        while (st.hasMoreTokens()){
   	    	     String alternateWord = st.nextToken();
   	    	     alternateWord = alternateWord.replaceFirst("^[^a-zA-Z']+", "")
      	    	     .replaceAll("[^a-zA-Z']+$", "").toLowerCase();
   	    	     alternateWord = alternateWord.replace("’","'");
	    	        	    	     
   	    	     if (!findWord(alternateWord)){  
    	    	    String fixedWords = wordPermute(alternateWord);
   	    	    	StringBuilder fixing = new StringBuilder(); 
   	    	    	fixing.append(alternateWord + " on " +(i+1) + ", "
   	    	    			+ "change for: " + fixedWords);
   	    	    	misspelledW.add(fixing.toString());
   	    	     }
   	        }
   	    }
   	    if (list.isEmpty())
   	    	System.out.println("No errors were found.");
   	    
   	    return misspelledW;			
	}
	
    public String wordPermute(String misspelledW)
    {
    	TreeSet<String> newWord = new TreeSet<>();
    	
    	// check by adding a character
    	for (int i = 0; i < misspelledW.length() + 1; i++)
    	{
	        for (char abet ='a'; abet<= 'z'; abet++)
	        {
	        	StringBuilder word = new StringBuilder(misspelledW);
	        	word.insert(i, abet);
	        	if (findWord(word.toString()))
	        	{	        		
	        		if (!newWord.contains(word.toString()))
	        		    newWord.add(word.toString());
	        	}
	        }
    	}
    	// check by removing a character
    	for (int i = 0; i< misspelledW.length(); i++)
    	{
	        StringBuilder word = new StringBuilder(misspelledW);
	        word.deleteCharAt(i);
	        if (findWord(word.toString()))
	        {
	        	if (!newWord.contains(word.toString()))
	        	    newWord.add(word.toString());
	        }
    	}   	
    	// check by swaping adjacent letters
    	for (int i = 0; i < misspelledW.length()-1;i++)
    	{
    		StringBuilder string = new StringBuilder(misspelledW);
    		char smth = string.charAt(i);
    		string.setCharAt(i, string.charAt(i+1));
    		string.setCharAt(i+1,smth);
    		if (findWord(string.toString()))
    		{
	        	if (!newWord.contains(string.toString()))
	        		newWord.add(string.toString());
	        }
    	}   
    	
    	String result = "";
    	if (newWord.isEmpty())
    		result = "";
    	else
    		result = newWord.toString().substring(1,newWord.toString().length()-1);
    	return result;
    }
    
    public static class hashTable {
    	//Instance Variables
        private static final int tableSize = 113;
        private HashEntry<String> [ ] array;
        private int occupied;
        private int size; 

    	public hashTable(){
    		this (tableSize);
    	}
    	
    	private hashTable(int tableSize){
    		makeArray(tableSize);
    		makeEmpty();
    	}
    	
    	public boolean insert (String x){
    		int position = Position(x);
    		if(exists(position))
    		    return false;
    	    array[position] = new HashEntry<>(x,true);
    	    size++;
    	    if(++occupied > array.length/2)
    	    	rehash(); 
    	    return true;  
    	}
    	private void rehash(){
    		HashEntry<String> [] oldArray = array;
    		makeArray(2 * oldArray.length);
    		occupied = 0;
    		size = 0;	
            for(HashEntry<String> entry:oldArray)
                if(entry != null && entry.exists)
                    insert(entry.object);
    	}
    	
    	private int Position( String x){
    		int offset = 1;
    		int position = myhash(x);
    		
    		while(array[position]!=null && !array[position].object.equals(x)){
    			position = position + offset;
    			offset = offset + 2;
    			if( position >= array.length)
    				position = position - array.length;
    		}
    		return position;
    	}
    	
        public boolean remove(String x){
            int position = Position(x);
            if(exists(position)){
                array[position].exists = false;
                size--;
                return true;
            }
            else
                return false;
        }
    	
        public int size(){
            return size;
        }
        
        public int capacity(){
            return array.length;
        }
        
        public boolean contains(String x){
            int position = Position(x);
            return exists(position);
        }
    	
        private boolean exists(int Position){
            return array[Position] != null && array[Position].exists;
        }
    	
        private void makeEmpty(){
            occupied = 0;
            for(int i = 0; i<array.length; i++)
                array[i] = null;
        }
    	
        private int myhash(String x){
            int hash = x.hashCode();

            hash %= array.length;
            if(hash < 0)
                hash= hash+ array.length;
            return hash;
        }
        
        @SuppressWarnings("hiding")
    	private static class HashEntry<String>{
            public String  object;   // the object
            public boolean exists;  // false if marked deleted

            @SuppressWarnings("unused")
    		public HashEntry(String e)
            {
                this(e, true);
            }

            public HashEntry(String ob, boolean exist){
                object  = ob;
                exists = exist;
            }
        }
        
        @SuppressWarnings("unchecked")
    	private void makeArray(int arraySize){
            array = new HashEntry[nextPrime(arraySize)];
        }
        
        private static int nextPrime(int tableSize){
            if( tableSize % 2 == 0 )
            	tableSize++;
            for(;!isPrime(tableSize); tableSize+=2);
            return tableSize;
        }
        private static boolean isPrime(int tableSize){
            if( tableSize == 2 || tableSize == 3 ){
            	return true;
            }
            if( tableSize == 1 || tableSize%2 == 0){
            	return false;
            }
            for(int i = 3; i*i<=tableSize; i+=2){
                if(tableSize % i == 0)
                    return false;
        	}
            return true;
        }   
    }
}