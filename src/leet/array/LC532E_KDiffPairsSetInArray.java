package leet.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC532E_KDiffPairsSetInArray {
	
	// SIMILAR TO TWO SUM PROBLEM

	class Pair {
		int a, b;
		Pair(int a1, int b1) {
			a = a1;
			b = b1;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			return true;
		}
	}
	public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0)     /// I put k==0 here unnecesarily. Valid TCs with k=0 do exist
            return 0;
        
        Arrays.sort(nums);
        
        Set<Pair> pairSet = new HashSet<Pair>();
        for(int i=0; i<nums.length-1; i++) {
            int a = nums[i];
            int l = i+1, r = nums.length-1;
            
            while(l<=r && l<nums.length && r>=0) {
                int mid = (l+r)/2;
                int b = nums[mid];
                
                if(b-a == k) {
                    if(!pairSet.contains(new Pair(a, b)))
                		pairSet.add(new Pair(a, b));
                	//ps++;
                	break;
                }
                else if(b - a > k) // 1 23456 m = 1, 4 k = 2
                    r = mid-1;
                else               // 1 23456 m = 1, 4 k = 10 
                    l = mid+1;
            }
        }
        return pairSet.size();
    }
	public static void main(String args[]) {
		int[] nums = {3,1,4,1,5};
		int k = 2;
		
		nums = new int[]{2, 4, 10, 1, 1, 5, 6};
		k = 4;
		
		LC532E_KDiffPairsSetInArray kD = new LC532E_KDiffPairsSetInArray();
		System.out.println(kD.findPairs(nums, k));
	}
	
	// 2 4 10 1 1 5 6 k = 4
	// 1 1 2  4 5 6 10 .. len = 7
	// 1 
}
