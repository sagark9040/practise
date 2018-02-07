package leet.dp;

public class LC486M_PredictTheWinner {
	  
    //925p --> 1145p!!!  					BOTTOM UP BOTTOM UP BOTTOM UP!!!!!!
    //No clue how to solve this
    //Looked at Tushar Roy's method
    //Pretty straightforward after that. I was doing Top->Down which is why the copying of array and all is involved.
    //Do bottom->up approach in arrays, try to think about those solutions man!
    
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length < 2) {
            return true;
        }
        
        int[][] scores = new int[nums.length][nums.length];
        int n = nums.length;

        for (int len = 1; len < n; len++) {          
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                scores[i][j] = Math.max(nums[i] - scores[i + 1][j], nums[j] - scores[i][j - 1]);
            }
        }

        return scores[0][n-1] >= 0;
    }
}
