package leet.dp;

public class LC152M_MaxProductSubarray {
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int maxProd = Integer.MIN_VALUE, prod = 1;
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            if(prod == 0) {
                prod = 1;
            }
            
            if(cur != 0) {
                prod *= cur;
            } else {
                prod = 0;
            }
            maxProd = Math.max(maxProd, prod);
        }
        
        prod = 1;
        for(int i=nums.length-1; i>=0; i--) {
            int cur = nums[i];
            if(prod == 0) {
                prod = 1;
            }
            
            if(cur != 0) {
                prod *= cur;
            } else {
                prod = 0;
            }
            maxProd = Math.max(maxProd, prod);
        }
        
        return maxProd;
    }
}
