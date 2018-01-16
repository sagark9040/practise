package leet.string;

public class LC387E_FirstUniqueCharacter {

	/*
First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
	*/
	
	// Thoughts
	
	// HashMap <char, count> or array[256]
	// characters and numbers? only ASCII?
	
	// TCs
	// s = null, s = "", s = "s"
	// s = "sasasa", s = "saa", s = "sss", s = "abcab", s = "acbab"  
	
	public int firstUniqChar(String s) {
		if(s == null || s.length() == 0)
			return -1;
		if(s.length() == 1)
			return 0;
		
		int[] count = new int[256];
		
		for(int i=0; i<s.length(); i++) {
			count[s.charAt(i)]++;			// DO DRY RUNS!!!!!!!!!!
		}
		
		for(int i=0; i<s.length(); i++) {
			if(count[s.charAt(i)] == 1)
				return i;
		}
		
		return -1;
    }	
}
