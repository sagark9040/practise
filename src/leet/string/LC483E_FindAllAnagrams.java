package leet.string;

import java.util.ArrayList;
import java.util.List;

public class LC483E_FindAllAnagrams {
	
	//THOGHTS
	//1) Brute Force: Start with a moving window of length p. If there letters in this window match the letters in the string p, display start. 

	//TCs
	//Empty string, either one or both:  no output.
	//s < p then:						 no output.
	//Single length string s or p or both
	//s=baab p = baa, then both 0 and 1 will be output

	
	// 1105 to 1125 solved.
	
	public List<Integer> findAnagrams(String s, String p) {
		
		//base cases of empty s or p, s < p:
		if(s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
			return new ArrayList<Integer>();
		
		int start = 0, end = 0;		
		int[] countS = new int[256];
		int[] countP = new int[256];
		List<Integer> anagramPositions = new ArrayList<Integer>();
		
		while (end < p.length()) {
			countS[s.charAt(end)]++;			/// ONCE AGAIN I FAILED TO ADD CHARAT HERE ... ARGHHHHHHH
			countP[p.charAt(end)]++;
			end++;
		}
		
		if(countsMatch(countS, countP))
			anagramPositions.add(start);
		
		for (end = p.length(); end < s.length(); end++) {			
			countS[s.charAt(start)]--;
			start++;
			countS[s.charAt(end)]++;
			if(countsMatch(countS, countP))
				anagramPositions.add(start);
		}
		
		return anagramPositions;        
    }

	public boolean countsMatch(int[] countS, int[] countP) {
		for(int i=0; i<256; i++)
			if(countS[i] != countP[i])
				return false;
		return true;
	}
	
	public static void main(String args[]) {
		LC483E_FindAllAnagrams find = new LC483E_FindAllAnagrams();
		find.findAnagrams("aa", "bb");
	}
}

/*

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/