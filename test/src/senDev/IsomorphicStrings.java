package senDev;

import java.util.HashMap;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */


/*

p-0-2 
a-1
p-2
e-3
r-4

 */
public class IsomorphicStrings {

	//  
	
	public static boolean isIsomorphic (String s1, String s2) {
		
		int[] m1 = getMap(s1);
		
		int[] m2 = getMap(s2);
		int k=0;
		for (int i:m1){
			System.out.println("m1:"+i+" m2:"+m2[k]);
			if (i!=m2[k])
				return false;
			
			k++;
		}
		
		return true;
	}
	
	static int[] getMap (String str){
		
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		int i=0;
		System.out.println("-");
		int[] arr = new int[str.length()];
		for(Character c: str.toCharArray()){
			
			if (hMap.containsKey(c)){
				arr[i] = hMap.get(c);
			}
			else {
				hMap.put(c, i);
				arr[i] = i;
			}
			System.out.print("mX:"+arr[i]);
			i++;
		}
		System.out.println("--");
		return arr;
	}
	
	public static void main(String args[]) {
		String s1="paper", s2="title";
		System.out.println(isIsomorphic(s1, s2));
		s1="foo"; s2="bab";
		System.out.println(isIsomorphic(s1, s2));
		
		/*
		 * SAF book
		 * Linkedin appl
		 * Bloomberg appl
		 * 
		 */
	}

}

