package leet.dp;

public class LC516M_LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0)    return 0;
        
        int[][] dp = new int[s.length()][s.length()];
        int strLen = s.length();
        for(int l=0; l<strLen; l++) {
            for(int i=0; i<strLen; i++) {
                if(l==0) {
                    dp[i][i] = 1;
                    continue;
                }
                
                int j=i+l;
                if(i < j && j<strLen) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }   
                }
            }
        }
        
        return dp[0][strLen-1];
    }
	
	public static void main(String args[]) {
		String s = "cbbd";
		LC516M_LongestPalindromicSubsequence l = new LC516M_LongestPalindromicSubsequence();
		System.out.println(l.longestPalindromeSubseq(s));
	}
}
