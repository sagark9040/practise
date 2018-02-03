package leet.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// CONCLUSION ... became cocky .. didn't test enough .. might have solved a similar before

//515 pm
//code before debug/dryRun at 521pm
//sort and then do 2 pointer step

//TCs
//Empty, one element or two element
//Three element
//more than three with at least 3 sums smaller
//more than three with no 3 sums smaller

public class INCOMPLETE_LCM_3SumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		
		Set<Combination> combos = new HashSet<Combination>();
		
        if(nums == null || nums.length < 3)
        	return 0;
        Arrays.sort(nums);
        int countThreeSums = 0;
        for(int i=0; i<nums.length-2; i++) {
        	int sum = nums[i];
        	int l=i+1, r=nums.length-1;
        	while(l < nums.length-1) {
        		if(l != r && nums[l] + nums[r] + sum < target) {
        			countThreeSums++;
        			int[] combi = {i, nums[l], nums[r]};
        			Arrays.sort(combi);
        			combos.add(new Combination(combi));
        		}
    			l++;
        	}        	
        	l=i+1; r=nums.length-1;
        	while(r > i) {
        		if(l != r && nums[l] + nums[r] + sum < target) {
        			countThreeSums++;
        			int[] combi = {nums[l], nums[r], sum}; Arrays.sort(combi);
        			combos.add(new Combination(combi));
        		}
    			r--;
        	} 
        	
        }
        
        for(Combination c:combos)
        	System.out.println(c.a + " " + c.b + " " + c.c);
        return combos.size();
    }
	
	class Combination {
		int a, b, c;
		Combination(int[] a) {
			this.a = a[0];
			this.b = a[1];
			this.c = a[2];
		}
	}
	
	public static void main(String args[]) {
		int[] nums = {3,1,0,-2};
		INCOMPLETE_LCM_3SumSmaller l = new INCOMPLETE_LCM_3SumSmaller();
		System.out.println(l.threeSumSmaller(nums, 4));
	}
}



/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]

*/
