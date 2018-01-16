package leet.array;

public class LC26E_RemoveDuplicatesInSortedArray {

	// null, [], [1]
	// [1 2] [1 1 2 2 3] [1 2 2] [1 2 3] [1 1 1]
	 public int removeDuplicates(int[] nums) {
		 if (nums == null || nums.length == 0)
			 return 0;
		 
		 if (nums.length == 1)
			 return 1;
		 
		 int count = 1, lastUnique = 1;
		 int prev = nums[0];
		 
		 for(int i=1; i<nums.length; i++) {
			 int cur = nums[i];
			 
			 if(cur != prev) {
				 nums[lastUnique] = cur;
				 lastUnique++;	 count++;	
			 }
			 
			 prev = cur;
		 }
		 
		 return count;
     }	
	 
	 public static void main (String args[]) {
		 LC26E_RemoveDuplicatesInSortedArray rem = new LC26E_RemoveDuplicatesInSortedArray();
		 System.out.println(rem.removeDuplicates(new int[]{1, 1, 2}));
	 }
}
