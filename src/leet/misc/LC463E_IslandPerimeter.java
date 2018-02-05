package leet.misc;

//345p - 353p
//Looks straightforward.
//Iterate O(mn) and for each, count 4 neighbors. Peri of cur = 4-numOfNeigh

public class LC463E_IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					int nei = getNeighbors(i, j, grid);
					perimeter += 4-nei;
				}
			}
		}		
		return perimeter;
    }

	private int getNeighbors(int i, int j, int[][] grid) {
		int[] row = {0, -1, 0, 1};
		int[] col = {-1, 0, 1, 0};
		int neighbors = 0;
		for(int cell=0; cell<4; cell++) {
			if((i + row[cell] >= 0 && i + row[cell] < grid.length) &&
			   (j + col[cell] >= 0 && j + col[cell] < grid[0].length)) {
				if(grid[i+row[cell]][j+col[cell]] == 1)
					neighbors++;
			}
		}
		return neighbors;
	}
	
	public static void main(String args[]) {
		LC463E_IslandPerimeter i = new LC463E_IslandPerimeter();
		int[][] grid = {{0,1,0,0},
		                {1,1,1,0},
		                {0,1,0,0},
		                {1,1,0,0}};
		System.out.println(i.islandPerimeter(grid));
	}
}
