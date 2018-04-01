package leet.dfsBfs;

public class LC419M_BattleshipsInABoard {
	//7 pm
    // for all X points, do a dfs if neighbor is X
    // use the board and mark visited as .
    
    //Test Cases
    //0 elements
    //1 element
    //1 row, 1 col
    //
    
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int r=0; r<board.length; r++) {
            for(int c=0; c<board[0].length; c++) {
                if(board[r][c] == 'X') {
                    dfs(board, r, c);
                    count++;
                }
            }            
        }
        return count;
    }
    
    public void dfs(char[][] board, int r, int c) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '.') {
            return;
        }
        
        board[r][c] = '.';        
        dfs(board, r+1, c);
        dfs(board, r, c+1);
        dfs(board, r-1, c);
        dfs(board, r, c-1);
    }
}
