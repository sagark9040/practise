package leet.array;

import java.util.ArrayList;
import java.util.List;

public class INCOMPLETE_LC54M_SpiralMatrix {
	 //Qs:
    //1. Square matrix or rectangular? ---> either
    //
    
    //TCs
    //1. Empty matrix
    //2. One element
    //3. MxM matrix
    //4. M!=N
    
    //1st row, last column in serial...last row , first column ulta
    //2nd row, 2nd last column in serial...second last row, second column ulta
    
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) //no rows
            return new ArrayList<Integer>();

        int col = matrix.length;
        int row = matrix[0].length;        
        
        /*
        1 2 3 4
        8 7 6 5  2x4 ---  123 4 567 8 
        */
        
        /*
        1  2  3  4
        10 11 12 5                  0   3  3   0   1  1
        9  8  7  6        3 x 4 --- 123 45 678 910 11 12
        */
        int c=0, r=0;
        while(c<col && r<row){            
            printTopRow(c, c, col-2);
            printRightCol(row-1, r, row-2);
            printBottomRow(col-1, col-1, c);
            printLeftCol(c, row-1, r);
            
            c++;
        }
		return null;
    }

	private void printLeftCol(int c, int i, int r) {
		// TODO Auto-generated method stub
		
	}

	private void printBottomRow(int i, int j, int c) {
		// TODO Auto-generated method stub
		
	}

	private void printRightCol(int i, int r, int j) {
		// TODO Auto-generated method stub
		
	}

	private void printTopRow(int c, int c2, int i) {
		// TODO Auto-generated method stub
		
	}
}
