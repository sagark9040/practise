package in.gd.ssde;

import java.util.HashSet;
import java.util.Set;

//Given a list of integers A and an integer k, return the number of unique pairs of integers in A that sum to k. 
//For example, if A=[1 2 5 5 10 8 2] and k=10, the answer is 2, arrived as 5+5 or 2+8. 
//There were 15 tests for this question, with at least the last two timing out, given that the implementation was not as efficient as possible.

public class SumToK {

		static void sumToK(int[] arr, int k) {
			Set<Integer> mySet = new HashSet<Integer>();
			
			for(int i: arr){
				
				if (mySet.contains(k-i))
					System.out.println("Pair found:" + i + " " + (k-i));
				
				else if (i==k)
					System.out.println("Pair found:" + i);
				
				mySet.add(i);
			}
		
		}
		
		public static void main(String args[]) {
			int[] arr={1, 2, 5, 5, 10, 8, 2, 0};
			sumToK(arr, 10);
		}
	
}
