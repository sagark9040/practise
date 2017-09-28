package src.in.gd;

public class FirstElementLargerThanTarget {

	static int largerThanTarget(int[] arr, int target) {
		int numElems = arr.length;
		int low = 0, high = numElems; // numElems is the size of the array i.e arr.size() 
		while (low != high) {
		    int mid = (low + high) / 2; // Or a fancy way to avoid int overflow
		    if (arr[mid] <= target) {
		        /* This index, and everything below it, must not be the first element
		         * greater than what we're looking for because this element is no greater
		         * than the element.
		         */
		        low = mid + 1;
		    }
		    else {
		        /* This element is at least as large as the element, so anything after it can't
		         * be the first element that's at least as large.
		         */
		        high = mid;
		    }
		}
		
		if (low == numElems) {
			System.out.println("No element is larger than the target.");
			return -1;
		}
		
		return arr[low];
	}
	
	public static void main(String args[]) {
		int[] arr = {1,2,2,2,2,2,2,2,3,3,4,7,10,10,11,20,22,25,30};
		System.out.println(largerThanTarget(arr, 10));
	}
	
}
