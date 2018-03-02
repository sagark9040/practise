package leet.dfsBfs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LC756M_PyramidTransitionMatrix {

	 //652 to 752 pm .. 
    //rowNum = length of bottom
    //if we reach rowNum == 1 and has something then we return true
    
    //every row will have a list of strings of a particular length
    //for every string, traverse two chars at a time and add the map value to [][] ...
    
    
    
    // [AB] [CD] [EF] [GH]    ---->  AC AD BC BD / CE CF DE DF / GH]
    // U   V    W    X    Y 
    
    public boolean pyramidTransition(String bottom, List<String> allowed) {
		Map<String, List<String>> map = generateMap(allowed);
		return dfs(bottom, map);
	}

	public boolean dfs(String row, Map<String, List<String>> map) {
		if (row.length() == 1) {
			return true;
		}

		List<List<String>> tuples = new ArrayList<List<String>>();
		for (int i = 0; i < row.length() - 1; i++) {
			String str = row.substring(i, i + 2);
			if (map.containsKey(str)) {
				tuples.add(map.get(str));
			}  else {
				return false;
			}
		}

		if (row.length() == 1) {
			return true;
		}
		
		List<String> result = new ArrayList<String>();
		result.add("");
		for (List<String> tuple : tuples) {
			List<String> matches = generateMatches(tuple, result);
			result = matches;
		}

		if (result.size() > 0 && result.get(0).length() > 0) {
			for (int i = 0; i < result.size(); i++) {
				if (dfs(result.get(i), map)) {
					return true;
				}
			}
		}
		return false;
	}

	List<String> generateMatches(List<String> tuples, List<String> results) {
		List<String> permutations = new ArrayList<String>();

		// ”” .. d, c .. dd, cd, de, ca
		// [[DC][DE][A]] -> [DD][DC][DE][CD] x A → [DDA][DCA][DEA][CDA]
		for (String val : results) {
			for (String cur : tuples) {			
				permutations.add(val + cur);
			}
		}
		return permutations;
	}

	// Generates pairs of D,E -> A … X,Y -> Z and so on
	public Map<String, List<String>> generateMap(List<String> allowed) {
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		for (String a : allowed) {
			List<String> l = new ArrayList<String>();
			l.add(String.valueOf(a.charAt(2)));
			if (map.containsKey(a.substring(0, 2))) {
				l.addAll(map.get(a.substring(0, 2)));
			}
			map.put(a.substring(0, 2), l);
		}
		return map;
	}

	public static void main(String args[]) {
		String str = "XYZ";
		List<String> list = new ArrayList<String>();
		list.add("XYD");
		list.add("YZE");
		list.add("DEA");
		list.add("XYC");
		list.add("YZD");
		
		/*
		 * "AABA"
["AAA","AAB","ABA","ABB","BAC"]

AAC, ABC, ABC, BBC
A.B  


		 */
		LC756M_PyramidTransitionMatrix pyramid = new LC756M_PyramidTransitionMatrix();
		System.out.println(pyramid.pyramidTransition(str, list));
	}
}
