package in.gd.senDev;

//Given an array like [-1, 2, 3, 5, 4, 6] and it should print the 3 that is order of the array is equal to array element
public class Array {

	//Questions:
	//Is the array sorted? If so use binary search
	
	//Method 1: O(n) complexity
	public static int straightCheck(int arr[]) {
		
		for (int i=0; i<arr.length; i++)
			if (arr[i]==(i+1))
				return arr[i];
		
		return -1;
	}
	
	public static void main(String args[]) {
		
		int arr[]={-1, 2, 3, 5, 4, 6};
		
		System.out.println("O(n) complexity:" + straightCheck(arr));
		
	}
	
}
