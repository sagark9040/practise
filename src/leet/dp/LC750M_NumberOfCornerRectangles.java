package leet.dp;

public class LC750M_NumberOfCornerRectangles {
	//417 .. 13 min AC 
	//not sure how this is a DP problem .. wasn't super confident initially cause of the DP label. 
	//gave it a stab and it was easier than I thought.
    //Len = 2 rectangles
    
    //brute force: mxn - 1x1, 1x2, 1x3 .. 2x1, 2x2, 2x3 .. 3x1, 3x2 ...
    
    //start from ones:
    //go right and check for one, if found go down and check for ones in the same col
    
    //0,0 0,1 1,0 1,1
    
    int count = 0, m = 0, n = 0;
    public int countCornerRectangles(int[][] grid) {
    	if(grid == null || grid.length == 0 || grid[0].length == 0) {
    		return 0;
    	}
    	
    	for(int r=0; r<m; r++) {
	    	for(int c=0; c<n; c++) {
	    		if(grid[r][c] == 1) {
	    			checkRectangles(grid, r, c);	
	    		}    		
	    	}    	
	    }
    	return count;
    }
    public int countCornerRectangles2(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                
                for (int q = j + 1; q < n; q++) {
                    if (grid[i][q] == 0) continue;
                    res += dp[j][q]++;
                }
            }
        }
        
        return res;
    }
    
    void checkRectangles(int[][] grid, int row, int col) {
    	for(int c=col+1; c<n; c++) {
    		if(grid[row][c] == 1) {
    			for(int r=row+1; r<m; r++) {
        			if(grid[r][c] == 1 && grid[r][col] == 1) {
        				count++;
        			}
        		}
    		}
    	}    	
    }
    
    public static void main(String args[]) {
    	int[][] grid = {{1, 1, 1},
    	                {1, 1, 1},
    	                {1, 1, 1}};
    	LC750M_NumberOfCornerRectangles l = new LC750M_NumberOfCornerRectangles();
    	System.out.println(l.countCornerRectangles2(grid));
    	
    }
}
