package leet.array;

import java.util.Arrays;

public class LC280M_WiggleSort {
	   
    //414 pm to 447 pm finished 98/120 test cases
    //Extra space O(n) --> reverse sort and put first and last in there
    //0 1 2 3 4 5
    //1 2 3 4 5 6
    //1 4 2 5 3 6
	
	//
    
    //1 2 3 4 5 6 7
    //1 5 2 6 3 7 4
    
	public void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public void wiggleSort(int[] nums) {
	        Arrays.sort(nums);
            for (int i=0; i<nums.length-1; i += 2)
                swap(nums, i, i+1);
	        
//	        for(int n:nums) {
//	        	System.out.print(n + " ");
//	        }
	        
	   }
    
    public static void main(String args[]) {
    	LC280M_WiggleSort w = new LC280M_WiggleSort();
    	int[] nums = {1,1,1}; //{3, 5, 2, 1, 6, 4};
    	w.wiggleSort(nums);
    }
}
