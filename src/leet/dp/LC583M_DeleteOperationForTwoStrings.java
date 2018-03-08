package leet.dp;

public class LC583M_DeleteOperationForTwoStrings {
	//952 ... 20 mins AC ... be careful about the lengths of the matrices
    
    //empty+a = 1 or 1+empty = 1
    //s
    //e
    
    //
    
    
    //TCs
    //both empty string = 0
    //one empty string = the nonEmpty's length
    //one letter match = 0
    //one letter no-match = 2
    //
    
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null)  return 0;
        if(word1 == null || word2 == null)  return word1 == null ? word2.length() : word1.length();
        if(word1.length() == 0 || word2.length() == 0) return word1.length() == 0 ? word2.length() : word1.length();
        
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        dp = initDP(dp, word1, word2);
        
        for(int r=1; r<=word2.length(); r++) {
            for(int c=1; c<=word1.length(); c++) {
                char one = word1.charAt(c-1), two = word2.charAt(r-1);                
                if(one == two) {
                    dp[r][c] = dp[r-1][c-1];
                } else {
                    dp[r][c] = Math.min(dp[r-1][c], dp[r][c-1]) + 1;                    
                }                                
            }
        }
        return dp[word2.length()][word1.length()];
    }
    
    public int[][] initDP(int[][] dp, String word1, String word2) {
        for(int c=0; c<=word1.length(); c++) {
            dp[0][c] = c;
        }
        for(int r=0; r<=word2.length(); r++) {
            dp[r][0] = r;
        }
        return dp;
    }
}
