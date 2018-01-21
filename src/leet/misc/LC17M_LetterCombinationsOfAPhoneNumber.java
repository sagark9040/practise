package leet.misc;

import java.util.LinkedList;
import java.util.List;

// USED THE STRINGSOFAR, PATHSOFAR and SUBSTRING METHOD. THINK OF THE TREE HERE: https://www.youtube.com/watch?v=cIOxZ7bNh7w

public class LC17M_LetterCombinationsOfAPhoneNumber {

	//Thoughts
    //What about 1 and 0? What to use for them? --> Keep them empty
	//2 - abc
    //22222 -- 2,2,2,2,2 .. 2,22,22 .. 22,2,22 .. 22,22,2 .. 
	// Brute Force: I will have a map of above combinations and their letters. O(1)
	// Go through the string 1, 2, 3 or 4 at a time and 
	
	// COULDNT GO FAR AS TO GET THE 1s2s or 2s1s combination
	// 222 -- aaa, ab, ba -- 2,2,2 .. 2,22 .. 22,2
	// 22222 -- aaaaa, abb, bab, bba, aca, aac, caa, bc, cb --> 
	
	
	
    
    
	// 6 pmxw

    LinkedList<String> ans = new LinkedList<String>();
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits) {
	    //23 -- abc, def
	    
	    // 				   ""
	    // 			a   	b		c
	    //	     d e f	  d e f	  d e f	
	    
	    recurse(digits, "");
	 return ans;   
	}
	
	public void recurse (String word, String pathSoFar) {
		
		if(word == null || word.length() == 0) {
			if(pathSoFar.length() !=0)
				ans.add(pathSoFar);
			return;
		}
		
		// 2,3
		char curDigit = word.charAt(0);
		
		String letters = mapping[Character.getNumericValue(curDigit)]; 
		
		for(char eachLetter: letters.toCharArray()) {
			String rest = word.substring(1);
			String soFar = pathSoFar.concat(String.valueOf(eachLetter));
			recurse(rest, soFar);
		}
	}
	
	
	
	public static void main(String args[]) {
		LC17M_LetterCombinationsOfAPhoneNumber combi = new LC17M_LetterCombinationsOfAPhoneNumber();
		String digits = "22";
		
		for(String s:combi.letterCombinations(digits)) {
			System.out.println(s);
		}
			
	}
	
}
