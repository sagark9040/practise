package leet.array;

public class LC48M_RotateImageRotate2DArrayMatrix {

	// You are given an n x n 2D matrix representing an image.
	/*
	Given input matrix = 
			[
			  [1,2,3],
			  [4,5,6],
			  [7,8,9]
			],

			rotate the input matrix in-place such that it becomes:
			[
			  [7,4,1],
			  [8,5,2],
			  [9,6,3]
			]
			
			
			
			
			Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
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
