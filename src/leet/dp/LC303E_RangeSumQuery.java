package leet.dp;

public class LC303E_RangeSumQuery {
    int[] nums;
    int[][] sumRanges;
    public LC303E_RangeSumQuery(int[] n) {
        nums = n;     
        int len = n.length;
        for(int i=1; i<len; i++) {
            nums[i] += nums[i-1];			// <---- DIDN'T THINK OF THIS OPTIMIZATION AT FIRST!!!!!
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) {
            return nums[j];
        } else {
            return nums[j] - nums[i-1];   
        }
    }

}
