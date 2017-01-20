package test;

/*
 
	Given a 2D array of digits, try to find the occurrence of a given 2D pattern of digits. For example, consider the following 2D matrix: 
	
	
	Assume we need to look for the following 2D pattern: 
	
	950 
	384 
	353

 	TC: All the same integers.
 	TC: All the same, with the last different and the last matches the size of the matrix.
 	TC: Pattern empty
 	TC: Pattern larger than orig arr
 	TC:
 
 */

public class Find2DArray {

	int origRow = 0, origCol = 0, pattRow = 0, pattCol = 0, comparisons = 0, outerComparisons = 0;
	int[][] orig, patt;
	
	public boolean find2DPattern(int[][] orig, int[][] patt) {
		
		this.orig = orig;
		this.patt = patt;
		origRow = orig.length; 
		pattRow = patt.length;
		origCol = orig[0].length; 
		pattCol = patt[0].length;
		
		for(int i = 0; i < origRow; i++) {
			for(int j = 0; j < origCol; j++) {outerComparisons++;
				if (orig[i][j] == patt[0][0]) { //first elem of pattern matches
					
					
					
					int match = matchRest(i,j);
					if (match == -1)
						return true;
					else
						j = match;
				}
			}
		}
		
		return false;
	}	
	
	private int matchRest(int i, int j) {

		int pattRowItr = 0, pattColItr = 0, nextCol = j+1;
		
		for(int row = i; row < origRow && pattRowItr < pattRow; row ++) {
			
			pattColItr = 0;			
			
			for(int col = j; col < origCol && pattColItr < pattCol; col++) {
				int origElem = orig[row][col];
				int pattElem = patt[pattRowItr][pattColItr];
				
				if(col > nextCol)
					nextCol = col;
				
				comparisons++;
				
				if (origElem != pattElem)
					return nextCol;
				
				pattColItr++;
			}
			
			pattRowItr++;
		}
		
		if ((pattColItr == pattCol && pattRowItr == pattRow))			
			return -1;
		
		return nextCol;
	}
	
	public static void main(String args[]) {
		Find2DArray a = new Find2DArray();
		
		int[][] o = {
				{7,2,8,3,4,5,5,8,6,4},
				{6,7,3,1,1,5,8,6,1,9},
				{8,9,8,8,2,4,2,6,4,3},
				{3,8,3,9,5,0,5,3,2,4},
				{9,5,0,9,5,0,5,8,1,3},
				{3,8,4,3,8,4,5,3,8,4},
				{6,4,7,3,5,3,0,2,9,3},
				{7,0,5,3,1,0,6,6,0,1},
				{0,8,3,4,2,8,2,9,5,6},
				{4,6,0,7,9,2,4,1,3,7}};
		
		
		int[][] p = {{9,5,0}, 
					{3,8,4}, 
					{3,5,3}};
		System.out.println(a.find2DPattern(o, p));
		System.out.println("Comparisons: " + a.comparisons + " Outer Comparisons: " + a.outerComparisons);
	}


	public void setCustomerServiceStatus(boolean customerServiceStatus) {
		this.customerServiceStatus = customerServiceStatus;
	}
	public boolean isEmailServiceStatus() {
		return emailServiceStatus;
	}
	
	/*
	 * IMPORTANT:
	 * These boolean values represent the running statuses of the email and the customer services.
	 * They should ideally ALWAYS be true unless stated by the other teams to kill them, i.e. turn the value to false. 
	 */
	
	private boolean customerServiceStatus = true;
	private boolean emailServiceStatus = true;
	
	public boolean isCustomerServiceStatus() {
		return customerServiceStatus;
	}
	
	/**
     * All the examples of the customer search API can be found here
     * @return
     */
    
     public String customerAPI() {
                     return "customer";
     }
    
     /**
     * All the examples of the email/opt status lookup API can be found here
     * @return
     */
     
     public String optStatusAPI() {
                     return "email";
     }
}
