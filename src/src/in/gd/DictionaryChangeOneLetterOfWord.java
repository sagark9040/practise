package src.in.gd;

/*
Given a dictionary find and set of two words find path from one word to another such that all the intermediate words are also from dictionary.
Example: GOD -&gt; GID -&gt; DID -&gt; DIG -&gt; DOG.
At each time we are allowed only one character change.
*/

// This answer will not be optimum if the dictionary contains a million words because the time complexity will be: O(n^2 m) where n: # of words in dict and m: length of our word.
// Instead, the optimum solution will be to change every single letter for the word length 'm' to all the characters (25m) and check that against the dict. So 25 m instead of n^2 m.

import java.util.*;

class Item {
	String word;
	int len;
 
	public Item(String word, int len) {
		this.word = word;
		this.len = len;
	}
}
 
class SetItem {
	String word;
	boolean isUsed;
 
	public SetItem(String word, boolean isUsed) {
		this.word = word;
		this.isUsed = isUsed;
	}
}
 
public class DictionaryChangeOneLetterOfWord {
 
	static boolean isAdjacent(String a, String b) {
		int c = 0;
 
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i) != b.charAt(i))
				c++;
			if(c > 1)
				return false;
		}
 
		return true;
	}
 
	static int getShortestLength(String start, String target, Set<SetItem> set) {
		Queue<Item> q = new LinkedList<Item>();
		Item item = new Item(start,1);
		q.add(item);
 
		while(!q.isEmpty()) {
			item = q.remove();
 
			for(SetItem s : set) {
				if(!s.isUsed && isAdjacent(item.word,s.word)) {
					item.word = s.word;
					item.len++;
 
					q.add(item);
 
					s.isUsed = true;
 
					if(s.word.equals(target))
						return item.len;
				}
			}
		}
 
		return 0;
	}	
 
	public static void main(String[] args) {
		Set<SetItem> set = new HashSet<SetItem>();
		set.add(new SetItem("poon",false));
		set.add(new SetItem("plee",false));
		set.add(new SetItem("same",false));
		set.add(new SetItem("poie",false));
		set.add(new SetItem("plie",false));
		set.add(new SetItem("poin",false));
		set.add(new SetItem("plea",false));
 
		String start = "toon";
		String target = "plea";
 
		System.out.println("Dictionary:");
		for(SetItem s : set)
			System.out.print("'" + s.word + "' ");
		System.out.println();
 
		System.out.println("\nans = " + getShortestLength(start,target,set));
	}
}