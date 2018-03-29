package leet.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC47M_Permutations2 {
	
	//830
	
	Set<List<Integer>> lists = new HashSet<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        
        int[] counts = fillCounts(nums);
        List<Integer> result = new ArrayList<Integer>();
        permute(nums, counts, result);
        return new ArrayList<List<Integer>>(lists);
    }
    
    public int[] fillCounts(int[] nums) {            
        int[] counts = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            counts[i] = 1;            
        }
        return counts;
    }
    
    public void permute(int[] nums, int[] counts, List<Integer> result) {
        if(result.size() == nums.length) {
            lists.add(new ArrayList<Integer>(result));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(counts[i] == 0) {
                continue;
            }
            result.add(nums[i]);
            counts[i]--;
            permute(nums, counts, result);
            result.remove(result.size()-1);
            counts[i]++;
        }        
    }
    
    public static void main(String args[]) {
    	int[] a = {1, 1, 2};
    	LC47M_Permutations2 p2 = new LC47M_Permutations2();
    	p2.permuteUnique(a);
    	
    }
}
