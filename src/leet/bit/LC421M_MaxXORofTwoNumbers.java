package leet.bit;

import java.util.HashSet;

public class LC421M_MaxXORofTwoNumbers {
//1230a
    
    //2-     10 .. 1 1
    //3-     11 .. 2 0
    //5-    101 .. 2 1
    //8-   1000 .. 1 3
    //10-  1010 .. 2 2
    //23- 10111 .. 4 1
    //25- 11001 .. 3 2
    
    //O(n2) - each number with each other .. got that with code in 5 mins. thinking about O(n)
    //Soln 2 idea: O(n) get the largest, assuming it will always be in the XOR, do O(n) to get it's complement.
    
    public int findMaximumXOR(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        
        return max;
    }
    
    public int findMaximumXOR_Optimal(int[] nums) {
    	int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask); // reserve Left bits and ignore Right bits
            }
            
            /* Use 0 to keep the bit, 1 to find XOR
             * 0 ^ 0 = 0 
             * 0 ^ 1 = 1
             * 1 ^ 0 = 1
             * 1 ^ 1 = 0
             */
            int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                }
            }
        }
        return max;
    }
    
    public static void main(String args[]) {
    	int[] nums = {2, 3, 5, 8, 10, 23, 25};
    	LC421M_MaxXORofTwoNumbers m = new LC421M_MaxXORofTwoNumbers();
    	m.findMaximumXOR_Optimal(nums);
    }

}
