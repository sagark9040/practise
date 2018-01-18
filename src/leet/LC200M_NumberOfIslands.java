package leet;

public class LC200M_NumberOfIslands {	

    //Thoughts - 1220 am 
	//BFS or even DFS and marking system
	//Is constant space possible????
	
	//TCs - Empty grid, no islands, all 1s, all diagonal 1s

	// -------------------		IMPROVMENTS
	// Some of the ideas like 65. validNeighbors[pos][0] = r+rowOffset; would have been corrected in the dry run.
	// Interviewer might have let me assume some of the methods for sure. Would have cut time down to 30 mins easy. 
	// DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN .. DRY RUN 
	
    boolean[][] visited = null;
        
	public int numIslands(char[][] grid) {
		// base case: null or empty grid
		if(grid == null || grid.length == 0)
			return 0;
		
        int numIslands = 0;
		visited = new boolean[grid.length][grid[0].length];

		for(int i=0; i<grid.length; i++) {            
            for(int j=0; j<grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {    
                    grid = getIslands(grid, i, j);
                    numIslands++;   
                }
            }            
        }
		return numIslands;
    }
        
    char[][] getIslands(char[][] grid, int i, int j) {
        if(grid[i][j] == '1' && !visited[i][j]){
            visited[i][j] = true;
            
            for(int[] curNeighbor : validNeighbors(grid, i, j)) {
                if(curNeighbor[0] != -1 && curNeighbor[1] != -1 && !visited[curNeighbor[0]][curNeighbor[1]]) {
                    getIslands(grid, curNeighbor[0], curNeighbor[1]);    
                }
            }
        }
        return grid;
    }
        
    int[][] validNeighbors(char[][] grid, int i, int j) {
        int[][] validNeighbors = new int[4][4];
        int pos = 0;        
        
        for(int p=0; p < validNeighbors.length; p++) {
        	validNeighbors[p][0] = -1;
        	validNeighbors[p][1] = -1;
        }
        
        int[][] neigh = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] values: neigh) {
            int rowOffset = values[0], colOffset = values[1];
            int r = i, c = j;
            
            if(r+rowOffset >= 0 && r+rowOffset < grid.length && c+colOffset >= 0 && c+colOffset < grid[0].length) {
                validNeighbors[pos][0] = r+rowOffset;
                validNeighbors[pos][1] = c+colOffset;
                pos++;
            }
        }

        return validNeighbors;
    }  
	
	public static void main(String args[]) {
		char[][] c = {{'1','1','1','1','0'},
					  {'1','1','0','1','0'},
					  {'1','1','0','0','0'},
					  {'0','0','0','0','0'}};
		
		LC200M_NumberOfIslands num = new LC200M_NumberOfIslands();
		System.out.println(num.numIslands(c));
	}
}



/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by 
water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
*/