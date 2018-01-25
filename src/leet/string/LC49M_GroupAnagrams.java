package leet.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49M_GroupAnagrams {
	// Sorting - first the individual alphabets then the words in total
    // Counting using arrays
    // 
    
	
	// NOTE :: ARRAY SORT vs COLLECTIONS SORT		 <--------------
	// NOTE :: LENGTH VS LENGTH() VS SIZE()			 <--------------
	
	public List<List<String>> groupAnagrams(String[] strs) {

	       if (strs == null || strs.length == 0) return new ArrayList<List<String>>();

	       Map<String, List<String>> map = new HashMap<String, List<String>>();
	        for (String s : strs) {
	            char[] ca = s.toCharArray();
	            Arrays.sort(ca);
	            String keyStr = String.valueOf(ca);
	            if (!map.containsKey(keyStr)) 
	            	map.put(keyStr, new ArrayList<String>(Arrays.asList(keyStr)));
	            else {
	            	List<String> l = map.get(keyStr);
	            	l.add(s);
	            	map.put(keyStr, l);
	            }
	        }
	        return new ArrayList<List<String>>(map.values());
	    }
	
	public static void main(String args[]) {
		String[] s = {"eat","tea","tan","ate","nat","bat"};
		LC49M_GroupAnagrams groupAnagrams = new LC49M_GroupAnagrams();
		for(List<String> cur: groupAnagrams.groupAnagrams(s))
			System.out.println(cur.toString());
	}
}
