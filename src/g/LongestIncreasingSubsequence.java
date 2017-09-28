package g;

import java.util.Arrays;

/*

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

 */

//10,9,2,5,3,7,101,18
// 1,1,1,1,1,1, 1,  1 
//10   . 1,1,1,1,1, 2,  2
//9	   . . 1,1,1,1, 2,  2
//2	   . . . 2,2,2, 2,  2
//5	   . . . . 2,2, 2,  2		
//3	   . . . . . 3, 4,  	
//7
//101
//18

public class LongestIncreasingSubsequence {

	private static int[] array;
	private static int[] maxSubseq;
	private static int longest=1;

	private static void init(int[] arr) {
		array = arr;
		maxSubseq = new int[array.length];
		Arrays.fill(maxSubseq, 1);
	}

	private static int longestIncreasingSubsequence(int[] array) {

		for (int i = 0; i < array.length-1; i++) {
			for(int j = i+1; j< array.length; j++) {
				if(array[j] > array[i]) {
					maxSubseq[j] = ((maxSubseq[i]+1) > maxSubseq[j]) ? maxSubseq[i]+1 : maxSubseq[j];
				}
				longest = (maxSubseq[j]>longest) ? maxSubseq[j] : longest;
				
			}
		}

		return longest;
	}

	public static void main(String args[]) {
		int[] a = { 10, 9, 2, 5, 3, 7, 101, 18 };
		init(a);
		System.out.println(longestIncreasingSubsequence(a));
	}
}
