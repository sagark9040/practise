package leet.dp;

public class LC361M_EnemyBomb {
	
	//20 min .. 38/40 TCs	
	//1207: 26 min AC
		
	//BF: For every '0' cell go up (down, right, left) till end or wall - increment the enemy count
	//0 E 0 0
	//E 0 W E
	//0 E 0 0

	//0 0 1 1 .. 1 0 1 1 ... E found? eCount++ .. W means eCound = 0, scan left to right and right to left
	//0 1 0 0 .. 0 1 0 0
	
	public int maxKilledEnemies(char[][] grid) {
		int eCount=0, max = 0;

		if(grid == null || grid.length == 0 || grid[0].length == 0) {
		    return max;
		}

		int[][] count = new int[grid.length][grid[0].length]; 
		int m = grid.length, n = grid[0].length;
		for(int r=0; r<m; r++) {
		    eCount = 0;
		    for(int c=0; c<n; c++) {
		        if(grid[r][c] == 'E') {
		            eCount++;
		        } else if(grid[r][c] == 'W') {
		            eCount = 0;
		        } else {
		            count[r][c] += eCount;
		        }
		    }

		    eCount = 0;
		    for(int c=n-1; c>=0; c--) {
		        if(grid[r][c] == 'E') {
		            eCount++;
		        } else if(grid[r][c] == 'W') {
		            eCount = 0;
		        } else {
		            count[r][c] += eCount;
		        }
		    }
		}

		for(int c=0; c<n; c++) {
		    eCount = 0;
		    for(int r=0; r<m; r++) {
		        if(grid[r][c] == 'E') {
		            eCount++;
		        } else if(grid[r][c] == 'W') {
		            eCount = 0;
		        } else {
		            count[r][c] += eCount;
		        }
		    }

		    eCount = 0;
		    for(int r=m-1; r>=0; r--) {
		        if(grid[r][c] == 'E') {
		            eCount++;
		        } else if(grid[r][c] == 'W') {
		            eCount = 0;
		        } else {
		            count[r][c] += eCount;
		        }
		    }
		}

		for(int r=0; r<m; r++) {
		    for(int c=0; c<n; c++) {
		        max = Math.max(max, count[r][c]);
		    }
		}

		return max;
	}
	
//	//
//	//1105pm..looks straightforward enough.
//	
//	// TOOK 1h15m still not solved :(
//	
//    //4 while loops in four directions with totalKills outside.
//    //I looked at topics, saw it is a DP question.
//    
//	
//	public int maxKilledEnemies(char[][] grid) {
//        if(grid == null || grid.length == 0 || grid[0].length == 0 || (grid.length == 1 && grid[0].length == 1))    
//	        	return 0;
//        
//        int m = grid.length, n = grid[0].length;
//        int[][] enemiesToTop = new int[m][n];
//        int[][] enemiesToLeft = new int[m][n];
//        
//        for(int i=0; i<grid.length; i++)
//            enemiesToLeft[i][0] = grid[i][0] == 'E' ? 1 : 0;
//        
//        for(int i=0; i<grid.length; i++) {
//            for(int j=1; j<grid[0].length; j++) {
//                enemiesToLeft[i][j] = (grid[i][j] == 'W') ? 0 :
//                                    (grid[i][j] == 'E') ? enemiesToLeft[i][j-1] + 1: 
//                                    	enemiesToLeft[i][j-1];
//            }
//        }
//        
//        for(int j=0; j<grid[0].length; j++)
//            enemiesToTop[0][j] = grid[0][j] == 'E' ? 1 : 0;
//        
//        for(int i=1; i<grid.length; i++) {
//            for(int j=0; j<grid[0].length; j++) {
//                enemiesToTop[i][j] = grid[i][j] == 'W' ? 0 : 
//                                        (grid[i][j] == 'E') ? enemiesToTop[i-1][j] + 1 :
//                                        	enemiesToTop[i-1][j];
//            }
//        }
//        
//
//        int max = 0;
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[0].length; j++) {
//                max = Math.max(max, enemiesToLeft[i][j] + enemiesToTop[i][j]);
//            }
//        }
//        return max;
//    }
	public static void main(String args[]) {
		LC361M_EnemyBomb e = new LC361M_EnemyBomb();
		char[][] grid = {{'0','0','0','0','0','0','0','0','0','0'},{'E','E','E','E','E','E','E','E','E','E'}}; //{{'E','0', 'E'}}; //{{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
		System.out.println(e.maxKilledEnemies(grid));
	}
}
