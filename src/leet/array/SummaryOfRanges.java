package leet.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryOfRanges {
//	400 p --> 423p
// PRETTY COMFORTABLE
//	Given a sorted integer array without duplicates, return the summary of its ranges.
//
//	Example 1:
//	Input: [0,1,2,4,5,7]
//	Output: ["0->2","4->5","7"]
//	Example 2:
//	Input: [0,2,3,4,6,8,9]
//	Output: ["0","2->4","6","8->9"]
	
	//Empty array? --> output 
	//start with first element, end=first
	//next element = gap? yes, then add the start->end
						//no , then update the end to cur[i];
	//after that loop .. add start and end 
	
	
	//0,1,2,4,5,7
	//2,4,5,6,8
	//1,5
	
	public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return new ArrayList<String>();		//				<----forgot to add return statement here
        }        
        int start = 0, end = 0;
        List<String> res = new ArrayList<String>();
        for(int i=1; i<nums.length; i++) {
        	if(nums[i] == nums[end]+1) {
        		end = i;
        	} else {
        		if(start == end) {
        			res.add(String.valueOf(nums[start]));
        		} else {
        			res.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
        		}
        		start = i; 
        		end = i;
        	}
        }
        if(start == end) {
        	res.add(String.valueOf(nums[start]));
    	} else { 
    		res.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
        }

        return res;
    }
}








