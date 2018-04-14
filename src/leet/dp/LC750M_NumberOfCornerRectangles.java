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
    
    public int countCornerRectanglesOptimalDPSoln(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][n];
        
        int res = 0;
        for (int r = 0; r < m; r++) {
            for (int c1 = 0; c1 < n; c1++) {
                if (grid[r][c1] == 1) {
                    for (int c2 = c1 + 1; c2 < n; c2++) {
                        if (grid[r][c2] == 1) {
                            res += dp[c1][c2];
                            dp[c1][c2]++;
                         
                        }
                    }
                }
            }
        }
        return res;
    }
}
