package leet.dp;

public class LC740M_DeleteAndEarn {

	//140 .. 28 min AC
    
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        
        int[] count = new int[10001];    
        int max = 0;
        
        for(int n:nums)
            count[n] += n;
        
        int[] dp = new int[10003];
        
        for(int i=10000; i>=1; i--) {
            dp[i] = Math.max(count[i] + dp[i+2], dp[i+1]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
