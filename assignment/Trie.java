
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


//acts as helper for class LongestCompoundWord,
//each node, which contains a letter as its value,
//trie having list of children nodes,able to find all suffix index of a word
public class Trie {
	
	// inner class, only for the use of Trie
	private class TrieNode {
		@SuppressWarnings("unused")
		private char val;			// character stored in the node
		private HashMap<Character, TrieNode> children;	// name of string to the node
														// which has the string as value
		private boolean eow;		// if the node is at the end of a word
		
		// constructor
		public TrieNode(char val) {
			this.val = val;
			children = new HashMap<Character, TrieNode>();
			eow = false;
		}
		
		// add child to trienode
		public void addChild(char child) {
			children.put(child, new TrieNode(child));
		}
		
		// get child of trienode that has the same character as the give one
		public TrieNode getChild(char child) {
			if (!children.keySet().contains(child)) {
				return null;
			}
			
			return children.get(child);
		}
		
		// return true if child exists
		public boolean containsChild(char child) {
			return children.keySet().contains(child);
		}
	}
	
	private TrieNode root;
	private TrieNode curr;
	
	public Trie() {
		root = new TrieNode(' ');	// root
	}
	
	// insert a word to trie
	public void insert(String s) {
		char letter;
		curr = root;
		
		// traverse every letter of a word
		// update trie if a letter is not in the structure
		for (int i = 0; i < s.length(); i++) {
			letter = s.charAt(i);
			
			if (!curr.containsChild(letter)) {
				curr.addChild(letter);
			} 
			
			curr = curr.getChild(letter);
		}
		
		// mark last letter as the end of a word true
		curr.eow = true;
	}
	
	// return starting indices of all suffixes of a word
	public List<Integer> getSuffixesStartIndices(String s) {
		List<Integer> indices = new LinkedList<Integer>();	// store indices
		char letter;
		curr = root;	// start from root
		
		for (int i = 0; i < s.length(); i++) {
			letter = s.charAt(i);
			
			// if the current letter doesn't have one letter as child
			// which means trie currently doesn't have the relationship
			// returns indices of suffixes
			if (!curr.containsChild(letter))
				return indices;
			
			// move on to the child node
			curr = curr.getChild(letter);
			
			// if the letter is an end to a word, it means after the letter is a suffix
			// update indices
			if (curr.eow)
				indices.add(i + 1);
		}
		
		return indices;
	}
	
}