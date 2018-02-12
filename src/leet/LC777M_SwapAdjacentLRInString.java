package leet;

import java.util.HashMap;

public class LC777M_SwapAdjacentLRInString {
	
	//1028p -- LC Soln
	//BASICALLY IGNORE 'X' WHEN THER'S A NON-X, THEY SHOULD MATCH. IF ONE POINTER REACHES THE END THEN THAT"S A PROBLEM
	
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < start.length() && p2 < end.length()){
            
            // get the non-X positions of 2 strings
            while(p1 < start.length() && start.charAt(p1) == 'X'){
                p1++;
            }
            while(p2 < end.length() && end.charAt(p2) == 'X'){
                p2++;
            }
            
            //if both of the pointers reach the end the strings are transformable
            if(p1 == start.length() && p2 == end.length()){
                return true;
            }
            // if only one of the pointer reach the end they are not transformable
            if(p1 == start.length() || p2 == end.length()){
                return false;
            }
            
            if(start.charAt(p1) != end.charAt(p2)){
                return false;
            }
            // if the character is 'L', it can only be moved to the left. p1 should be greater or equal to p2.
            if(start.charAt(p1) == 'L' && p2 > p1){
                return false;
            }
            // if the character is 'R', it can only be moved to the right. p2 should be greater or equal to p1.
            if(start.charAt(p1) == 'R' && p1 > p2){
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }
	
	public boolean canTransformNotFullyCorrect(String start, String endStr) {
        if(start.length() == 1) {
            return start.equals(endStr);
        }
        
        HashMap<String, String> swapMap = initMap();
        int end = 0;
        for(int i=0; i<start.length(); i++) {
            String subStart;
            String subEnd;
        	
            if(i+2 >= start.length()) {
                subStart = start.substring(i);
                subEnd = endStr.substring(i);
            } else {
            	end = i+2;
                subStart = start.substring(i, end);
                subEnd = endStr.substring(i, end);
            }

            
            if(subStart.equals(swapMap.get(subEnd)) || subEnd.equals(swapMap.get(subStart)) || subStart.equals(subEnd)) {
                i++;
            } else if (start.charAt(i) == endStr.charAt(i)) {
                
            } else {
                return false;
            }
            
        }
        return true;
    }
    
    public HashMap<String, String> initMap() {
        HashMap<String, String> swapMap = new HashMap<String, String>();
        swapMap.put("XR", "RX");
        swapMap.put("RX", "XR");
        swapMap.put("XL", "LX");
        swapMap.put("LX", "XL");
        return swapMap;
    }
    
    public static void main(String args[]) {
    	String start = "RXXLRXRXL";
    	String end = "XRLXXRRLX";
    	LC777M_SwapAdjacentLRInString s = new LC777M_SwapAdjacentLRInString();
    	System.out.println(s.canTransform(start, end));
    }
	
	
}
