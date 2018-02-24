package leet.array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC378M_KthSmallest {
	//527pm-40mins AC
	   //top left = smallest
	   //bottom elem is larger and right element is larger
	   //if k == 1 then [0][0]
	   //BF: add all elements to an array ... sort it and get the kth smallest 
	    
	    
	   // 
	   // [ 1, 15, 29],
	   // [10, 16, 33],
	   // [12, 17, 35]
	   
	//visited[][] and do a BFS from smallest to biggest and add them to an array of K element
	//
//	                 1 
//	        10              15
//	     12    16        16    29
//	      17  17 33    17 33  33 
//	              35       35  35 
	          
		    public int kthSmallest(int[][] matrix, int k) {
		        if(matrix.length == 0) {
		            return 0;
		        }
		        
		        int m = matrix.length, n = matrix[0].length;
		        boolean[][] visited = new boolean[m][n];        
		        Queue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());

		        bfs(matrix, pq, visited, 0, 0, k);
		        return pq.poll();
		    }

			void bfs(int[][] matrix, Queue<Integer> pq, boolean visited[][], int i, int j, int maxCap) {
		        if(isValid(matrix, i, j) && !visited[i][j]) {
		            if(pq.size() == maxCap) {
		            	int curHead = pq.peek();
		            	if(curHead > matrix[i][j]) {
		            		pq.poll();
		            		pq.offer(matrix[i][j]);
		            	}	            	
		            } else {
		            	pq.offer(matrix[i][j]);
		            }
		            visited[i][j] = true;
		            
		            bfs(matrix, pq, visited, i+1, j, maxCap);
		            bfs(matrix, pq, visited, i, j+1, maxCap);
		        }
		    }    
		    
		    boolean isValid(int[][] matrix, int i, int j) {
		        return i>=0 && j>=0 && i<matrix.length && j<matrix[0].length;
		    }
	    
	    public static void main(String args[]) {
	    	int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
	    	LC378M_KthSmallest kth = new LC378M_KthSmallest();
	    	System.out.println(kth.kthSmallest(matrix, 1));
	    	System.out.println(kth.kthSmallest(matrix, 2));
	    	System.out.println(kth.kthSmallest(matrix, 3));
	    	System.out.println(kth.kthSmallest(matrix, 4));
	    	System.out.println(kth.kthSmallest(matrix, 5));
	    	System.out.println(kth.kthSmallest(matrix, 6));
	    	System.out.println(kth.kthSmallest(matrix, 7));
	    	System.out.println(kth.kthSmallest(matrix, 8));
	    }
}
