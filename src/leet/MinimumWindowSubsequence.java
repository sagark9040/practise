package leet;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubsequence {
	
	//453 pm
	
	//duplicates eg: t = bdd or dbbd, negative scenarios = not present
	
	public String minWindow(String S, String T) {
		int[][] mat = new int[T.length()][S.length()];
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		List<Integer> toPrint = new ArrayList<Integer>();
		
		for(int c=0; c<S.length(); c++) {
			mat[0][c] = T.charAt(0) == S.charAt(c) ? c : -1;
			
		}
		
		for(int r=1; r<T.length(); r++) {
			List<Integer> curList = new ArrayList<Integer>();
			for(int c=0; c<S.length(); c++) {
				int prev = -1;
				if(r > 0) 
					prev = mat[r-1][c];
				else
					curList.add(c);
				
				if(T.charAt(r) == S.charAt(c)) {
					mat[r][c] = c;
					
					if(prev != -1 && prev < c) {
						curList.add(prev);
						curList.add(c);
					}					
				} else {
					mat[r][c] = -1;
					
				}
			}
			lists.add(curList);
		}
		
		int end = -1;
				
		for(int r=T.length()-1; r>=0; r--) {
			int c = S.length()-1;
			
				if(mat[r][c] != -1) {
					end = c;
					
				}
			}
			
			
		
		
		return "";
    }
	
	public static void main(String args[]) {
		
		MinimumWindowSubsequence m = new MinimumWindowSubsequence();
		m.minWindow("abcdebdde", "bde");
		
	}
}

/*
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:
Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
*/
