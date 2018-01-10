
package leet.string;

import java.util.Arrays;
import java.util.Collections;

public class INCOMPLETE_nextClosestTime {
	/*Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

	You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

	Example 1:

	Input: "19:34"
	Output: "19:39"
	Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
	Example 2:

	Input: "23:59"
	Output: "22:22"
	Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's tim
	*/
	
	public String nextClosestTime(String time) {
		
		// For every digit starting from right, get the next valid digit present. 		
		//0134 --> 0300
		//[012] [0123456789] [01245] [0123456789]

		int[] nums = {time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
		int[] timeNums = nums, newTimeNums = nums;
		Arrays.sort(nums);
		
		newTimeNums[3] = getNextNum(nums);
		//if(newTimeNum is bigger than old)
		newTimeNums[2] = getNextNum(nums);
		newTimeNums[1] = getNextNum(nums);
		newTimeNums[0] = getNextNum(nums);
		
		
		return null;        
    }

	private int getNextNum(int[] nums) {
		// TODO Auto-generated method stub
		return 0;
	}
}
