package berg;

public class Q1_OddEvenNumberOfIntegersInArray {

	// One integer is odd number of times. Find it.
	static int returnIntOddTimes (int[] input) {
		int result = 0;
		
		for (int i = 0; i < input.length; i++) {
			result = result ^ input[i];
		}
		
		return result;
	}
	
	public static void main(String args[]) {
		int inp[] = {1, 2, 3, 4, 5, 6, 1, 3, 7, 2, 5, 6, 4, 9};
		System.out.println(returnIntOddTimes(inp));
	}
}
