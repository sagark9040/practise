package test;

public class MaxStockProfit {

	static int a[] = null; // {10, 50}; // {800, 100, 180, 260, 310, 40, 535, 695, 10, 5};
	
	public static void main(String args[]) {
		
		maximizeStockProfit(a);
		
	}

	private static void maximizeStockProfit(int[] ar) {
		if (null == ar || ar.length < 2)
			return;
		
		int start = 0, end = 0; 
		
		for(int i = 1; i < ar.length; i++) {
			if(ar[i] > ar[i-1]) {
				end = i;
			}
			else {
				print (start, end);
				
				start = i;
			}
				
		}
		
		print(start, end);
	}

	private static void print(int start, int end) {
		
		if(start < end)
			System.out.println("Start: " + start + " End: " + end);		
	}
	
	
}
