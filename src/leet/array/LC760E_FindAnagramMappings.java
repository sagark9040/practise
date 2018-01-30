package leet.array;

import java.util.HashMap;

public class LC760E_FindAnagramMappings {
	
	    public int[] anagramMappings(int[] A, int[] B) {
	        //922 pm -928 pm accepted!
	        //Brute force O(m x n)
	        //O(n) solution. Key value pair for B, with num, pos O(m) or whichever is smaller. Then iterate through the larger and mark pos
	        //
	        
	        if(A == null || A.length == 0 || B == null || B.length == 0)
	            return new int[]{};
	        
	        HashMap<Integer, Integer> posMap = new HashMap<Integer, Integer>();
	        int pos = 0;
	        for(int valB: B) {
	            posMap.put(valB, pos);            
	            pos++;
	        }
	        
	        int[] res = new int[A.length];        
	        for(pos = 0; pos<res.length; pos++)
	            res[pos] = posMap.get(A[pos]);
	        
	        return res;
	    }
	}