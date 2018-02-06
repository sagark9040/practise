package leet.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC249M_GroupShiftedStrings {
	
	//CORNER CASES CORNER CASES CORNER CASE !!!!!!!!!!!!!!!! ARGHHHHHHHHHHHHH !!!!!!!!!!!!!!!!!!!
	//ex: az,zy ... abc,xyz ... bac, cbd ... zyxw cbaz 
		
	
	//439 p --> 533 p
	//Circular --> use modulus
	//Empty list of strings or 1 list
	//What if same number of letters but different sequence
	
	//Brute Force: check every string to everything else
	//HashMap of list
	
	//TC empty string
	//duplicates
	
	//abc .. za .. 01
	//011
	
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		if(strings == null || strings.length == 0) {
			return result;
		}
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();		
		for(String s:strings) {
			map = updateMap(map, s);			
		}
		
		return convertMapToList(map);
    }

	private List<List<String>> convertMapToList(HashMap<String, List<String>> map) {
		List<List<String>> res = new ArrayList<List<String>>();
		for(List<String> s: map.values()) {
			res.add(s);
		}
		return res;
	}

	private HashMap<String, List<String>> updateMap(HashMap<String, List<String>> map, String s) {
		String key = getNumber(s);
		List<String> prevValues = new ArrayList<String>();		
		if(map.containsKey(key)) {
			prevValues = map.get(key);
		}
		prevValues.add(s);
		map.put(key, prevValues);
		return map;
	}

	private String getNumber(String s) {
		if(s.length() == 0) {
			return "-1";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("0");
		
		for(int i=1; i<s.length(); i++) {						
			sb.append(String.valueOf(steps(s.charAt(i-1), s.charAt(i))));
		}
		
		return sb.toString();
	}
	
	private int steps(char one, char two) {
		int steps = 0;
		for(; one<=122;) {
			if(two == one) {
				return steps;
			}
			steps++;
			one++;
			if(one == 123) {
				one = 97;
			}
		}
		return steps;
	}
	
	public static void main(String args[]) {
		String[] strings = {"az", "yx"}; //{"abc","bcd","xyz","az","ba","a","z"};
		LC249M_GroupShiftedStrings g = new LC249M_GroupShiftedStrings();
		for(List<String> l:g.groupStrings(strings)) {
			for(int i=0;i<l.size(); i++) {
				System.out.print(l.get(i) + " ");
			}
			System.out.println();
		}
	}
}

/*
we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]*/