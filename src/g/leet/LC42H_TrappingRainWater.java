package g.leet;

public class LC42H_TrappingRainWater {
	
	//LOOKED AT THIS SOLUTION, UNDERSTOOD IT ONLINE!! 
	
	// HINT: Multiple O(n) passes to compute something.
	// HINT: Use external storage to help calculate answer.	
	
    //Empty array .. zero water
    //One element .. zero water
    //Two elements .. if gap is nothing then no storage so one low is essential.
	
	public static int linearSpaceSolution(int[] height) {
		
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		
		int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;		
		
		for(int i=0; i<height.length; i++) {
			if(height[i] > lMax) 
				lMax = height[i];
			
			leftMax[i] = lMax;
		}
		
		for(int i=height.length-1; i>=0; i--) {
			if(height[i] > rMax)
				rMax = height[i];
			
			rightMax[i] = rMax;
		}
		
		int res = 0;
		for(int i=1; i<height.length-1; i++) {
			int maxOnEitherSide = Math.min(rightMax[i], leftMax[i]);
			if(maxOnEitherSide > height[i])
				res += maxOnEitherSide - height[i];				
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		System.out.println(linearSpaceSolution(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
}
