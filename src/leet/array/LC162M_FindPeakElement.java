package leet.array;

public class LC162M_FindPeakElement {
	public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
                
        for(int i=0; i<nums.length; i++) {
            int next, prev;                        
            if(i == nums.length-1) {
                next = Integer.MIN_VALUE;
                prev = nums[i-1];
            } else if(i == 0) {
                next = nums[i+1];
                prev = Integer.MIN_VALUE;                
            } else {
                next = nums[i+1];
                prev = nums[i-1];                
            }
            
            if(nums[i] > next && nums[i] > prev) {
                return i;
            }
        }
        
        return -1;
    }
}
