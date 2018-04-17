package leet.dp;

public class LC764M_LargestPlusSign {

	int largest = 0;    int size = 0;
    
    public int[][] initGrid(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                grid[r][c] = 1;
            }
        }
        
        for(int[] mine:mines){
            grid[mine[0]][mine[1]] = 0;
        }
        return grid;
    }
    
    public void bfs(int r, int c, int N, int count, int[][] grid) {
        int[] left = {r, c-1};
        int[] right = {r, c+1};
        int[] up = {r-1, c};
        int[] down = {r+1, c};
        size = grid.length;
        
        while(isOne(left, grid) && isOne(up, grid) && isOne(right, grid) && isOne(down, grid)) {
            count++;
            
            left[1]--;
            right[1]++;
            up[0]--;
            down[0]++;
        }
        
        largest = Math.max(largest, count);
    }
    
    public boolean isValid(int r, int c, int N) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
    
    public boolean isOne(int[] point, int[][] grid) {
        return isValid(point[0], point[1], size) && grid[point[0]][point[1]] == 1;
    }
    
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        
        if(N == 0) {
            return 0;
        }
        
        int[][] grid = initGrid(N, mines);
        
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(grid[r][c] == 1) {
                    bfs(r, c, N, 1, grid);                    
                }                    
            }            
        }
        
        return largest;
    }
	
	public static void main(String args[]) {
		int N = 2;
		int[][] mines = {};
		
		LC764M_LargestPlusSign lps = new LC764M_LargestPlusSign();
		System.out.println(lps.orderOfLargestPlusSign(N, mines));
	}
}
