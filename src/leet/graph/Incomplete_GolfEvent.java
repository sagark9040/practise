package leet.graph;

import java.util.List;
import java.util.PriorityQueue;

public class Incomplete_GolfEvent {

	int[][] neighbors = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
	boolean[][] visited;
	
    public int cutOffTree(int[][] matrix) {
        //int[][] matrix = fillMatrix (forest);    
        visited = new boolean[matrix.length][matrix[0].length];
        int steps = 0;
        
        PriorityQueue<int[]> neighTrees = getNeighboringTrees(matrix, 0, 0);
        visited[0][0] = true; // mark trees already cut as visited.
        
        while(!neighTrees.isEmpty()) {
        	int[] curTree = neighTrees.poll();
        	visited[curTree[0]][curTree[1]] = true;
        	steps++;
        	
        	neighTrees.addAll(getNeighboringTrees(matrix, curTree[0], curTree[1]));
        }
        
        return checkUncutTrees(visited, matrix) ? -1 : steps;
    }
    
    private boolean checkUncutTrees(boolean[][] visited2, int[][] matrix) {

    	for(int i=0; i<matrix.length; i++) {
    		for(int j=0; j<matrix[0].length; j++)
    			if(!visited[i][j] && matrix[i][j] > 1) // Not visited trees
    				return false;
    	}
    	
		return true;
	}

	public PriorityQueue<int[]> getNeighboringTrees(int[][] matrix, int r, int c) {
        PriorityQueue<int[]> minHeap=new PriorityQueue<int[]>();
        
        for(int[] neigh: neighbors) {
        	int newRow = r+neigh[0];
        	int newCol = r+neigh[1];
            if(newRow >= 0 && newRow < matrix.length && newCol >=0 && newCol < matrix[0].length && !visited[newRow][newCol])
            	minHeap.add(new int[]{newRow, newCol});
        }
        
        return minHeap;
    }
    
    public int[][] fillMatrix(List<List<Integer>> forest) {
        int[][] matrix = new int[forest.size()][forest.get(0).size()];
        int i=0;
        
        for(List<Integer> row: forest) {
            int j=0;            
            for(Object val: row.toArray()) {
                matrix[i][j] = (int) val;
                j++;
            }       
            i++;
        }
        return matrix;
    }
	
    public static void main(String args[]) {
    	int[][] forest = {{1,2,3},{0,0,4},{7,6,5}};
    	Incomplete_GolfEvent golf = new Incomplete_GolfEvent();
    	System.out.println(golf.cutOffTree(forest));
    }
}
