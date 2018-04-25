package leet.array;

public class LC807M_MaxIncreaseToKeepCitySkyline {
 //310 .. 8 min AC .. O(mn) time and O(m+n) space
    
    //[3, 0, 8, 4], 
    //[2, 4, 5, 7],
    //[9, 2, 6, 3],
    //[0, 3, 1, 0] 
    
    //for every i,j - can be max of row vals and col vals
    
    //8 8 8 8
    //7 7 7 7
    //9 9 9 9
    //3 3 3 3
    
    //9 4 8 7
    //9 4 8 7
    //9 4 8 7
    //9 4 8 7
    
    //8 4 8 7
    
    
    
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null || grid.length == 0 || grid.length == 1 || grid[0].length == 1) {
            return 0;
        }
        
        int[] maxRows = new int[grid.length];
        int[] maxCols = new int[grid[0].length];
        int increase = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                maxRows[i] = Math.max(maxRows[i], grid[i][j]);
                maxCols[j] = Math.max(maxCols[j], grid[i][j]);
            }
        }
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                int prev = grid[i][j];
                grid[i][j] = Math.min(maxRows[i], maxCols[j]);                
                increase += grid[i][j] - prev;
            }
        }
        
        return increase;
    }
}
