package leet.array;

public class LC167E_TwoSum2InASortedArray {

	//5 mins
	public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            if(numbers[left] + numbers[right] == target)
                return new int[]{left+1, right+1};
            else if(numbers[left] + numbers[right] > target)
                right--;
            else
                left++;
        }
        return new int[]{};
    }
	
}
