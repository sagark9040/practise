package leet.array;

import java.util.ArrayList;
import java.util.List;

public class LC163M_MissingRanges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();

        if(nums != null && nums.length == 1 && nums[0] == lower && nums[0] == upper)
            return result;
        
        if(nums == null || nums.length == 0 || (nums[nums.length-1] < lower || nums[0] > upper))  {
            if(lower == upper)
                result.add(String.valueOf(lower));
            else
                result.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            return result;
        }
        if(upper == nums[0]) {
            if(lower == upper-1)
                result.add(String.valueOf(lower));
            else if(lower != upper)
        	    result.add(String.valueOf(lower) + "->" + String.valueOf(upper-1));
            return result;
        }
        
        int start = lower, end = upper;
        for(int num: nums) {
            if(num == start)
                start = num+1;
            else if(num > start) {
                end = Math.min(num-1, upper);
                if(start == end)
                    result.add(String.valueOf(start));
                else
                    result.add(String.valueOf(start) + "->" + String.valueOf(end));
                start = (start == Integer.MAX_VALUE) ? start : num+1;
            } else {
                start = Math.max(lower, num-1);                
            }                
        }
        if(start == upper)
            result.add(String.valueOf(start));
        if(start < upper)
            result.add(String.valueOf(start) + "->" + String.valueOf(upper));
        
        return result;
    }
	
	public static void main (String args[]) {
		int[] nums = {1,1,1};
		int lower = 1, upper = 1;
		LC163M_MissingRanges m = new LC163M_MissingRanges();
		m.findMissingRanges(nums, lower, upper);
	}
}
