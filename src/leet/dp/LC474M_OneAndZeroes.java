package leet.dp;

public class LC474M_OneAndZeroes {
	 //1030pm    ... NOT MY SOLN 
    //Sort by size?
    
    //either you include something or you don't
    
    // 1 1 1 01 000
    // 1 1 01 .. 1 1 1
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        //45
        
        for(String s:strs) {
            int countZero = count(s, '0');
            int countOne = count(s, '1');
            
            for(int i=m; i>=countZero; i--) {
                for(int j=n; j>=countOne; j--) {
                    dp[i][j] = Math.max(1 + dp[i-countZero][j-countOne], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    
    public int count(String s, char c) {
        int cnt = 0;
        for(char sChar:s.toCharArray()){
            cnt += sChar == c ? 1 : 0;
        }
        return cnt;
    }
}
