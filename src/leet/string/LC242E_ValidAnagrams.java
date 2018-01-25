package leet.string;

import java.util.Arrays;

public class LC242E_ValidAnagrams {

	/*
	Given two strings s and t, write a function to determine if t is an anagram of s.

	For example,
	s = "anagram", t = "nagaram", return true.
	s = "rat", t = "car", return false.

	Note:
	You may assume the string contains only lowercase alphabets.

	Follow up:
	What if the inputs contain unicode characters? How would you adapt your solution to such case?
	*/
	
	public boolean isAnagram(String s, String t) {
		if(s == null && t == null)	return true;
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		return compareArrays(s1, t1);
    }

	private boolean compareArrays(char[] s1, char[] t1) {
		if(s1.length != t1.length)
			return false;
        
        Arrays.sort(s1); Arrays.sort(t1);
        
		for(int i=0; i<s1.length; i++)
			if(s1[i] != t1[i])
				return false;
		
		return true;
	}
}
