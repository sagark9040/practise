package leet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC46M_Permutations {
	// 806

	// counts - 1,1,1
	// 1, 2, 3
	// 1, 3, 2
	// 2, 1, 3
	// 2, 3, 1
	// 3, 1, 2
	// 3, 2, 1

	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<List<Integer>>();
		}

		int[] counts = fillCounts(nums);
		List<Integer> result = new ArrayList<Integer>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();

		permute(nums, counts, result, lists);
		return lists;
	}

	public int[] fillCounts(int[] nums) {
		int[] counts = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			counts[i] = 1;
		}
		return counts;
	}

	public void permute(int[] nums, int[] counts, List<Integer> result, List<List<Integer>> lists) {
		if (result.size() == nums.length) {
			lists.add(new ArrayList<Integer>(result));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (counts[i] == 0) {
				continue;
			}
			result.add(nums[i]);
			counts[i]--;
			permute(nums, counts, result, lists);
			result.remove(result.size() - 1);
			counts[i]++;
		}
	}
	
	public static void main(String args[]) {
		int[] nums = {1,2,3};
		LC46M_Permutations p = new LC46M_Permutations();
		p.permute(nums);
	}
}