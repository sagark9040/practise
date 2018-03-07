package leet.array;

import java.util.Arrays;

public class LC16M_3SumClosest {
    //555pm .. 20 mins AC .. INT_MAX caused a problem here
    
    //sort .. n-logn
    //pickone and do two pointer method
    
    //or n^2
    //pick one and from i+1 to n-1 do n2
    
    //nums = empty, null, 1 element, negatives, all same, increasing order, decreasing order, INT_MAX, INT_MIN
    //target = 0, negative, positive, INT_MAX, INT_MIN
    
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        // 1,2,5,8,10
        
        Arrays.sort(nums);
        int len = nums.length;
        int closest = nums[0] + nums[1] + nums[len - 1];

        for(int i=0; i<len-2; i++) {
            int ptLeft = i+1, ptRight = len-1;
            while(ptLeft < ptRight) {
                int sum = nums[i] + nums[ptLeft] + nums[ptRight];
                if(sum == target) {
                    return sum;
                } else if (target > sum) {
                    ptLeft++;
                } else {
                    ptRight --;
                }
                
                closest = Math.abs(sum-target) < Math.abs(closest-target) ? sum : closest;
            }
        }
        return closest;
    }
}
