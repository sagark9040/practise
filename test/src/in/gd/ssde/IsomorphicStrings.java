package in.gd.ssde;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */


/*

p-0-2 
a-1
p-2
e-3
r-4

 */
public class IsomorphicStrings {

	//  
	
	public static boolean isIsomorphic (String word1, String word2) {
		
		Map<Character, Character> mapping;
		
		if (word1.length() != word2.length()) 
			return false;
		
		if (word1.length() == 0)
			return true;
				
		mapping = new HashMap<Character, Character>();
		
		for (int i = 0; i < word1.length(); i++) {
			
			char firstChar = word1.charAt(i);
			char secondChar = word2.charAt(i);
			
			if (mapping.containsKey(firstChar)) {
				if (secondChar == mapping.get(firstChar))
					return true;
				else
					return false;
			}
				
			else
				mapping.put(firstChar, secondChar);
			
		}
		return true;
		
	}
	
	public static void main(String args[]) {
		String s1="paper", s2="title";
		System.out.println(isIsomorphic(s1, s2));
		s1="."; s2=".";
		System.out.println(isIsomorphic(s1, s2));
		
		/*
		 * SAF book
		 * Linkedin appl
		 * Bloomberg appl
		 * 
		 */
	}

}

