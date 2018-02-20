package leet.dfsBfs;

import java.util.Arrays;

public class LC473M_MatchSquare {
	//basically my solution wasn't DFS so it failed in cases like [3,3,3,3,4] which gave true instead of (correct ans) false./
	//rewriting the DFS logic
	//1110pm --> algo 119pm .. 1125 pm essential coding done.
    //Sum = multiple of 4
    //4 sets each summing to sum/4
    //sum = 8
    //setSize = 2
    //no value should be > setSize
    //[2,2,2,2]
    //go on reducing the above set, find first val greater than curNum to do so.
    //if it's all zeroes in the end, then we good
    
    //[4,4,4,4]
    //[2,3,3,2,3,3]
    //[2, 4, 4, 4]
    //[2, 1, 4, 4]
    //[2, 1, 1, 4]
    //[0, 1, 1, 4]
    //[0, 1, 1, 1]
    //false
    //lenOfArray * 4
    //O(n)
    
    public boolean makesquare(int[] nums) {
		if(nums == null || nums.length<4) {
            return false;
        }
        
        int sum = getSum(nums);        
        if(sum % 4 != 0 || 
        		anyStickGreaterThanSide(nums)) {
            return false;
        }
        Arrays.sort(nums);
        reverse(nums);
        int targetSide = sum/4;
        
        return dfs(new int[4], nums, 0, targetSide);
	}
	
	private boolean dfs(int[] sides, int[] nums, int index, int targetSide) {
		if(sides[0] == targetSide && sides[1] == targetSide && sides[3] == targetSide) {
			return true;
		}
	
		for(int i=0; i<sides.length; i++) {
			if(sides[i] + nums[index] > targetSide) {
				continue;
			}
			sides[i] += nums[index];
			if (dfs(sides, nums, index+1, targetSide)) {
				return true;
			}
			sides[i] -= nums[index];
		}
		
		return false;
	}
    
    public boolean makesquareMyOrigNonDFSWrongSoln(int[] nums) {
        //base case
        if(nums == null || nums.length<4) {
            return false;
        }
        
        int sum = getSum(nums);        
        if(sum % 4 != 0 || anyStickGreaterThanSide(nums)) {
            return false;
        }
        int[] sides = initSides(nums); // 2,2,2,2
        return search(sides, nums);
    }
    
    public boolean search(int[] sides, int[] nums) {     
        Arrays.sort(nums);
        reverse(nums);
        for(int num:nums) {
            for(int i=0; i<sides.length; i++) {
                if(sides[i] == 0 || sides[i] < num) {
                    continue;
                }
                sides[i] -= num;
            }
        }
        
        return allSidesCheckedOut(sides);
    }
    
    public boolean anyStickGreaterThanSide(int[] nums) {
        int sum = getSum(nums);
        for(int n:nums) {
            if(n>(sum/4)) {
                return true;
            }
        }
        return false;
    }
    
    public int[] initSides(int[] nums) {
        int sum = getSum(nums);
        int[] sides = new int[4];
        Arrays.fill(sides, sum/4);
        return sides;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
    
    
    public int getSum(int[] nums) {
        int sum = 0;
        for(int n:nums) {
            sum+=n;
        }
        return sum;
    }
    
    public boolean allSidesCheckedOut(int[] sides) {
        for(int side:sides) {
            if(side > 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String args[]) {
    	int [] ar = {10,6,5,5,5,3,3,3,2,2,2,2}; //{3,3,3,3,4}; 
    	LC473M_MatchSquare m = new LC473M_MatchSquare();
    	System.out.println(m.makesquare(ar));
    }
}
