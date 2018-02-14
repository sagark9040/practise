package leet.bit;

import java.util.HashSet;
import java.util.Set;

public class LC421M_MaxXORofTwoNumbers {
	// 1230a

	// 2- 10 .. 1 1
	// 3- 11 .. 2 0
	// 5- 101 .. 2 1
	// 8- 1000 .. 1 3
	// 10- 1010 .. 2 2
	// 23- 10111 .. 4 1
	// 25- 11001 .. 3 2

	// O(n2) - each number with each other .. got that with code in 5 mins.
	// thinking about O(n)
	// Soln 2 idea: O(n) get the largest, assuming it will always be in the XOR,
	// do O(n) to get it's complement.

	public int findMaximumXOR(int[] nums) {
		if (nums.length < 2) {
			return 0;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				max = Math.max(max, nums[i] ^ nums[j]);
			}
		}

		return max;
	}

	public int findMaximumXOR_Optimal(int[] nums) {
		int maxResult = 0;
		int mask = 0;
		/*
		 * The maxResult is a record of the largest XOR we got so far. if it's
		 * 11100 at i = 2, it means before we reach the last two bits, 11100 is
		 * the biggest XOR we have, and we're going to explore whether we can
		 * get another two '1's and put them into maxResult
		 * 
		 * This is a greedy part, since we're looking for the largest XOR, we
		 * start from the very begining, aka, the 31st postition of bits.
		 */
		for (int i = 31; i >= 0; i--) {

			// The mask will grow like 100..000 , 110..000, 111..000, then
			// 1111...111
			// for each iteration, we only care about the left parts
			mask = mask | (1 << i);
			System.out.println(1 << i);
			System.out.println(1 << 5);
			System.out.println(mask);

			Set<Integer> set = new HashSet<>();
			for (int num : nums) {

				/*
				 * we only care about the left parts, for example, if i = 2,
				 * then we have {1100, 1000, 0100, 0000} from {1110, 1011, 0111,
				 * 0010}
				 */
				int leftPartOfNum = num & mask;
				String maskInBin = Integer.toBinaryString(mask);
				set.add(leftPartOfNum);
			}

			// if i = 1 and before this iteration, the maxResult we have now is
			// 1100,
			// my wish is the maxResult will grow to 1110, so I will try to find
			// a candidate
			// which can give me the greedyTry;
			int greedyTry = maxResult | (1 << i);

			for (int leftPartOfNum : set) {
				// This is the most tricky part, coming from a fact that if a ^
				// b = c, then a ^ c = b;
				// now we have the 'c', which is greedyTry, and we have the 'a',
				// which is leftPartOfNum
				// If we hope the formula a ^ b = c to be valid, then we need
				// the b,
				// and to get b, we need a ^ c, if a ^ c exisited in our set,
				// then we're good to go
				int anotherNum = leftPartOfNum ^ greedyTry;
				if (set.contains(anotherNum)) {
					maxResult = greedyTry;
					break;
				}
			}

			// If unfortunately, we didn't get the greedyTry, we still have our
			// max,
			// So after this iteration, the max will stay at 1100.
		}

		return maxResult;
	}

	public static void main(String args[]) {
		int[] nums = { 2, 3, 5, 8, 10, 23, 25 };
		LC421M_MaxXORofTwoNumbers m = new LC421M_MaxXORofTwoNumbers();
		m.findMaximumXOR_Optimal(nums);
	}

}
