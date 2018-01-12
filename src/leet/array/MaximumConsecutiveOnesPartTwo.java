package leet.array;

import java.util.Stack;

// Thoughts

// O(n) for maximum consecutive ones without flip. So for this if we modified the array 'm' times, where m is the number of zeroes. 
	// Complexity will be O(mn). And a worst case of O(n^2) if all are zeroes.


// TCs
// []
// [1]
// [0]
// [101]
// [110110]
// [000000]
// [111111]
// [111000]
// [1100111] --> [11-2 00-2 111-3] --> stack/list 2/0/0/3 --> 
// [110110]

// If cur is 1, then curCount++ and check for countMax;
// If cur is 0, then
//						If the prev is notFlipped --> flipCur and ++curCount and check for countMax
// 						If the prev is flipped --> curCount ends and check with max count. prev is flippedNow and curCount = 1
//						



public class MaximumConsecutiveOnesPartTwo {
	
	public int findMaxConsecutiveOnes(int[] nums) {
		
		Stack<Integer> counter = new Stack<Integer>();
		boolean isPrevFlipped = false;
		
		int maxCount = 0, curCount = 0;
		if(nums == null || nums.length == 0)
			return 0;
		
		for(int curNum: nums) {
			if(curNum == 1) {
				curCount++;

				isPrevFlipped = false;
			}
			else {
				if (isPrevFlipped) {
					maxCount = checkForMax (curCount, maxCount); 
					curCount = 1;					
				} else {								
					curCount++;
					isPrevFlipped = true; 
				}
			}
			maxCount = checkForMax (curCount, maxCount); 
		}

		
		return checkForMax(curCount, maxCount);		
    }

	private int checkForMax(int curCount, int maxCount) {		
		return curCount > maxCount ? curCount : maxCount;
	}

	
	
}

// [1,0,1,1,0,1] Output 6: expected 4
	/*

Max Consecutive Ones II
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Follow up:
What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers 
coming from the stream as it's too large to hold in memory. Could you solve it efficiently?

	 */

