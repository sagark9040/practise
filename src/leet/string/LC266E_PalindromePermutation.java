package leet.string;

import java.util.HashMap;

public class LC266E_PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        int countOdd = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c:s.toCharArray()){
            int count = 0;
            if(map.containsKey(c)) {
                count = map.get(c);
            }
            map.put(c, count+1);
        }
        
        for(Character c: map.keySet()) {
            if(map.get(c) % 2 == 1) {
                countOdd++;
            }
        }
        return countOdd < 2;
    }
}
