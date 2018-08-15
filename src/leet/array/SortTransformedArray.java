package leet.array;

public class SortTransformedArray {
	    
	    //505pm
	    //BF
		//If a,b,c are fixed:
		//create 3 supplementing array
		//O(n) x 4 I will get the result, but unsorted
		//
	
		//120pm
		//nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

		//Result: [3, 9, 15, 33]
		//nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
		//Result: [-23, -5, 1, 7]
	
	    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
	        if(nums == null || nums.length == 0) {	        	
	        	return null;
	        }
	        int[] calcForA = new int[nums.length];
	        int[] calcForB = new int[nums.length];
	        int[] calcForC = new int[nums.length];
	        int max = Integer.MIN_VALUE;
	        
	        int pos = 0;
	        for(int n:nums) {
	        	calcForA[pos] = n*n + a;
    			pos++;
	        }
	        
	        pos = 0;
	        for(int n:nums) {
	        	calcForB[pos] = n*n + b;
    			pos++;
	        }
	        
	        pos = 0;
	        for(int n:nums) {
	        	calcForC[pos] = n*n + c;
    			pos++;
	        }
	        
	        pos = 0;
	        for(int i=0; i<nums.length; i++) {
	        	nums[i] = calcForA[i] + calcForB[i] + calcForC[i];
    			max = Math.max(max, nums[i]);
	        }

	        
	        
	        return null;
	    }

}
