package leet.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// PRETTY EASY ONE.

public class LC349E_IntersectionOfTwoArrays {

	// Add smallest one to a set Iterate the bigger one and add that to the set if it exists already
	// Sort them and use two pointers
		
	public int[] intersection(int[] nums1, int[] nums2) {
		
		Set<Integer> smallerSet = new HashSet<Integer>();
		
		if(nums1.length > nums2.length)
			return intersection(nums2, nums1);
		
		for(int i: nums1)
			smallerSet.add(i);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i: nums2) {
			if(smallerSet.contains(i)) {
				list.add(i);
				smallerSet.remove(i);
			}
		}
		
		return toArray(list);
        
    }
	
	public int[] toArray(ArrayList<Integer> list) {
		int[] arr = new int[list.size()];
		int pos = 0;
		for(int l: list)
			arr[pos++] = l;
		
		return arr;
	}
	
	public static void main(String args[]) {
		
		int[] a = {1,2,3},
			b = {1};
		
		LC349E_IntersectionOfTwoArrays in = new LC349E_IntersectionOfTwoArrays();
		for (int i: in.intersection(a, b))
			System.out.println(i);
		
		
		
	}
	
}
