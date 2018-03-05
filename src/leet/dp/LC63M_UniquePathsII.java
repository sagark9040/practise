package leet.dp;

public class LC63M_UniquePathsII {
	
	//1007 .. 13 mins AC with corner cases
	int m = 0, n = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0)
            return 0;
        if(obstacleGrid.length == 1 && obstacleGrid[0].length == 0)
            return 1;
            
        m = obstacleGrid.length; n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return unique(m-1, n-1, dp, obstacleGrid);    
    }
    
    public int unique(int r, int c, int[][] dp, int[][] obstacleGrid) {
        if(r < 0 || c < 0 || r >= m || c >= n || obstacleGrid[r][c] == 1) {
            return 0;
        }
        
        if(r == 0 && c == 0) {
            return 1;
        }
        
        if(dp[r][c] > 0) {
            return dp[r][c];
        }
        
        dp[r][c] = unique(r-1, c, dp, obstacleGrid) + unique(r, c-1, dp, obstacleGrid);
        return dp[r][c];
    }
}
