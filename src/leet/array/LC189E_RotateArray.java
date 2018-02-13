package leet.array;

import java.util.Stack;

public class LC189E_RotateArray {
//	Rotate an array of n elements to the right by k steps.
//	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	
	//1147p -- 1156p
	//Is this from 1 to n always or numbers
	//sorted or not?
	//Stack - push all
	//pop k - elements from k-1 to 0, pop n-k elements from n-1 till stack empty
	
	//Two more solns:
	//Using a temp array
	//Using reverse
	
//	public void rotate(int[] nums, int k) {
//	    k %= nums.length;
//	    reverse(nums, 0, nums.length - 1);
//	    reverse(nums, 0, k - 1);
//	    reverse(nums, k, nums.length - 1);
//	}
	
	
	public void rotate(int[] nums, int k) {
		Stack<Integer> elems = new Stack<Integer>();	
		
		if(k == 0 || k == nums.length || nums == null || nums.length < 2) {
			return;
		}
		
		if(k>nums.length) {
			k = k%nums.length;
		}
		
		for(int curNum:nums) {
			elems.push(curNum);
		}
		
		for(int pos = k-1; pos >= 0; pos--){
			nums[pos] = elems.pop();
		}
		
		for(int pos=nums.length-1; pos>=0 && !elems.isEmpty(); pos--){
			nums[pos] = elems.pop();
		}
		
		System.out.println();
		
    }
	
	public static void main(String args[]) {
		LC189E_RotateArray r = new LC189E_RotateArray();
		int[] nums = {1,2}; int k = 3;
		r.rotate(nums, k);
	}
}
