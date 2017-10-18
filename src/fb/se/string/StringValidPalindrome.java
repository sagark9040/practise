package fb.se.string;

public class StringValidPalindrome {
	
	public static boolean isPalindromeConstantSpace(String s){
		
		// TCs
		
		// Empty string
		// Single letter
		// Single non-letterOrNumber
		// Regular input with non-letterOrNumber
		// Regular with letters and numbers
		// Same alphabets different cases
		// Cases with only garbage values.

		if(s.length() < 2)
			return true;
		
		int start = 0, end = s.length()-1;
		
		while(start < end){
			
			while(start < s.length() && 
					!((s.charAt(start) >= 'a' && s.charAt(start) <= 'z') ||
				   (s.charAt(start) >= 'A' && s.charAt(start) <= 'Z') ||
				   (s.charAt(start) >= '0' && s.charAt(start) <= '9')) ){
				start++;
			}

			while(end >=0  && 
					!((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') ||
					   (s.charAt(end) >= 'A' && s.charAt(end) <= 'Z') ||
					   (s.charAt(end) >= '0' && s.charAt(end) <= '9'))){
					end--;
			}
			
			if(start < s.length()-1 && end >=0 && start < end && !equals(s, start, end))
				return false;
			
			start++;
			end--;
		}
		
		return true;
	}

	private static boolean equals(String s, int i, int j) {
		return Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j));
	}

	public static void main(String args[]){
		
		//Leetcode test cases
		System.out.println(isPalindromeConstantSpace("0p"));
		System.out.println(isPalindromeConstantSpace("a."));
		System.out.println(isPalindromeConstantSpace("a.b"));
		System.out.println(isPalindromeConstantSpace("aabbaa"));
		System.out.println(isPalindromeConstantSpace(""));
		System.out.println(isPalindromeConstantSpace("a"));
		System.out.println(isPalindromeConstantSpace(".,"));
		System.out.println(isPalindromeConstantSpace("aA"));
	}
	
}
