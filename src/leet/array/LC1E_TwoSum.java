package leet.array;

import java.util.HashMap;
import java.util.Map;

public class LC1E_TwoSum {
	
	//Test the input for two sum presence
	public int[] twoSum(int[] nums, int target){

		Map<Integer, Integer> values = new HashMap<Integer, Integer>();
		int pos = 0;
		for(int n: nums) {
			if (values.containsKey(n))
				return new int[]{values.get(n), pos};
			else
				values.put(n, pos);
				
			pos++;
		}
		return new int[]{-1, -1};
	}
	
}
