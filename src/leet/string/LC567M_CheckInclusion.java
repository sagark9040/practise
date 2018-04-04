package leet.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC567M_CheckInclusion {
	public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for(int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
        for(int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] > 0)
                while(--count[s2.charAt(l++)] != 0) { /* do nothing */}
            else if ((r - l + 1) == s1.length()) return true;
        }
        return s1.length() == 0;
    }
    
    public boolean checkInclusion2(String s1, String s2) {
        //939
        //sliding window of size s1.length();
        //everytime start of with a char[256] with the count of s1
        //whenever the char[i] of s2 is either 0 in window, slide window one up. Check for char[] = 0 everywhere to confirm the presence of a substring
        //a:1 b:1
        //eidbaooo
        //ei
        //eid
        //eidb
        //eidba
        
        //or if char in map of (s1), then substring i, len and compare their sorts
        
        //Test Cases:
        //s1 > s2 in length
        //s1 or s2 = 0
        //
        
        if(s1.length() == 0 && s2.length() == 0) {
            return false;
        }
        
        if(s1.length() == 0 || s2.length() == 0) {
            return true;
        }
        
        if(s1.length() > s2.length()) {
            return false;
        }
        
        Map<Character, Integer> map = getMap(s1);        
        
        //ab
        //abc
        //
        for(int i=0; i<=s2.length()-s1.length(); i++) {
            if(map.containsKey(s2.charAt(i))) {
                if(areAnagrams(s1, s2.substring(i, i+s1.length()))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean areAnagrams(String s1, String s2) {
        char[] one = s1.toCharArray(), two = s2.toCharArray();
        
        Arrays.sort(one);
        Arrays.sort(two);
        
        return Arrays.equals(one, two);        
    }
    
    Map<Character, Integer> getMap(String s1) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c:s1.toCharArray()) {
            Integer i = 1;
            if(map.containsKey(c)) {
                i += map.get(c);
            }
            map.put(c, i);
        }
        
        return map;
    }
}
