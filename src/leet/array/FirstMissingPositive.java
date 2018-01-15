package leet.array;

public class FirstMissingPositive {	
	
	// Thoughts & TCs:
	// Repeated numbers.
	
	// Approaches
	
	// Boolean array from 1 till length of array. Mark what we have as present. O(N). Then run through boolean[] and return first false
	// Sort O(N log N) time and get the first one greater than zero which is not present. O(1) space.	
	
	public int firstMissingPositiveLinearSpace(int[] nums) {
		
		if(nums == null || nums.length == 0)
			return 1;			
		
		int largest = Integer.MIN_VALUE;
		
		for(int num: nums) {
			largest = largest < num ? num : largest;
		}
		boolean[] status = new boolean[largest+1];
		status[0] = true;
		
		for(int num: nums) {
			if (num > 0)
				status[num] = true;
			largest = largest < num ? num : largest;
		}
		
		for(int i=1; i<=largest; i++) {
			if (!status[i])
				return i;
		}
			
		
		return largest+1;        
    }
	public static void main (String args[]) {
		
		int[] arr = {2}; // {3,4,-1,1};
		FirstMissingPositive first = new FirstMissingPositive();
		System.out.println(first.firstMissingPositiveLinearSpace(arr));
	}
}
