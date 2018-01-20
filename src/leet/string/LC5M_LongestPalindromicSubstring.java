package leet.string;

public class LC5M_LongestPalindromicSubstring {

	int longestStart = 0, maxLen = 0;
	public String longestPalindrome(String s) {
		
		if(s == null)
			return "";
		if(s.length() < 2)
			return s;
		
		for(int i=0; i<s.length()-1; i++) {
			
			isPalindrome(s, i, i); //Odd number of elements
			isPalindrome(s, i, i+1);
			
		}
		
		return s.substring(longestStart, longestStart+maxLen);		
	}
	
	
	
	private void isPalindrome(String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		
		if(maxLen < end - start - 1) {
			longestStart = start + 1;
			maxLen = end - start - 1;
		}
		
	}

	// Got 32 test cases. But not a great solution as it is O(n^2)	
	public String mySlowSolutionLongestPalindrome(String s) {
		String longestPali = "";
		
		if(s == null)
			return "";
		
		if(s.length() < 2)
			return s;
		
		for(int i=0; i<s.length(); i++) { // babad
			int left = i-1, right = i+1;
			StringBuilder sub = new StringBuilder().append(s.charAt(i));
			
			while (left >= 0 || right <s.length()) {
				//add left & check Pali
				
				if(left >= 0) {
					sub = new StringBuilder().append(s.charAt(left)).append(sub);
					if(isPali(sub)) {
						longestPali = sub.length() > longestPali.length() ? sub.toString() : longestPali;
					}
				}
					
				if(right < s.length()) {
					sub = sub.append(s.charAt(right));
					if(isPali(sub)) {
						longestPali = sub.length() > longestPali.length() ? sub.toString() : longestPali;
					}
				}
				
				left--; right++;
			}
		}
				
		return longestPali.length() == 0 ? s.substring(s.length()-1) : longestPali;
    }	

	private boolean isPali(StringBuilder str) {
		if (str == null || str.length() < 2)
			return true;
		
		int left = 0, right = str.length()-1;
		
		while(left < right) {
			if(str.charAt(left) != str.charAt(right))
				return false;
			left++; right--;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		LC5M_LongestPalindromicSubstring longestPalindrome = new LC5M_LongestPalindromicSubstring();
		System.out.println(longestPalindrome.longestPalindrome("babad"));
		longestPalindrome = new LC5M_LongestPalindromicSubstring();
		System.out.println(longestPalindrome.longestPalindrome("abba"));
		longestPalindrome = new LC5M_LongestPalindromicSubstring();
		System.out.println(longestPalindrome.longestPalindrome("abcde"));		
	}
}