package g.leet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//TCs
//Empty array
//One element in an array
//
//
//

public class kEmptySlots {
	
	Set<Integer> slots = new TreeSet<Integer>();
	public int kEmptySlots(int[] flowers, int k) {
		slots = new TreeSet<Integer>();
		if (flowers.length < 2)
			return -1;
		
		for(int i=0; i<flowers.length-1; i++){
			for(int j=i+1; j<flowers.length; j++){
				if(checkSlots(flowers[j], flowers[i], k)){
				//if(flowers[j]-flowers[i]-1 == k)
					return j+1;
				}
			}
		}
		
		return -1;
    }
	
	private boolean checkSlots(int j, int i, int k) {
		slots.add(i);
		slots.add(j);
		
		if(j-i<=1)
			return false;
		
		for(int slot = i+1; slot < j; slot++){			
			if(!slots.contains(slot))
				return true;
		}
		return false;
	}

	public static void main(String args[]){
		kEmptySlots slots = new kEmptySlots();
		int[] arr = {1,3,2};
		System.out.println(slots.kEmptySlots(arr, 1));
		arr = new int[]{1,2,3};
		System.out.println(slots.kEmptySlots(arr, 1));
		arr = new int[]{1,2,3,4,5,7,6};
		System.out.println(slots.kEmptySlots(arr, 1));
		arr = new int[]{6,5,8,9,7,1,10,2,3,4};
		System.out.println(slots.kEmptySlots(arr, 2));
	}
	
	/*
[6,5,8,9,7,1,10,2,3,4]
2
	 */
}

/*
There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and 
it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and 
these flowers are not blooming.

If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.

Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1

*/

