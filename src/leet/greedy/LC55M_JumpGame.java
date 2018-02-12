package leet.greedy;

public class LC55M_JumpGame {
	public boolean canJumpMySubOptimal(int[] nums) {
        // 540 pm
        // start from n-1 and return [0]
        // A = [2,3,1,1,4], return true.
        // A = [3,2,1,0,4], return false.
		
		//LC SOLN (below):
		//Idea is to work backwards from the last index. Keep track of the smallest index that can 
		//“jump” to the last index. Check whether the current index can jump to this smallest index.
		
        boolean[] jumps = new boolean[nums.length];
        jumps[nums.length-1] = true;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] + i >= nums.length-1) {
                jumps[i] = true;    
            } else {
                boolean flag = false;
                for(int nxt=0; nxt<=nums[i]; nxt++) {
                    if(jumps[i + nxt] == true) {
                        flag = true;
                    }
                }                
                jumps[i] = flag;
            }
        }        
        return jumps[0];
    }
	
	public boolean canJump(int A[]) {
        int n=A.length;
        int last=n-1,i;
        for(i=n-2;i>=0;i--){
            if(i+A[i]>=last)last=i;
        }
        return last<=0;
    }
	


	public static void main(String args[]) {
		LC55M_JumpGame j = new LC55M_JumpGame();
		int nums[] = {2,5,0,0};
		System.out.println(j.canJump(nums));
	}
}
