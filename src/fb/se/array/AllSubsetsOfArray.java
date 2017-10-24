package fb.se.array;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfArray {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> allList = new ArrayList<List<Integer>>();
		
		//Since 'n' number of items will result in 2^n possibilities
		int n = nums.length;
		n = (int) Math.pow(2, n);

		//Run all the 2^n possibilities
		for(int i=0; i<n; i++){
			List<Integer> list = new ArrayList<Integer>();
			
			for(int j=0; j<nums.length; j++)
				if((i & (1 << j )) > 0){
					list.add(nums[j]);
					System.out.print(nums[j]);
				}
			
			System.out.println();
			allList.add(list);
		}
		
		return allList;
	}
	public static void main(String args[]){
		AllSubsetsOfArray all = new AllSubsetsOfArray();
		int[] arr = {1,2,3,4};
		all.subsets(arr);				
	}
}
