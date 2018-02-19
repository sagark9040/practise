package leet.dfsBfs;

public class LC79M_WordSearch {
	//1235pm --> 0110 pm = 35 mins ... 82/87 TCs ... but then -
    //0110 pm --> 152 pm = 40 mins to solve the issue of backtracking
	
	//[
	//   ['A','B','C','E'],
	//   ['S','F','C','S'],
	//   ['A','D','E','E']
	// ]
	// word = "ABCCED", -> returns true,
	// word = "SEE", -> returns true,
	// word = "ABCB", -> returns false.
	    
	    //loop alphabet 0,0 to m-1, n-1
	        //for every alphabet that matches first, start with an empty visited array
	        //do dfs..if true then return it
	    //ultimately return false
	    
	    //
	    
	    public boolean exist(char[][] board, String word) {
		        if(board == null || board.length == 0 || word == null || word.length() == 0) {
		            return false;
		        }
		        
		        char[] wordArray = word.toCharArray();
		        
		        char firstChar = wordArray[0];
		        for(int r=0; r<board.length; r++) {
		            for(int c=0; c<board[0].length; c++) {
		                if(board[r][c] == firstChar) {
		                    boolean[][] visited = new boolean[board.length][board[0].length];
		                    if(firstChar == board[r][c] && dfs(board, wordArray, r, c, 0, new char[word.length()], visited)) {
		                    	return true;
		                    }
		                }                
		            }
		        }        
		        return wordFound;
		    }
		    
		 boolean wordFound = false;
		    //0-> A
		    //1-> B
		    public int[][] neighbors() {
		        return new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
		    }
		    
		    
		    public boolean dfs(char[][] board, char[] word, int r, int c, int pos, char[] cur, boolean[][] visited) {
		    	if(wordFound || pos == word.length) {
		    		return true;
		    	}

		        visited[r][c] = true;				/// 									I M P O R T A N T !!!!!!!!!!!!!!!!
		        cur[pos] = board[r][c];
		        for(int[] n:neighbors()) {
		            int newRow = r+n[0], newCol = c+n[1];

		           																			//KEY FOR AVOIDING ARRAY INDEX OUT OF BOUNDS
		            if(wordFound || pos == word.length-1) {
			    		return true;
			    	}
		            if(isValid(newRow, newCol, board) && !visited[newRow][newCol] && board[newRow][newCol] == word[pos+1]) {
		            	if(dfs(board, word, newRow, newCol, pos+1, cur, visited)) {
		            		return true;
		            	}
		            }
	                
		        }
		        visited[r][c] = false;              // backtracking			///			 	I M P O R T A N T !!!!!!!!!!!!!!!!
		        return false;
		    }
		    
		    public boolean isValid(int r, int c, char[][] board) {
		        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
		            return false;
		        }
		        return true;
		    }  
	    
	    public static void main(String args[]) {
	    	LC79M_WordSearch w = new LC79M_WordSearch();
	    	char[][] board = 
	    	{{'A','B','C','E'},
			 {'S','F','E','S'},
			 {'A','D','E','E'}};
	    	
//	    		{
//	    						{'A','B','C','E'},
//								{'S','F','C','S'},
//								{'A','D','E','E'}
//	    					 };
	    	String word = "ABCESEEEFS"; // "ABCB";
	    	System.out.println(w.exist(board, word));
	    }
}
