package test;
/*
Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

Examples:

Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
Output: Order of characters is 'b', 'd', 'a', 'c'
Note that words are sorted and in the given language "baa" 
comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Input:  words[] = {"caa", "aaa", "aab"}
Output: Order of characters is 'c', 'a', 'b'
*/

public class GiveOrderOfCharactersInForeignLanguage {
	
	public void getOrderOfCharacters () {
		//O(NxM) -> Where N=Number of words and M=length of the longest word.
		String[] words = {"baa", "abcd", "abca", "cab", "cad"};
		
		StringBuffer strBuff = new StringBuffer();
		
		for(int i=0;i<words.length;i++) { //O(N) run time
			
			if (strBuff.toString().contains(words[i]))
				System.out.println();
			
		}
	
	}
}
