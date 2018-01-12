package leet.array;


// DO A DRY RUN PLEASEEEEEE ... FOUND SMALL ISSUES DURING IT !!!!!!!!!!   !!!!   BUT DAMN EASY QUESTION ... RAN ON FIRST ATTEMPT ON LC 



public class LC485E_MaximumConsecutiveOnes {
	/*

	Example 1:
	Input: [1,1,0,1,1,1]
	Output: 3
	Explanation: The first two digits or the last three digits are consecutive 1s.
	    The maximum number of consecutive 1s is 3.
	
	
	// TCs
	// []
	// [1]
	// [0]
	// [101]
	// [1100111]
	// [1110011]

	*/
	public int findMaxConsecutiveOnes(int[] nums) {
		int maxCount = 0, curCount = 0;
		if(nums == null || nums.length == 0)
			return 0;
		
		for(int curNum: nums) {
			if(curNum == 1)
				curCount++;
			else {
				maxCount = curCount > maxCount ? curCount : maxCount;
				curCount = 0;
			}
		}
		
		return curCount > maxCount ? curCount : maxCount;		
    }
}
