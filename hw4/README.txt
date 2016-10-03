SpellChecker.java - This file contains a program called SpellChecker. This
program takes in two command line arguments: a dictionary, and a file to spell
check using the dictionary. The output is suggestions to how the misspelled
word should be fixed by adding a character, removing a character, or by
swapping adjacent letters. It implements a hash table for the dictionary
and for the words that are in the file to spell check. It also implements
a tree set to check for the possible words that could be used in place of
the misspelled word in the line of the file. 
To run this file enter commands: javac SpellChecker.java and 
java SpellChecker words.txt filetospellcheck.txt. 

words.txt - This file contains over 90,000 words as part of the dictionary
that is used with SpellChecker.java. It does not need to be compiled to run 
with the program SpellChecker.

filetospellcheck.txt - This file contains some lines with correct and incorrect
spelling of words. It was created as a tester file for SpellChecker.java. Use
as directed in SpellChecker.java description. This file may be edited for
further testing of the program.

KBestCounter.java - This file contains a program called KBestCounter. This
program runs with the tester class in the file TestKBest.java. This program
implements a PriorityQueue to keep track of the k-largest elements. It also
constantly changes the PriorityQueue so that the size never exceeds k elements.
When adding a new element to the PriorityQueue that is already full with k
elements, the method count automatically adds the next item to the PQ,
converts the PQ to an array, sorts the array, and then puts the largest
values from the sorted array back into the previously cleared heap. An
ArrayList was used to reverse the order of the printed list so that it 
matched the required "from least to most" order. To run this file enter
commands: javac KBestCounter.java, javac TestKBest.java, and java TestKBest.

TestKBest.java - This file contains a program called TestKBest. It is the
provided tester class for KBestCounter for this homework. It creates a 
PriorityQueue and then calls the methods count and kbest from the file
KBestCounter.java. To compile this file enter command: javac TestKBest.java.
Use with KBestCounter; enter commands: javac KBestCounter.java and
java TestKBest.