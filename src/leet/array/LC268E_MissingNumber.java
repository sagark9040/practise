package leet.array;

public class LC268E_MissingNumber {
	public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len+1)/2;
        for(int i=0; i<nums.length; i++) {
            sum -= nums[i];
        }
        
        return sum;
        //[9,6,4,2,3,5,7,0,1]
    }
}
