package leet.dp;

public class LC198E_HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }   
        int[] sumMoney = new int[nums.length+1];
        sumMoney[0] = 0;
        sumMoney[1] = nums[0];
        
        for(int i=2; i<=nums.length; i++) {								/// OFF-BY-ONE ERROR!!!!!!!!
            sumMoney[i] = Math.max(sumMoney[i-1], nums[i-1]+sumMoney[i-2]);
        }
        return sumMoney[nums.length];
    }
    public static void main(String args[]) {
    	LC198E_HouseRobber hr = new LC198E_HouseRobber();
    	int[] nums = {1,1,};
    	System.out.println(hr.rob(nums));
    }
}
