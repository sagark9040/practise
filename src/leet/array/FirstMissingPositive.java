package leet.array;

public class FirstMissingPositive {	
	
	// Thoughts & TCs:
	// Repeated numbers.
	// Something to do with sum? Smallest Positive and largest positive
	// [-4, 1, 3, 4, 3, -100, 4, 0] --> 1+3+3+4+4+5 = 20 first missing positive = 2 
	// Binary:
	// 1 10 11 110 --> 5 101
	
	
	// Approaches
	
	// Boolean array from 1 till length of array. Mark what we have as present. O(N). Then run through boolean[] and return first false
	// Sort O(N log N) time and get the first one greater than zero which is not present. O(1) space.	
	
	public int firstMissingPositiveLinearSpace(int[] nums) {
		
		if(nums == null || nums.length == 0)
			return 1;			
		
		int largest = Integer.MIN_VALUE;
		
		for(int num: nums) {
			largest = largest < num ? num : largest;             		// IMPORTANT TO CALCULATE THIS FIRST
		}
		boolean[] status = new boolean[largest+1];
		status[0] = true;
		
		for(int num: nums) {
			if (num > 0)		// THIS IS IMPORTANT AS THE STATUS OF NEG NUMBERS WON'T BE CONSIDERED.
				status[num] = true;
			largest = largest < num ? num : largest;
		}
		
		for(int i=1; i<=largest; i++) {		// LOOP SHOULD RUN ONLY POSITIVES 
			if (!status[i])
				return i;
		}
			
		
		return largest+1;        
    }
	
	// CONSTANT SPACE BUT NOT REPEATING NUMBERS
	
	public int firstMissingPositive (int[] nums) {
		if(nums == null || nums.length == 0)
			return 1;
		
		int i = 0;
		for (int num: nums) {			
			
			if(num > 0 && i != num-1 && num < nums.length) {
				nums = swap(nums, num, i); 
				
			}
			
			i++;
		}
		
		for (i=0; i<nums.length; i++) {
			if(nums[i] != i+1)
				return i+1;
		}
		
		return nums[nums.length] + 1;
	}
	
	private int[] swap(int[] nums, int num, int pos) {
		int temp = nums[num-1]; 
		nums[num-1] = num;
		nums[pos] = temp;
		return nums;
	}

	public static void main (String args[]) {
		
		int[] arr = {2}; // {3,4,-1,1};
		FirstMissingPositive first = new FirstMissingPositive();
		System.out.println(first.firstMissingPositive(arr));
	}
}
