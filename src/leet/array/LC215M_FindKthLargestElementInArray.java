package leet.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC215M_FindKthLargestElementInArray {
	
	// DRY RUN KAR RE BABA!!!
	
	   public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
	
	        if(nums == null || nums.length == 0)
	            return 0;
	
	        for(int i=0; i<nums.length; i++)
	            queue.offer(nums[i]);
	        
	        int v = 0;						// BECAME LAZY AND DIDN'T DO DRY RUN HERE!!
	        while(k > 0) {
	            v = queue.poll(); k--;
	        }
	        return v;
	    }

	    
	    
	// N log N solution in place
	// --------------------------    
//	     public int findKthLargest(int[] nums, int k) {
//	         if(nums == null || nums.length == 0)
//	             return 0;
//	         Arrays.sort(nums); // N log N solution
//	         return nums[nums.length - k];

//	     }
	
}
