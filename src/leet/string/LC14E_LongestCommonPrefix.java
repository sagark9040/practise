package leet.string;

public class LC14E_LongestCommonPrefix {
	
	// Common between how many array strings?
	// TCs
	// Empty array
	// Unequal number of length
	// Equal lengths
	// No common substring       							<------ MISSED THIS!!!!!!!!!!!!

	// Method 1:
	// Length of shortest string : O(n) + O(l) * O(n) times I'll go and check for the length: worst case is O(n^2)	
	
	/*
Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"
	 */
	
	public String longestCommonPrefix(String[] strs) {

		int minLength = getMinLength (strs);
		
		if (minLength == 0)
			return "";
		
		for (int l=minLength; l>=1; l--) { ///   						<--- Can probably use binary search here !!!!!!  Algo changes to O(log L x N) ... will matter if L == N 
			boolean isLongestPrefix = true;
			String sub = strs[0].substring(0, l);
			
			for(String s: strs) {
				if(!s.substring(0, l).equals(sub))
					isLongestPrefix = false;
			}
			
			if(isLongestPrefix)
				return strs[0].substring(0, l);
			
		}
		
		return "";
    }

	private int getMinLength(String[] strs) {
		if (strs == null || strs.length == 0)
			return 0;
		
		int minLength = Integer.MAX_VALUE;		
		for(String cur: strs) {
			if (cur.length() < minLength)
				minLength = cur.length();
		}
		return minLength;
	}
	
	public static void main(String args[]) {
		LC14E_LongestCommonPrefix longest = new LC14E_LongestCommonPrefix();
		String[] strs = {"a","b"};
		System.out.println(longest.longestCommonPrefix(strs));
	}
}
