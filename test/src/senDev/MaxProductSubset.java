package senDev;

/*

Input: arr[] = {6, -3, -10, 0, 2}
				6  -18  180 0  2
				
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 20}
				-1   3  -30  0  20


Output:   60  // The subarray is {60}

Input: arr[] = {-2, -3, 0, -2, -40}
				-2   6  0  -2   80


Output:   80  // The subarray is {-2, -40}

 */

public class MaxProductSubset {

	//brute force
	static void maxProductBF(int[] arr) {
		
		int length = arr.length;
		int maxProduct = 0, Product = 0;
		
		for(int i = 0; i < length-1; i++) {
			
			Product = 1;
			
			for (int j = i; j< length; j++) {
				
				Product = Product*arr[j];
				
				if (Product > maxProduct)
					maxProduct = Product;
				
			}
		}
		
		System.out.println(maxProduct);
		
	}
	
	//optimal
	static void maxProductOptimal(int[] arr) {
		
		int currentMaxProduct = arr[0];
		int currentMinProduct = arr[0];
		int prevMaxProduct = arr[0];
		int prevMinProduct = arr[0];
		int maxProduct = arr[0];
		
		System.out.println("i=" + 0 + " val=" + arr[0] + " prevMaxProduct=" + prevMaxProduct + " prevMinProduct="+ prevMinProduct);
		
		for(int i = 1; i < arr.length; i++) {
			currentMaxProduct = Math.max(arr[i], Math.max(arr[i]*prevMaxProduct, arr[i]*prevMinProduct));
			currentMinProduct = Math.min(arr[i], Math.min(arr[i]*prevMaxProduct, arr[i]*prevMinProduct));
			
			maxProduct = Math.max(currentMaxProduct, maxProduct);
			
			prevMaxProduct = currentMaxProduct;
			prevMinProduct = currentMinProduct;
			
			System.out.println("\ni=" + i + " val=" + arr[i]);
			System.out.println("maxProduct="+maxProduct+ " prevMaxProduct=" + prevMaxProduct + " prevMinProduct="+ prevMinProduct);
			
		}
		
		System.out.println(maxProduct);
		
	}
	
	public static void main(String args[]) {
		
		int arr[] = {100, 0, -4, -1, -3, -10, 0, 20};
		//maxProductBF(arr);
		maxProductOptimal(arr);
		
	}
	
}
