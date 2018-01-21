package leet.array;

public class LC283M_ProductOfArrayExceptSelf {

	/*

[1, 2,  3, 4], return [24,12,8,6].
[1  2   6  24]
[24 24  12  4]

// O(n^2) possible in constant space
// Division use and O(n) possible in constant space
// To the left * to the right
 * [1, 2,  3, 4, 5]
 * [1, 1,  2, 6, 24]
 * [120,60,20, 5, 1 ]	
	 */
	
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0)
			return new int[]{};
		if (nums.length == 1)
			return nums;
		if (nums.length == 2)
			return new int[] {nums[1], nums[0]};
		
		int start = 1, end = 1, prev = 0;
		int[] leftToRight = new int[nums.length];
		int[] rightToLeft = new int[nums.length];
		
		leftToRight[0] = 1; prev = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			leftToRight[i] = leftToRight[i-1] * prev;
			prev = nums[i];
		}
		
		for(int i:(leftToRight))
			System.out.print(i + " ");
System.out.println();

		rightToLeft[nums.length-1] = 1; prev = nums[nums.length-1];
		for(int i=nums.length-2; i>=0; i--) {
			rightToLeft[i] = rightToLeft[i+1] * prev;
			prev = nums[i];
		}

		for(int i:(rightToLeft))
			System.out.print(i + " ");
System.out.println();
		
		int res[] = new int[nums.length];
		for(int i=0; i<nums.length; i++)
			res[i] = rightToLeft[i] * leftToRight[i];
		
		return res;		
    }
	
	public static void main(String args[]) {
		LC283M_ProductOfArrayExceptSelf prod = new LC283M_ProductOfArrayExceptSelf();
		int[] nums = {1, 2,  3, 4, 5};
		for(int i:prod.productExceptSelf(nums))
			System.out.print(i + " ");
	}
}
