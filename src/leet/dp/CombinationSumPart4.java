package leet.dp;

import java.util.Arrays;

public class CombinationSumPart4 {
//	1224
	
//	Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a 
//	positive integer target.
//
//	Example:
//
//	nums = [1, 2, 3]
//	target = 4
//
//	[0] = 1
//	[1] = 1 (n)
//	[2] = 1 + 1 = 11 2 = 2
//	[3] = 2 + 1 = 3 ... 111 12 21 3
//	[4] = 4	
//
//
//
//
//	The possible combination ways are:
//	(1, 1, 1, 1)
//	(1, 1, 2)
//	(1, 2, 1)
//	(1, 3)
//	(2, 1, 1)
//	(2, 2)
//	(3, 1)
//
//	Note that different sequences are counted as different combinations.
//
//	Therefore the output is 7.
	
	//150p
	//sorted nums or not
	//DFS?
	//Sorted and then start from the number smaller than target.
	//i = 3, j = 1,2 ... --> 1,3 and 3,1
	//1,3 = 1,3 .. 1,2,1 .. 1,1,2 .. 2,1,1
	//1,2,1 = 1,1,1,1
	
	
	int count = 0;
	public int combinationSum4Old(int[] nums, int target) {		
		Arrays.sort(nums);
		int[] combos = new int[target+1];
		getCombinations(nums, target);
        return count;
    }
	private void getCombinations(int[] nums, int target) {
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				
			}
		}
	}
	
	public int combinationSum4(int[] nums, int target) {
	    int[] comb = new int[target + 1];
	    comb[0] = 1;
	    for (int i = 1; i < comb.length; i++) {
	        for (int j = 0; j < nums.length; j++) {
	            if (i - nums[j] >= 0) {
	                comb[i] += comb[i - nums[j]];
	            }
	        }
	    }
	    return comb[target];
	}
	
	public static void main(String args[]) {
		CombinationSumPart4 c = new CombinationSumPart4();
		int[] nums = {1,2,3};
		int target = 4;
		c.combinationSum4(nums, target);
	}

	//0:  1:  2:  3:  4:
	//0:1 1:1 2:2 3:
	//

}
