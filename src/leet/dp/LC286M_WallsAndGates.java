package leet.dp;

public class LC286M_WallsAndGates {

	//1014 - 16 min AC .. SLEEK!!!!!!
    
    //Questions: more gates or more walls? or can't say
    //I know all the gates = 0
    //do a BFS on 4 sides if sides are not -1 and old value is lower than new value.
    //increment the value of the side if it is less than the old value
    
    public void wallsAndGates(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == 0) {
                    dfs(grid, r, c, 0);
                }                
            }
        }
    }
    
    public void dfs(int[][] grid, int row, int col, int value) {
        if(!isValid(row, col, grid) || grid[row][col] < value) {
            return;
        } else {
            grid[row][col] = value;
        }

        //4 sides
        dfs(grid, row+1, col, value+1);
        dfs(grid, row, col+1, value+1);
        dfs(grid, row-1, col, value+1);
        dfs(grid, row, col-1, value+1);
    }
    
    public boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;        
    }
	
    // 		O L D  	 	C O D E
	
	/*
    int[][] rooms;
    boolean[][] visited;
    public void wallsAndGates(int[][] r) {
        rooms = r;
        if(rooms == null || rooms.length == 0) {
            return;
        }        
        visited = new boolean[r.length][r[0].length];
        Queue<int[]> doors = getDoors(rooms);
        dfs(doors); 
        System.out.println();
    }
    
    void dfs(Queue<int[]> doors) {
        while(!doors.isEmpty()) {
            int[] cur = doors.poll();
            dfsUtil(cur, 0);
        }
        
    }
    
    void dfsUtil(int[] cur, int level) {
        if(!visited[cur[0]][cur[1]] && rooms[cur[0]][cur[1]] != -1) {
            visited[cur[0]][cur[1]] = true;
            
            if(rooms[cur[0]][cur[1]] != 0) {
            	rooms[cur[0]][cur[1]] = Math.min(rooms[cur[0]][cur[1]], level);
            }
            
            for(int[] neighbor:getNeighbors(cur)) {
                dfsUtil(neighbor, level+1);
            }
        }
    }
    
    int[][] getNeighbors(int[] cur) {
        int r = cur[0], c = cur[1];
        int[][] neighbors = new int[4][4];
        int pos = 0;
        int[][] movess = {{-1,0},{1,0},{0,1},{0,-1}};
        for(int[] moves:movess) {
            if(moves[0]+r >= 0 && moves[0]+r < rooms.length && moves[1]+c >= 0 && moves[1]+c < rooms.length) {
                int[] newCell = {moves[0]+r, moves[1]+c};
                neighbors[pos] = newCell;
                pos++;
            }
        }  
        return neighbors;
    }
    
    Queue<int[]> getDoors(int[][] rooms) {
        Queue<int[]> roomsQueue = new LinkedList<int[]>();
        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    roomsQueue.add(new int[]{i, j});
                }
            }
        }
        return roomsQueue;
    }
    */
    
    public static void main(String args[]) {
    	int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},
    	                 {2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
    	LC286M_WallsAndGates w = new LC286M_WallsAndGates();
    	w.wallsAndGates(rooms);
    }
}
