package leet.array;

public class LC340H_LengthOfLongestSubstringKDistinct {
	
		//322 pm
	
		// TCs
		// String len = 0, return empty
		// Strng len < k, return empty
		// aaaaaaa k = 3, returns empty
		// eceba k = 2, return ece
		// eceebba k = 3, returns ceebb

		// METHINKS
		// Moving window of somekind. startWindow and endWindow
		// s = “eceba” and k = 2, additional space O(k), initial window len = k
		// init: "ec" adding both e & c to hashmap or array if ASCII. 
		
	    public static void main(String args[]){
	    	LC340H_LengthOfLongestSubstringKDistinct len = new LC340H_LengthOfLongestSubstringKDistinct();
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("a", 1));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("eceba", 2));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("bacc", 2));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("eceebba", 2));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("", 3));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("aaaaaaaaaa", 3));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("a", 2));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("aba", 2));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("bacc", 2));
	    }
	    
	    public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        
	        // TCs max = k, max = start, max = end, max = middle
	        // multiple maxes
	        // k = 0, 1, 10
	        // string is normal, empty and one letter long
	        
	        if(k == 0 || s == null || s.length() == 0)
	            return 0;
	        if(s.length() == 1)
	            return 1;
	        
	        s = s.toLowerCase();
	        
	        int count = 1, start = 0, end = 0, longest = 0;
	        int[] counter = new int[256];
	        counter[s.charAt(0)] = 1;
	        
	        //eceba .. k = 2 .. ece
	        
	        for(int i=1; i<s.length(); i++) {
	            char curChar = s.charAt(i);
	            
	            // Either the count is lower than k, or if it is k then the char is already present
	            if(count < k || (count == k && counter[curChar] > 0)) {
	                if (counter[curChar] == 0)
	                    count++;
	                
	            } else { // Counter is equal to k, then we change the start position.
	                
	                while (count >= k && start < s.length()) {  // CRUCIAL TO PUT A CONDITION TO START
	                    counter[s.charAt(start)]--;                       // CHANGED TO START AFTER DRY RUN
	                    if (counter[s.charAt(start)] == 0)				  // FORGOT TO USE CHAR AT INSTEAD OF JUST START!! >>> ARGHHHHHH
	                        count --;
	                    start++;
	                }        
	                
	                count++;            // ADDED THIS AFTER DRY RUN
	            }
	            counter[curChar]++;
	            end = i;
	            longest = Math.max(longest, end-start+1);                
	        }
	        return longest;
	    }
}
