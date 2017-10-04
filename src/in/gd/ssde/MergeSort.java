package in.gd.ssde;

public class MergeSort {

	static void mergeArrays(int[] a, int[] b) {
		
		int i = 0;
		int j = 0;
		
		while (i < a.length && j < b.length)  {
		
			if(a[i] >= b[j])			
				System.out.print(a[i++]);
			
			else
				System.out.print(b[j++]);				
			
		}

	    while (i < a.length)
	    	System.out.print(a[i++]);
	    
	    while (j < b.length)    
	    	System.out.print(b[j++]);
	    
	}
	
	public static void main(String args[]) {
		
		int[] a = {5,5,5,4,3,2,1};
		int[] b = {10,9,7,5,0};
		
		mergeArrays(a, b);
		
	}
	
}
