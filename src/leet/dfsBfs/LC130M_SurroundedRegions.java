package leet.dfsBfs;

import java.util.HashMap;
import java.util.Map;

public class LC130M_SurroundedRegions {
	
	//205pm --> 318pm after debugging 10/50 TCs
    //Do a DFS from the edges (similar to Atlantic Pacific water problem), all the 0s in it's DFS path are not gonna be captured
    //Problem points were the edge zeroes
    //Unnecessarily used the visited since it was not needed apparently
    //Used a map like a fool instead of marking the Os in a better way.
   
    Map<Integer, Integer> finalZeroes = new HashMap<Integer, Integer>();
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }  
        
    	int m = board.length, n = board[0].length;
    	boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
    		if (board[i][0] == 'O') {
    			visited = new boolean[m][n];
    			dfs(i, 0, visited, board);
    		}
    		if (board[i][n-1] == 'O') {
    			visited = new boolean[m][n];
    			dfs(i, n-1, visited, board);	
    		}
    	}
    	//Start from first and last row, turn '0' to '*'
    	for (int j = 0; j < n; j++) {
    		if (board[0][j] == 'O') {
    			visited = new boolean[m][n];
    			dfs(0, j, visited, board);
    		}
    		if (board[m-1][j] == 'O') {
    			visited = new boolean[m][n];
    			dfs(m-1, j, visited, board);	    			
    		}
    	}
        
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (board[i][j] == 'O')
    				board[i][j] = 'X';
    			else if (board[i][j] == '*')
    				board[i][j] = 'O';
    		}
    	}
        System.out.println("ji");
    }
    
    int[][] getZeroesOnTheEdge(char[][] board) {
        int[][] edges = new int[board.length * 2 + board[0].length * 2][2];
        
        int pos = 0;
        for(int i=0; i<board.length; i++) {
            if(board[0][i] == 'O') {
                edges[pos++] = new int[]{0, i};            
            }
            if(board[board.length-1][i] == 'O') {
                edges[pos++] = new int[]{board.length-1, i};            
            }
        }
        for(int j=0; j<board[0].length; j++) {
            if(board[0][j] == 'O') {
                edges[pos++] = new int[]{0, j};
            }
            if(board[board.length-1][j] == 'O') {
                edges[pos++] = new int[]{board.length-1,j};
            }            
        }
        return edges;
    }
    
    public void dfs(int r, int c, boolean[][] visited, char[][] board) {
        if(r < 0 || c < 0 || r >= visited.length || c >= visited[0].length || board[r][c] != 'O' || visited[r][c]) {
            return;
        }
        
        finalZeroes.put(r, c);
        visited[r][c] = true;
        if (board[r][c] == 'O')
    		board[r][c] = '*';
        dfs(r-1, c, visited, board);
        dfs(r+1, c, visited, board);
        dfs(r, c+1, visited, board);
        dfs(r, c-1, visited, board);
        visited[r][c] = false;
    }
    
    public static void main(String args[]) {
    	char[][] board =  {{'O','O'},{'O','O'}};
    	
//    	{{'X','O','X','O','X','O'},
//    					  {'O','X','O','X','O','X'},
//    					  {'X','O','X','O','X','O'},
//    					  {'O','X','O','X','O','X'}};
    		
//    		{  {'X','X','X','X'},
//    						{'X','O','O','X'},
//    						{'X','X','O','X'},
//    						{'X','O','X','X'}};    	
    	LC130M_SurroundedRegions sr = new LC130M_SurroundedRegions();
    	sr.solve(board);
    }
}
