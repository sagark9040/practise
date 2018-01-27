package leet.string;

public class LC3M_LongestSubstringWithoutRepeatingCharacters {

	// REMEMBER THE WINDOW MOVES!!!
	// DRY RUN IS CRUCIAL!!!!
	
	public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        if(s.length() < 2) return s.length();

        int start = 0, curLen = 1, maxLen = 1, end = 0;
        int[] count = new int[256];
        count[s.charAt(0)]++;        
        
        //abcabcbb
            
        for(int i=1; i<s.length(); i++) {
            char curChar = s.charAt(i);
            while(count[curChar]>0) {
                count[s.charAt(start)]--;
                start++;
            }
            count[curChar]++;
            end = i;
            maxLen = maxLen > end - start + 1 ? maxLen : end - start + 1;                
        }
        
        return maxLen;
    }
	
}
