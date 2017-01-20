package test;

public class FindElementInSortedMatrix {
	public static void findInMatrix (int[][] mat, int search) {

		//Calculate length of rows and columns.
		int rowLen = mat.length;
		int colLen = mat[0].length;

		//Empty matrix test
		if (rowLen == 0 && colLen == 0) {
			System.out.println ("Empty matrix.");
			return;
		}

		//Iterators for row and column respectively.
		int r = 0;
		int c = colLen-1;

		while (r >= 0 && r < rowLen && c >= 0 && c < colLen) {
			if( mat[r][c] == search) {
				System.out.println ("Element found at row="+ r +" col=" +c);
				return;
			}

			// We can safely rule out the key to left of where we are.
			// So we move one row down, the same column
			else if (mat[r][c] < search) {
				r++;
			}

			// We rule out the key
			else {
				c--;
			}
		}
		System.out.println ("Element not found");
	}
	
	public static void main (String args[]) {
		int[][] a = {{0,0,0,1,12},{0,0,1,2,13},{0,1,1,3,14},{0,1,3,4,15},{11,12,13,14,15}};
		findInMatrix(a,3);
		
		int[][] b = {{0,0,0,12},{15,50,100,200},{16,51,101,201}};
		findInMatrix(b,3);
		findInMatrix(b,15);
		
		int[][] c = {{15,20,40,85},{20,35,80,95},{30,55,95,105},{40,80,100,120}};
		findInMatrix(c,55);
	}
	
}
