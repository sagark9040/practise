package leet.array;

/*
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
*/

public class GameOfLife {	
	int[][] origBoard;
	
	public void gameOfLife(int[][] board) {	
		origBoard = board;
		print (origBoard);
				
		// Empty board test case
		if(board.length < 1)
			return;
		
        for(int r = 0; r < board.length; r++) {
        	for(int c = 0; c < board[0].length; c++) {        		
        		int sum = getValidNeighbors(board, r, c);
		        if(sum < 2)
		        	board[r][c] = 0;
		        else if (sum >=2 && sum <=3 && board[r][c] == 1)
		        	board[r][c] = 1;
		        else if (sum > 3)
		        	board[r][c] = 0;
		        else if (sum == 3)
		        	board[r][c] = 1;
        	}        	
        }
        
        print(board);
        
    }

	private int getValidNeighbors(int[][] board, int r, int c) {
//		System.out.println("---------------- " + r + "/" + c + " ----------------");
		
		int sum = 0;
		
		sum -= board[r][c];
		
		for(int i=-1; i<=1; i++) {
			for(int j=-1; j<=1; j++) {
				
				if ( ((r+i) >= 0) && ((c+j) >= 0) && ((r+i) < board.length) && ((c+j) < board[0].length)) {
					sum += board[r+i][c+j];					
				}				
			}			
		}
//		System.out.println("sum:" + sum);
		return sum;
	}
	
	public void print (int[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		GameOfLife game = new GameOfLife();
		game.gameOfLife(new int[][]{{1,1},{1,0}});
	}
}
