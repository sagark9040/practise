package leet.array;

import java.util.HashMap;
import java.util.Map;

public class INCOMPLETE_LC340H_LengthOfLongestSubstringKDistinct {
	
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
		
	    Map<Character, Integer> charCount = new HashMap<Character, Integer>();
	    
		public int lengthOfLongestSubstringKDistinct(String s, int k) {
			
			if (s.length() < 1 || k == 0)
				return 0;
			
			int startWindow = 0, endWindow = 0, distCount = 0, maxStartWindow = 0, maxEndWindow = 0;		
	        int pos = 0;
	        
			while(distCount < k && pos < s.length()){            
	            char curChar = s.charAt(pos);
	            
	            // Char already present in window
	            if(charCount.containsKey(curChar)){
	                charCount.put(curChar, charCount.get(curChar) +1);                
	            } else { // charac to be added in the sequence as the distinct count is less that k
	                charCount.put(curChar, 1);  
	                distCount++;
	            }      
	            endWindow = pos;
	            maxEndWindow = pos;
	            pos++;
	        }		
			
	        // Initial window was found, so we try to get it to maximum.        
			for(int p = pos; p < s.length(); p++) {
	            char curChar = s.charAt(p);    
	            
	            if(curChar != s.charAt(startWindow))
	            	startWindow = removeFirstDistinctChar(s, startWindow, k, p);
	            else
	            	charCount.put(curChar, charCount.get(curChar)+1);
	            	
	            endWindow = p;
	            
	            if((endWindow - startWindow) > (maxEndWindow - maxStartWindow)) {
	                maxStartWindow = startWindow;
	                maxEndWindow = p;
	            }                 
	        }       
	        
			return maxEndWindow - maxStartWindow + 1;
	    }
	    
	    public int removeFirstDistinctChar(String s, int startWindow, int k, int p){
	        while(charCount.size() > k){	        
	        	
	            char curChar = s.charAt(startWindow);
	            
	            // Reduce charCount
	            if(charCount.containsKey(curChar)) {
            		charCount.put(curChar, charCount.get(curChar) - 1);
	            
		            // Remove char if value is 0
		            if(charCount.get(curChar) == 0)
		                charCount.remove(curChar);
	            }
	            
	            startWindow++;
	        }
	        
        	// Char already present in window
            if(charCount.containsKey(s.charAt(p))) {
                charCount.put(s.charAt(p), charCount.get(s.charAt(p)) +1);                
            } else { // charac to be added in the sequence as the distinct count is less that k
                charCount.put(s.charAt(p), 1);  

            }  
	        return startWindow;
	    }
	    
	    public static void main(String args[]){
	    	INCOMPLETE_LC340H_LengthOfLongestSubstringKDistinct len = new INCOMPLETE_LC340H_LengthOfLongestSubstringKDistinct();
//	    	System.out.println(len.lengthOfLongestSubstringKDistinct("a", 1));
//	    	System.out.println(len.lengthOfLongestSubstringKDistinct("eceba", 2));
	    	System.out.println(len.lengthOfLongestSubstringKDistinct("eceebba", 3));
//	    	System.out.println(len.lengthOfLongestSubstringKDistinct("eceebba", 0));
//	    	System.out.println(len.lengthOfLongestSubstringKDistinct("", 3));
//	    	System.out.println(len.lengthOfLongestSubstringKDistinct("aaaaaaaaaa", 3));
//	    	System.out.println(len.lengthOfLongestSubstringKDistinct("a", 2));
//	    	System.out.println(len.lengthOfLongestSubstringKDistinct("aba", 1));
//	    	System.out.println(len.lengthOfLongestSubstringKDistinct("bacc", 2));
	    }

}
