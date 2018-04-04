package leet.array;

import java.util.ArrayList;
import java.util.List;

public class LC54M_SpiralMatrix {
	
	// Looked up the sleek solution from LC Discuss. 
	// The main point was about the decision making as to when to start and stop with the printing.
	// The concept of updating boundaries every time is very neat.
	// Special cases are where there are only one rows or columns. That's why the check in the two if blocks.
	
	public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        
        
    	int topRow = 0, rightCol = matrix[0].length-1, bottomRow = matrix.length-1, leftCol = 0;
    	List<Integer> result = new ArrayList<Integer>();
    	while(topRow <= bottomRow && leftCol <= rightCol) {

    	    
    	    for(int c=leftCol; c<=rightCol; c++) {
    	    	result.add(matrix[topRow][c]);    	     
    	    }
    	    topRow++;

    	    for(int r=topRow; r<=bottomRow; r++) {
    	    	result.add(matrix[r][rightCol]);
    	    }
    	    rightCol--;
    	    
    	    if(bottomRow >= topRow) {
	    	    for(int c=rightCol; c>=leftCol; c--) {
	    	    	result.add(matrix[bottomRow][c]);
	    	    }
    	    }
    	    bottomRow--;

    	    if(leftCol <= rightCol) {
	    	    for(int r=bottomRow; r>=topRow; r--) {
	    	    	result.add(matrix[r][leftCol]);
	    	    }
    	    }
    	    leftCol++;

    	}
    	//You should return [1,2,3,6,9,8,7,4,5].

    	return result;
    }
    public static void main(String args[]) {
    	int[][] matrix = {{1,2},{3,4}};
						 //{{1,2,3},{4,5,6},{7,8,9}}; 
    					 //{{1,2,3,4,5},{10,9,8,7,6}};
    	LC54M_SpiralMatrix m = new LC54M_SpiralMatrix();
    	m.spiralOrder(matrix);
    }
}
