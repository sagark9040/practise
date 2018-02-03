package leet.string;

import java.util.HashMap;
import java.util.Map;

public class LC159M_LongestSubstringWithAtMostKDistinctCharactersPart2 {
	 
    //110am - 145am Accepted
    //Thinking of using a HashMap
    //Add elements till map size < 2
    //remove elements if map size > 2
    
    
   public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxWindow = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i=0;
        if(s == null || s.length() < 1)
            return 0;
        if(s.length() < 3)
            return s.length();
       
        while(map.size() <= 2 && i<s.length()) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else if (!map.containsKey(s.charAt(i)) && map.size() == 2) {
                break;
            } else {
                map.put(s.charAt(i), 1);
            }
            i++;
            maxWindow = Math.max(i, maxWindow);
        }
        int start = 0;
        for(; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(map.containsKey(cur))
                map.put(cur, map.get(cur)+1);
            else
                map.put(cur, 1);
            while(map.size() > 2) {
            	int v = map.get(s.charAt(start))-1;
                map.put(s.charAt(start), v);
                if(map.get(s.charAt(start)) == 0)
                    map.remove(s.charAt(start));
                start++;
            }
            maxWindow = Math.max(i-start+1, maxWindow);
        }
        return maxWindow;
    }
    
    public static void main (String args[]) {
    	String s = "eceba";
    	lengthOfLongestSubstringTwoDistinct(s);    	
    }
}
