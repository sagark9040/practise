package leet.array;

import java.util.Arrays;

public class INCOMPLETE_WiggleSort {
	   
    //414 pm to 447 pm finished 98/120 test cases
    //Extra space O(n) --> reverse sort and put first and last in there
    //0 1 2 3 4 5
    //1 2 3 4 5 6
    //1 4 2 5 3 6
	
	//
    
    //1 2 3 4 5 6 7
    //1 5 2 6 3 7 4
    
	   public void wiggleSort(int[] nums) {
	        if(nums == null || nums.length < 3)
	            return;
	        
	        Arrays.sort(nums);
	        int right = nums.length/2;
	        int left = 1;
	        
	        while(right < nums.length && left < nums.length) {
	        	int temp = nums[left];
	        	nums[left] = nums[right];
	        	nums[right] = temp;
	        	Arrays.sort(nums, left+1, nums.length);
	        	left += 2;
	        	right++;
	        }
	        
//	        for(int n:nums) {
//	        	System.out.print(n + " ");
//	        }
	        
	   }
    
    public static void main(String args[]) {
    	INCOMPLETE_WiggleSort w = new INCOMPLETE_WiggleSort();
    	int[] nums = {1,1,1}; //{3, 5, 2, 1, 6, 4};
    	w.wiggleSort(nums);
    }
}
