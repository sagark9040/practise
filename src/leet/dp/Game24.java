package leet.dp;

//904pm -- 930pm ... fucked up the wrong answer!!! arghhhh !! didn't even consider the rearrangement of numbers!!!

//You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
//[4, 1, 8, 7]
//Output: True
//Explanation: (8-4) * (7-1) = 24

//can i reuse  - yes
//4*1*8*7
//4*1+8+7
//4*1*8+7

//[4+1] 5 * 8, 5 + 8, 5 / 8, 5 - 8

//[4*2] 8 * 8, 8 + 8, 8 / 8, 8 - 8

//[4/1] 4 * 
//[4-1] 3



public class Game24 {

	public boolean judgePoint24(int[] nums) {
		
		double[] firstTwo = getVariationsOfTwo(nums[0], nums[1]);
		double[] middleTwo = getVariationsOfTwo(nums[1], nums[2]);
		double[] lastTwo = getVariationsOfTwo(nums[2], nums[3]);
		double epsilon = 0.01;
		
		for(double first:firstTwo) {
			for(double second:lastTwo) {
				double[] variations = getVariationsOfTwo(first, second);
				for(double v:variations) {
					if(Math.abs(v-24d) < epsilon) {
						return true;
					}
				}
			}
		}
			
		for(double mid:middleTwo) {
			double[] results = getVariationsOfTwo((double) nums[0], mid);
			for(double res:results) {
				double[] finalRes = getVariationsOfTwo(res, nums[3]);
				for(double f:finalRes) {
					if(Math.abs(f-24d) < epsilon) {
						return true;
					}
				}
			}
		}
		
		return false;
    }
	
	public double[] getVariationsOfTwo(double a, double b) {
		double[] res = new double[4];
		int pos = 0;
		res[pos++] = a*b;
		res[pos++] = a/b;
		res[pos++] = a-b;
		res[pos++] = a+b;
		return res;
	}
	
	
}
