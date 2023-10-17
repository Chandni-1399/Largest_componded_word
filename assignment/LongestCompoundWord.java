import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// This program calculates the longest and the second longest words in a file
// that can be constructed by concatenating copies of shorter words given in a file.  


public class LongestCompoundWord {

	public static void main(String[] args) throws FileNotFoundException {
		
		// change file name accordingly
		File file = new File("words.txt");

		// Trie create
		Trie trie = new Trie();
		LinkedList<Pair<String>> queue = new LinkedList<Pair<String>>();
		
		// used to calculate the total no. of compound words
		HashSet<String> compoundWords = new HashSet<String>();
		
		// scanning through the file
		@SuppressWarnings("resource")
		Scanner s = new Scanner(file);

		String word;				// a word
		List<Integer> sufIndex;	//index suffixes of a word
		
		//read words from the file,fill the queue with words having suffix,
		//having candidate compound word,insert each word in trie
		while (s.hasNext()) {
			word = s.next();		
			sufIndex = trie.getSuffixesStartIndices(word);
		
			for (int i : sufIndex) {
				if (i >= word.length())		// if index is out of bound
					break;					// it means suffixes of the word has
											// been added to the queue if there is any
				queue.add(new Pair<String>(word, word.substring(i)));
			}
	
			trie.insert(word);
		}
		
		Pair<String> p;				// a pair of word and its remaining suffix
		int maxLength = 0;			// longest compound word length
				
		String longest = "";		// longest compound word
		String secondLongest = "";	// second longest compound word

		while (!queue.isEmpty()) {
			p = queue.removeFirst();
			word = p.second();
			
			sufIndex = trie.getSuffixesStartIndices(word);
			
			// if no suffixes found, which means no prefixes found
			// discard the pair and check the next pair
			if (sufIndex.isEmpty()) {
				continue;
			}
			
			
			for (int i : sufIndex) {
				if (i > word.length()) { //base case 
					break;
				}
				
				if (i == word.length()) { // no suffix, means it is a compound word
					// check if the compound word is the longest
					// if it is update both longest and second longest
					// update words 
					if (p.first().length() > maxLength) {
						secondLongest = longest;
						maxLength = p.first().length();
						longest = p.first();
					}
			
					compoundWords.add(p.first());	// the word is compound word
					
				} else {
					queue.add(new Pair<String>(p.first(), word.substring(i)));
				}
			}
		}
		
		// print out the results
		System.out.println("Longest Compound Word: " + longest);
		System.out.println("Second Longest Compound Word: " + secondLongest);
	
	}
}