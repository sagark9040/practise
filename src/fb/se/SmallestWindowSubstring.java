package fb.se;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowSubstring {

	public static void main(String args[]){
		String larger = "sagargsagar";
		String smaller = "gsr";
		
		smallestWindow(larger, smaller);
	}

	private static void smallestWindow(String larger, String smaller) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character c: smaller.toCharArray()){
			if(map.containsKey(c))
				map.put(c, map.get(c) +1);
			else
				map.put(c, 1);
		}
		int count = smaller.length();
		int maxWindow = Integer.MAX_VALUE;
		for(int i=0; i<(larger.length()-smaller.length()); i++){
			String subString = larger.substring(i);
			
			System.out.println(subString);
			try {
			int windowSize = getWindowSize(subString, smaller, map, count);
			maxWindow = maxWindow > windowSize ? windowSize : maxWindow;
			}catch(Exception e){}
		}
		System.out.println(maxWindow);
	}

	private static int getWindowSize(String substring, String smaller, Map<Character, Integer> map, int count) {
		int index = 0;
		
		for(index = 0; index < substring.length() - smaller.length() && count > 0; index++){
			char ch = substring.charAt(index);
			System.out.println(ch);
			
			if(map != null && map.containsKey(ch) && map.get(ch)>0){
					map.put(substring.charAt(index), map.get(substring.charAt(index)-1));
					count--;
			}
			
			if(count == 0)
				return index;
		}		
		
		return index;
	}

	// Brute Force
	
	
}
