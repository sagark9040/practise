package leet.dp;

public class LC53E_MaximumSubArray {
	//750pm .. 18 mins
    
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE; 
        int countPositives = 0;
        for(int num:nums) {
            if(num >= 0 || sum+num>=0) {
                sum += num;
                maxSum = Math.max(maxSum, sum);                
            } else {
                sum = 0;
            }
            countPositives = (num > 0) ? countPositives+1 : countPositives;
        }
        return countPositives > 0 ? maxSum : getLowest(nums);
    }
    
    public int getLowest(int[] nums) {
        int highest = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(highest < nums[i]) {
                highest = nums[i];
            }
        }
        return highest;
    }
}
