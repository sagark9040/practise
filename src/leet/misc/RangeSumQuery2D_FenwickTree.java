package leet.misc;

public class RangeSumQuery2D_FenwickTree {

	class NumMatrix{
		//1025pm
	    //Looks simple enough..check for boundaries..if it is outside the boundary
	    //basically my i will will top left 's i to bottom right's i inclusive, same for j
		
		
		/// LOOK AT FENWICK TREE!!
	    
	    int[][] matrix; /// added array[][] should've left without that, since dimensions were missing anyway
	    
	    public NumMatrix(int[][] m) {
	        matrix = m;
	    }
	    
	    public void update(int row, int col, int val) {
	        matrix[row][col] = val;
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        
	        int sum = 0;
	        for(int i=row1; i<=row2; i++) {
	            for(int j=col1; j<=col2; j++) {
	                sum+= matrix[i][j];
	            }
	        }
	        return sum;
	    }
	}
	
	
}