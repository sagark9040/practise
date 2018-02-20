package leet;

import java.util.HashSet;
import java.util.Set;

public class LC128H_LongestConsecutiveSequence {
	//range of the numbers?
	//if small then get the boolean array
	//repeats
	
	//Saw soln for set (and map) which would make array unnecesary as array is more wasteful
	//Interesting line for removing the set elements without making a concurrent modification exception
	
	
	//			G R E A T    T E C H N I Q U E    T O     R E M O V E   N U M S    F R O M   A R R A Y
	
	public int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		int max = 0;
		
		Set<Integer> foundNums = new HashSet<Integer>(); 
		for(int i=0; i<nums.length; i++) {
			foundNums.add(nums[i]);
		}
	
		for(int num:nums) {
			int count = 1;
			
			int n = num;
			while(foundNums.contains(--num)) {
				count++;
				foundNums.remove(num);
			}
			
			while(foundNums.contains(++n)) {
				count++;
				foundNums.remove(n);
			}
			
			max = Math.max(max, count);
		}
		
		return max;
	}
		
	public int longestConsecutiveWasteful(int[] nums) {
		boolean[] hasNumPos = new boolean[Integer.MAX_VALUE];
		boolean[] hasNumNeg = new boolean[Integer.MAX_VALUE];
		for(int i=0; i<nums.length; i++) {
			if(nums[i] >= 0)
				hasNumPos[i] = true;
			else
				hasNumNeg[-i] = true;
		}
		int maxCount = 1, count = 0;
		for(int i=0; i<hasNumPos.length; i++) {
			if(hasNumPos[i]) {
				count++;
			} else {
				maxCount = Math.max(maxCount, count);
			}
		}
		maxCount = Math.max(maxCount, count);
		
		return maxCount;
    }
	
	public static void main(String args[]) {
		LC128H_LongestConsecutiveSequence l = new LC128H_LongestConsecutiveSequence();
		int[] nums= {2,10,3,40,1,200,4, Integer.MAX_VALUE};
		System.out.println(l.longestConsecutive(nums));
	}
}

/**
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
*/