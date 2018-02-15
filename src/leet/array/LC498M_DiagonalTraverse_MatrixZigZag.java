package leet.array;

public class LC498M_DiagonalTraverse_MatrixZigZag {
	public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[]{};
        }
        
        
        int rows = matrix.length, cols = matrix[0].length;
        int pos = 0;
        int[] elems = new int[rows*cols];
        
        for(int sum=0; sum<=rows+cols-2; sum++) {            
            if(sum%2==0) {
                for(int r=sum; r>=0; r--) {
                    if(validCell(matrix, r, sum-r)) {
                    	elems[pos++] = matrix[r][sum-r];
                    }
                }    
            } else {
                for(int c=sum; c>=0; c--) {
                	if(validCell(matrix, sum-c, c)) {
                		elems[pos++] = matrix[sum-c][c];
                	}
                }
            }            
        }
        return elems;
    }
	
	private static boolean validCell(int[][] matrix, int r, int c) {
		if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) {
			return false;
		}
		
		return true;
	}

	public static void main(String args[]) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i:findDiagonalOrder(mat))
			System.out.print(i + " ");
	}
}
