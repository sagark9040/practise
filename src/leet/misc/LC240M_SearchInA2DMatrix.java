package leet.misc;

public class LC240M_SearchInA2DMatrix {
	
	// NOTES: SOLVED THIS PROBLEM FROM CTCI MANY YEARS AGO. SO THIS WAS EASY. PLEASE BE CAREFUL OF THE BOUNDARIES!!!!
	
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
	 		return false;
        int i=0, j=matrix[0].length-1;
        
        while(i<matrix.length && j>=0) {
        	System.out.println(matrix[i][j]);
        	
            if(matrix[i][j] == target)          
                return true;
            else if(matrix[i][j] > target)      	//		<--- BE CAREFUL
                j--;
            else
                i++;								//		<--- BE CAREFUL
        }
        
        return false;
	}
	 
	public static void main(String args[]) {
		int[][] a = {
		              {1,   4,  7, 11, 15},
		              {2,   5,  8, 12, 19},
		              {3,   6,  9, 16, 22},
		              {10, 13, 14, 17, 24},
		              {18, 21, 23, 26, 30}
					};
		System.out.println(searchMatrix(a, 5));
		
	}	 
}
