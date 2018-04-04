package leet.dfsBfs;

import java.util.ArrayList;
import java.util.List;

public class LC417M_PacificAtlanticWaterFlow {
	
	//1118..56 ... 38 min AC
	//Start from the pacific and mark the top row and left column as pacific approachable [1] in a visited grid. Do the increment only once.
	//Using the same grid, start from the atlantic - last column and row and increment the counter. So whichever has 2 has been visited by both.

	// for row 0 dfs - init unvisited, mark visited & dfs if neighbor is bigger and unvisited
	// for col 0 dfs - init unvisited, mark visited & dfs if neighbor is bigger and unvisited

	// for row m-1 dfs 
	// for col n-1 dfs

	// Test cases
	// m = n = 0
	// one row
	// one col
	// equal m = n
	// m != n
	
	public List<int[]> pacificAtlantic(int[][] matrix) {
	    List<int[]> result = new ArrayList<int[]>();

		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		
		int m = matrix.length, n = matrix[0].length;
	    boolean[][] visited = new boolean[m][n];
	    int[][] water = new int[m][n];

	    for(int c=0; c<n; c++) {        
	        dfs(matrix, 0, c, visited, water);
	    }
	    for(int r=0; r<m; r++) {
	        dfs(matrix, r, 0, visited, water);
	    }
	    
	    for(int r=0; r<water.length; r++) {
	        for(int c=0; c<water[0].length; c++) {
	            if(visited[r][c]) {
	                water[r][c] = 1;
	            }
	        }
	    }

	    visited = new boolean[m][n];
	    for(int c=0; c<n; c++) {        
	        dfs(matrix, m-1, c, visited, water);
	    }
	    for(int r=0; r<m; r++) {
	        dfs(matrix, r, n-1, visited, water);
	    }

	    for(int r=0; r<water.length; r++) {
	        for(int c=0; c<water[0].length; c++) {
	            if(visited[r][c]) {
	                water[r][c]++;
	            }
	        }
	    }
	    
	    for(int r=0; r<water.length; r++) {
	        for(int c=0; c<water[0].length; c++) {
	            if(water[r][c] == 2) {
	                result.add(new int[]{r, c});
	            }
	        }
	    }
	    return result;
	}

	void dfs(int[][] matrix, int r, int c, boolean[][] visited, int[][] water) {
	    visited[r][c] = true;

	    if(r >=0 && c+1 >= 0 && r < matrix.length && c+1 < matrix[0].length && !visited[r][c+1] && matrix[r][c+1] >= matrix[r][c])
	        dfs(matrix, r, c+1, visited, water);

	    if(r >=0 && c-1 >= 0 && r < matrix.length && c-1 < matrix[0].length && !visited[r][c-1] && matrix[r][c-1] >= matrix[r][c])
	        dfs(matrix, r, c-1, visited, water);

	    if(r+1 >=0 && c >= 0 && r+1 < matrix.length && c < matrix[0].length && !visited[r+1][c] && matrix[r+1][c] >= matrix[r][c])
	        dfs(matrix, r+1, c, visited, water);

	    if(r-1 >=0 && c >= 0 && r-1 < matrix.length && c < matrix[0].length && !visited[r-1][c] && matrix[r-1][c] >= matrix[r][c])
	        dfs(matrix, r-1, c, visited, water);
	}
	
	
//	//203 pm
//	//Didn't understand the problem, had to see explanation.
//	//Rain water is the source of water.
//	//Could use the cell value as Integer.Min and Integer.Max for both oceans.
//	
//	// INTERESTING SOLUTION:
//	// START FROM THE OCEAN FACING POINTS AND BUILD A QUEUE AND DO DFS, MARK THEM AS VISITED BY EACH OCEAN'S QUEUE IF NOT ALREADY VISITED
//	// ALL THE POINTS VISITED BY BOTH OCEANS ARE THE ANSWER
//	
//	
//	int m, n;
//	public List<int[]> pacificAtlantic(int[][] matrix) {
//		//1, 0, 2 .. 1 = Atlantic
//		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//			return new ArrayList<int[]>();
//		}
//		
//		m = matrix.length; n = matrix[0].length;
//		boolean[][] visitedByAtlantic = initVisitedByAtlantic(m, n);
//		Queue<int[]> atlanticQueue = initAtlanticQueue(m, n);
//		visitedByAtlantic = dfs(atlanticQueue, visitedByAtlantic, matrix);
//		
//		boolean[][] visitedByPacific = initVisitedByPacific(m, n);
//		Queue<int[]> pacificQueue = initPacificQueue(m, n);
//		visitedByPacific = dfs(pacificQueue, visitedByPacific, matrix);
//		
//		return visitedByBoth(visitedByAtlantic, visitedByPacific);
//    }
//
//	private List<int[]> visitedByBoth(boolean[][] visitedByAtlantic, boolean[][] visitedByPacific) {
//		List<int[]> res = new ArrayList<int[]>();
//		for(int i=0; i<m; i++) {
//			for(int j=0; j<n; j++) {
//				if(visitedByAtlantic[i][j] && visitedByPacific[i][j]) {
//					res.add(new int[]{i, j});
//				}
//			}
//		}
//		return res;
//	}
//
//	private boolean[][] dfs(Queue<int[]> queue, boolean[][] visited, int[][] matrix) {
//		if(!queue.isEmpty()) {
//			int[] point = queue.poll();
//			int r = point[0], c = point[1];
//			visited[r][c] = true;
//			queue.addAll(validUnvisitedNeighbors(r, c, visited, matrix));
//		}
//		return visited;
//	}
//
//	private Queue<int[]> validUnvisitedNeighbors(int r, int c, boolean[][] visited, int[][] matrix) {
//		Queue<int[]> queue = new LinkedList<int[]>();
//		
//		int[][] diff = {{0,-1},{-1,0},{1,0},{0,1}};
//		for(int[] d:diff) {
//			if(r+d[0] >= 0 && r+d[0]<m && c+d[1] >=0 && c+d[1]<n) {
//				if(!visited[r+d[0]][c+d[1]] && matrix[r][c] <= matrix[r+d[0]][c+d[1]]) {
//					queue.add(new int[]{r+d[0], c+d[1]});
//				}
//			}
//		}
//		
//		return queue;
//	}
//
//	private Queue<int[]> initPacificQueue(int m, int n) {
//		Queue<int[]> q = new LinkedList<int[]>();
//		for(int j=0; j<n; j++) {
//			q.add(new int[]{0, j});
//		}
//		for(int i=0; i<m; i++) {
//			q.add(new int[]{i, 0});
//		}
//		return q;
//	}
//
//	private Queue<int[]> initAtlanticQueue(int m, int n) {
//		Queue<int[]> q = new LinkedList<int[]>();
//		for(int i=0; i<m; i++) {
//			q.add(new int[]{i, n-1});
//		}
//		for(int j=0; j<n; j++) {
//			q.add(new int[]{m-1, j});
//		}
//		return q;
//	}
//
//	private boolean[][] initVisitedByPacific(int m, int n) {
//		boolean[][] visitedByPacific = new boolean[m][n];
//		for(int j=0; j<n; j++) {
//			visitedByPacific[0][j] = true;
//		}
//		for(int i=0; i<m; i++) {
//			visitedByPacific[i][0] = true;
//		}
//		return visitedByPacific;
//	}
//
//	private boolean[][] initVisitedByAtlantic(int m, int n) {
//		boolean[][] visitedByAtlantic = new boolean[m][n];
//		for(int i=0; i<m; i++) {
//			visitedByAtlantic[i][n-1] = true;
//		}
//		for(int j=0; j<n; j++) {
//			visitedByAtlantic[m-1][j] = true;
//		}
//		return visitedByAtlantic;
//	}		
	
	public static void main(String args[]) {
		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}; 
		LC417M_PacificAtlanticWaterFlow p = new LC417M_PacificAtlanticWaterFlow();
		for(int[] r:p.pacificAtlantic(matrix))
			System.out.println(r[0]+""+r[1]);
	}
}
//	Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
//	the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

//	Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
//	Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

//	Given the following 5x5 matrix:
//
//		  Pacific ~   ~   ~   ~   ~ 
//		       ~  1   2   2   3  (5) *
//		       ~  3   2   3  (4) (4) *
//		       ~  2   4  (5)  3   1  *
//		       ~ (6) (7)  1   4   5  *
//		       ~ (5)  1   1   2   4  *
//		          *   *   *   *   * Atlantic
//
//		Return:
//
//		[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
	




