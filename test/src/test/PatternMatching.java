package test;

import java.util.HashMap;

public class PatternMatching {

	
	/*
		Given a Pattern and a dictionary, print out all the strings that match the pattern. 
		where a character in the pattern is mapped uniquely to a character in the dictionary ( this is what i was given first). 
	
		e.g 1. ("abc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "cdf" 
		2. ("acc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "too", "paa"
	*/

	// Length of pattern and word differs - false
	// Loop through the N terms in the array of words O(N)
	// O(M) to count the number of words in the words[i] to match the pattern.
	// abca - a-2, b-1, c-1 --> defd - d-2, e-1, f-1 --> ddef --> d-2, e-1, f-1
	//a-2 [1112] - HashMap --> a-1, a-1 b-1, a-1 b-1 c-1, a-2 b-1 c-1
	//b-1
	//c-1
	//
	//defd - d - d-1 - [1 - ok]
	//defd - e - e-1 - [11 - ok]
	//defd - f - f-1 - [111 - ok]
	//defd - d - d-2 - [1112 - ok]
	
	//ddef - d - d-1 - [1 - ok]
	//ddef - d - d-2 - [12 - not okay as wordArr[j] == 2, but pattArr[j] == 1.
	
	public static void main (String args[]) {
		String[] arr = {"cdf", "too", "hgfdt" ,"paa"};//"cdf", "too", "hgfdt" ,"paa"};
		String patt = "acc"; // "abc";
		matchPattern(patt, arr);
	}
	
	public static void matchPattern(String patt, String[] words) {
		int pattLen = patt.length();
		
		int[] pattArr = makeArray(patt);
		
		for(int i = 0; i < words.length; i++) {
			int wordLen = words[i].length();
			
			if(pattLen == wordLen) {
				
				HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
				int[] wordArr = new int[wordLen];
				String curWord = words[i];
				boolean display = true;
				
				for(int j = 0; j < wordLen; j++) {
					
					if(hMap.containsKey(curWord.charAt(j)))
						hMap.put(curWord.charAt(j), hMap.get(curWord.charAt(j))+1);
					else
						hMap.put(curWord.charAt(j), 1);
				
					wordArr[j] = hMap.get(curWord.charAt(j)); 
					
					if(wordArr[j] != pattArr[j])
						display = false;
				}
				
				if (display == true)
					System.out.println(curWord);
					
				
			}
				
		}
		
		
	}
	
	// At every 'j'th element in the words[i], the count of all the characters should 
	// match the count of elements in the words[i] till it's jth character.
	
	
	
	private static int[] makeArray(String patt) {
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		
		int[] arr = new int[patt.length()];
		for(int i = 0; i < patt.length(); i++) {
			if(hMap.containsKey(patt.charAt(i)))
				hMap.put(patt.charAt(i), hMap.get(patt.charAt(i)) + 1);
			else
				hMap.put(patt.charAt(i), 1);
			
			arr[i] = hMap.get(patt.charAt(i));
		}
		return arr;
	}

	public void setCustomerServiceStatus(boolean customerServiceStatus) {
		this.customerServiceStatus = customerServiceStatus;
	}
	public boolean isEmailServiceStatus() {
		return emailServiceStatus;
	}
	
	/*
	 * IMPORTANT:
	 * These boolean values represent the running statuses of the email and the customer services.
	 * They should ideally ALWAYS be true unless stated by the other teams to kill them, i.e. turn the value to false. 
	 */
	
	private boolean customerServiceStatus = true;
	private boolean emailServiceStatus = true;
	
	public boolean isCustomerServiceStatus() {
		return customerServiceStatus;
	}
	
}
