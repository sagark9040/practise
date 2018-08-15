package leet.dfsBfs;

public class LC695E_MaxIslandArea {
	int m = 0, n = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)    return 0;
        
        int count = 0, max = 0;
        m = grid.length;
        n = grid[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    count = dfs(grid, i, j, 0);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
    
    public int dfs(int[][] grid, int i, int j, int count) {
        if(!valid(i, j) || grid[i][j] == 0) {
            return 0;
        }
        
        grid[i][j] = 0;
        return 1 + dfs(grid, i-1, j, count) + dfs(grid, i, j-1, count) + dfs(grid, i, j+1, count) + dfs(grid, i+1, j, count);
    }
    
    public boolean valid(int i, int j) {
        return i>=0 && i<m && j>=0 && j<n;
    }
}
