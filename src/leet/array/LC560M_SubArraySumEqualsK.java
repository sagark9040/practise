package leet.array;

import java.util.HashMap;
import java.util.Map;

public class LC560M_SubArraySumEqualsK {	
	    
	    //640 .. 650 coding start .. 69/80 mem limit exceeded at 6573
	    //k +- 
	    //nums +-
	    
	    //Brute Force
	    //len = 1 .. till len = n sum everthing and continuous sub array count is found
	    
	    //l = 1 .... 1  1  1
	    //l = 2 .... 1+1  1+1
	    //l = 3 .... 1+1+1
	    
	    //sliding window
	    //extra space pre computation
	    //Two pointers
	    //DP
	    
	    //
	    
	    public int subarraySum(int[] nums, int k) {
	        if(nums == null || nums.length == 0) {
	            return 0;
	        }
	        
	        int len = nums.length, counter = 0; 
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, 1);
	        
	        int sum = 0;
	        
	        for(int i=0; i<len; i++) {
	            int n = nums[i];
	            sum += nums[i];
	            
	            if(map.containsKey(sum-k)) {
	                counter += map.get(sum-k);
	            }
	            
	            int tally = 1;
	            if(map.containsKey(sum))
	                tally += map.get(sum);
	            
	            map.put(sum, tally);
	        }
	        
	        return counter;
	    }
	    
//	     public int subarraySumSubOptimal(int[] nums, int k) {
//	         if(nums == null || nums.length == 0) {
//	             return 0;
//	         }
	        
//	         int len = nums.length, counter = 0;        
//	         int[][] dp = new int[len][len];
	        
//	         for(int i=0; i<len; i++) {
//	             dp[i][i] = nums[i];
//	             counter = dp[i][i] == k ? counter + 1 : counter;
//	         }
	        
//	         for(int i=0; i<len; i++) {
//	             for(int j=i+1; j<len; j++) {
//	                 dp[i][j] = dp[i][j-1] + nums[j];
	                
//	                 counter = dp[i][j] == k ? counter + 1 : counter;
//	             }            
//	         }
	        
//	         return counter;
//	     }
	}