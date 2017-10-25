package leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

//Questions:

//Is the input sorted?


public class LC90M_AllSubsetsOfArrayDups {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
		int len = nums.length;
		int combinations = (int) Math.pow(2, len);
		Set<List<Integer>> mySet = new HashSet<List<Integer>>();
        
		for(int i=0; i<combinations; i++){
			System.out.println();
			List<Integer> list = new ArrayList<Integer>();
            
            for(int j=0; j<nums.length; j++){
                if((i & (1 << j)) > 0)
                    list.add(nums[j]);                
            }
			mySet.add(list);
            
		}
		
        return convertSetToList(mySet);
    }

	private List<List<Integer>> convertSetToList(Set<List<Integer>> mySet) {

		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for(List<Integer> list: mySet){
			lists.add(list);
			
			for(Integer i: list)
				System.out.print(i);
			
			System.out.println();
		}
		System.out.println("total ----------- " + lists.size());
		return lists;
	}
	
	public static void main(String args[]){
		LC90M_AllSubsetsOfArrayDups all = new LC90M_AllSubsetsOfArrayDups();
		int[] arr = {4,4,4,1,4};
		Arrays.sort(arr);
		all.subsetsWithDup(arr);				
	}
}

