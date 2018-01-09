package leet.array;

public class GameOfLife {

	 int[][] origBoard;
	    public void gameOfLife(int[][] board) {
	    	
	    	print(board);
	    	
	        origBoard = board;
	        
	        // Empty board
	        if(board.length == 0) {
	            return;  
	        }
	        
	        // Iterate every single element and check if the rules apply to each one and change accordingly
	        
	        //all rows
	        for(int r=0; r<board.length; r++) {
	            
	            //all columns
	            for(int c=0; c<board[0].length; c++) {
	             
	                board[r][c] = getNewValue(r, c);
	                
	            }                        
	        }   
	        
	        print(board);
	        print(new int[][]{{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0}});
	    }
	    
	    private void print(int[][] board) {
	    	System.out.println("-------");
	    	
	    	for(int i=0; i<board.length; i++) {
	    		for(int j=0; j<board[0].length; j++)
	    			System.out.print(board[i][j]);
	    		
	    		System.out.println();
	    	}
	    	
	    }

		public int getNewValue(int r, int c) {
	        int sumOfNeig = 0;
	        for(int rowShift=-1; rowShift<=1; rowShift++) {
	            for(int colShift=-1; colShift<=1; colShift++) {
	                
	                // Check valid columns
	                if(validCell(r+rowShift, c+colShift)) {
	                    sumOfNeig += origBoard[r+rowShift][c+colShift];    
	                }                
	            }
	        }
	        
	        sumOfNeig -= origBoard[r][c];
	                
	        return applyRules(sumOfNeig, origBoard[r][c]);
	    }
	    
	    public int applyRules(int sum, int origVal) {
	        if(sum <2)
	            return 0;
	        else if (sum == 2)
	            return origVal;
	        else if (sum == 3)
	            return 1;
	        
	        return 0;            
	    }
	    
	    public boolean validCell(int row, int col) {
	        if(row >=0 && row < origBoard.length && col >=0 && col < origBoard[0].length)
	            return true;
	        return false;
	    }
    
    public static void main(String args[]) {
    	int[][] inp = {{1,1},{1,0}};
    	
    	inp = new int[][]{{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
    	GameOfLife game = new GameOfLife();
    	game.gameOfLife(inp);
    }
	
}
