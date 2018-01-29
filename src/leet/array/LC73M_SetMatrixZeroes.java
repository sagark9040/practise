package leet.array;

public class LC73M_SetMatrixZeroes {
	
	// 20 mins with testing
	
	//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
	//Basically set the first row and first column to zero and the rest don't bother.
	
	int m=0, n=0;
	boolean firstRowZero = false, firstColZero = false;
	public void setZeroes(int[][] matrix) {
		m = matrix.length; n = matrix[0].length;
		
        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[0].length; j++){
        		if(matrix[i][j] == 0){
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        			
        			if(i == 0 && matrix[i][j] == 0)
        				firstRowZero = true;
        			if(j == 0 && matrix[i][j] == 0)
        				firstColZero = true;
        		}
        	}
        }
        
        for(int i=1; i<matrix.length; i++) {
        	if(matrix[i][0] == 0)
        		matrix = setRowToZero(matrix, i);
        }
        
        for(int j=1; j<matrix[0].length; j++) {
        	if(matrix[0][j] == 0)
        		matrix = setColToZero(matrix, j);
        }
		
        																		// <----------- KEY PART IS HERE .. FIRST ROW AND FIRST COL
        if(firstRowZero)
        	matrix = setRowToZero(matrix, 0);
        if(firstColZero)
        	matrix = setColToZero(matrix, 0);
        
    }

	private int[][] setColToZero(int[][] matrix, int j) {
		for(int i=0; i<m; i++)
			matrix[i][j] = 0;
		return matrix;
	}

	private int[][] setRowToZero(int[][] matrix, int i) {
		for(int j=0; j<n; j++)
			matrix[i][j] = 0;
		return matrix;		
	}
	
	public static void main(String args[]) {
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		LC73M_SetMatrixZeroes set = new LC73M_SetMatrixZeroes();
		set.setZeroes(matrix);
	}
}
