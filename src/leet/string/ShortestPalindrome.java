package leet.string;

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
    
		// 1109 pm
		// Given "aacecaaa", return "aaacecaaa".
		// Given "abcd", return "dcbabcd".
		
		// Thoughts:
		// Something to do with count
		// aacecaaa: a5, c2, e1 
		// Start with the last letter and start inserting at the beginning and checking: O(N) letters added and checked with O(N) of the already existing letters
		
		// TCs:
		// Empty string (ask interviewer about the case here), one letter string (add nothing),  
		
		if (s == null || s.length() < 2 || isPalindrome(s))
			return s;
		
		for(int len=0; len<=s.length(); len++) {
			String newString = new StringBuilder(s).reverse().substring(0, len);
			newString = newString.concat(s);
			
			if(isPalindrome(newString))
				return newString;
		}
		
		return "";
    }

	
	private boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.length() < 2)
			return true;
		
		for(int i=0; i<s.length(); i++) {
			if(!(s.charAt(i) == s.charAt(s.length() - (1+i))))
				return false;
		}
		return true;
	}
	
	public static void main(String args[]) {
		ShortestPalindrome shortest = new ShortestPalindrome();
		System.out.println(shortest.shortestPalindrome(""));
		System.out.println(shortest.shortestPalindrome("aa"));
		System.out.println(shortest.shortestPalindrome("abcd"));
		System.out.println(shortest.shortestPalindrome("ananab"));
	}
}