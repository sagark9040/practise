package leet.dp;

public class LC64M_MinimumPathSumIn2DMatrix {
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) {
                    minSum[i][j] = grid[i][j];
                } else {                
                    minSum[i][j] = grid[i][j] + Math.min(validValue(minSum, i-1, j), validValue(minSum, i, j-1));
                }
            }
        }
        return minSum[m-1][n-1];
    }
    
    public int validValue(int[][] grid, int i, int j) {
        if(i > grid.length || i < 0 || j > grid[0].length || j < 0) {
            return Integer.MAX_VALUE;
        } 
        return grid[i][j];
    }
}
