package leet.dp;

public class INCOMPLETE_EnemyBomb {
	
	//
	//1105pm..looks straightforward enough.
	
	// TOOK 1h15m still not solved :(
	
    //4 while loops in four directions with totalKills outside.
    //I looked at topics, saw it is a DP question.
    
	
	public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 || (grid.length == 1 && grid[0].length == 1))    
	        	return 0;
        
        int m = grid.length, n = grid[0].length;
        int[][] enemiesToTop = new int[m][n];
        int[][] enemiesToLeft = new int[m][n];
        
        for(int i=0; i<grid.length; i++)
            enemiesToLeft[i][0] = grid[i][0] == 'E' ? 1 : 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=1; j<grid[0].length; j++) {
                enemiesToLeft[i][j] = (grid[i][j] == 'W') ? 0 :
                                    (grid[i][j] == 'E') ? enemiesToLeft[i][j-1] + 1: 
                                    	enemiesToLeft[i][j-1];
            }
        }
        
        for(int j=0; j<grid[0].length; j++)
            enemiesToTop[0][j] = grid[0][j] == 'E' ? 1 : 0;
        
        for(int i=1; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                enemiesToTop[i][j] = grid[i][j] == 'W' ? 0 : 
                                        (grid[i][j] == 'E') ? enemiesToTop[i-1][j] + 1 :
                                        	enemiesToTop[i-1][j];
            }
        }
        

        int max = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                max = Math.max(max, enemiesToLeft[i][j] + enemiesToTop[i][j]);
            }
        }
        return max;
    }
	public static void main(String args[]) {
		INCOMPLETE_EnemyBomb e = new INCOMPLETE_EnemyBomb();
		char[][] grid = {{'0','E'}};//{{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
		System.out.println(e.maxKilledEnemies(grid));
	}
}
