package leet.array;

public class LC48M_RotateImageRotate2DArrayMatrix {

	/*

	---------------			IMPORTANT          --------------- 

	REMEMBER THIS NEAT AND CLEAN	  <<<  TRANSPOSE-BASED SOLUTION  >>>       FOR THE REST OF YOUR LIFE !!!!!!! 

	*/
	
	public void rotate(int[][] matrix) {
	    print(matrix);
		
		int s = 0, e = matrix.length - 1;
	    while(s < e){
	        int[] temp = matrix[s];
	        matrix[s] = matrix[e];
	        matrix[e] = temp;
	        s++; e--;
	    }
	    
	    int m=matrix.length;
	    int n=matrix[0].length;
	    
	    int[][] newMat = new int[n][m];

	    for(int i=0; i<m; i++) {
	    	for(int j=0; j<n; j++) {
	    		newMat[j][i] = matrix[i][j];	    		
	    	}
	    }
	    System.out.println("------");
	    print(newMat);
	}

	public void print(int[][] newMat) {
		for(int i = 0; i < newMat.length; i++) {
	        for(int j = 0; j < newMat[i].length; j++)
	        	System.out.print(newMat[i][j] + " ");
	        System.out.println();
	    }
	}
	
	
	public static void main(String args[]) {
		LC48M_RotateImageRotate2DArrayMatrix rotate = new LC48M_RotateImageRotate2DArrayMatrix();
		int[][] matrix = 
				 {{1,2,3,4},
				  {5,6,7,8},
				  {9,10,11,12}};
		rotate.rotate(matrix);
	}
	
}
