package leet.array;

public class LC794M_ValidTicTacToe {
	public boolean validTicTacToe(String[] board) {
		int countX = 0;
		int countO = 0;
		boolean foundHorizontalX = false;
		boolean foundHorizontalO = false;

		for(int i=0; i<3; i++) {
			if(board[i].equals("XXX"))	foundHorizontalX = true;
			if(board[i].equals("OOO"))	foundHorizontalO = true;

			for(char c:board[i].toCharArray()) {
				if(c == 'X')	countX++;
				if(c == 'O')	countO++;
			}
		}

		if(countX - countO < 0 || countX - countO > 1)
			return false; 	
		if(foundHorizontalX && foundHorizontalO)
			return false;
		if(foundVertical('X', board) && foundVertical('O', board))
			return false;
		if((foundVertical('X', board) || foundHorizontalX) && countX == countO)
			return false;
		if(foundDiagonal('O', board) && 
				countX != countO)
			return false;
		if(foundDiagonal('X', board) && 
				countX != countO+1)
			return false;
		
		return true;	
	}	

	private boolean foundDiagonal(char c, String[] board) {
		int countLeft = 0, countRight = 0;
		for(int i=0; i<3; i++) {
			if(board[i].charAt(i) == c)	countLeft++;			
		}
		
		for(int i=0; i<3; i++) {
			if(board[i].charAt(2-i) == c) countRight++;
		}
		
		return countLeft == 3 || countRight == 3;
	}

	public boolean foundVertical(char ch, String[] board) {
		
		for(int c=0; c<3; c++) {
			int count = 0;

			for(int r=0; r<3; r++) {
				if(board[r].charAt(c) == ch)	count++;
			}

			if(count == 3)
				return true;
		}	

		return false;
	}
	
	public static void main(String args[]) {
		String[] board = {"OXX","XOX","OXO"};
		LC794M_ValidTicTacToe v = new LC794M_ValidTicTacToe();
		System.out.println(v.validTicTacToe(board));
		
		
	}
	/*
"OXX",
"XOX",
"OXO"
	 */

}
