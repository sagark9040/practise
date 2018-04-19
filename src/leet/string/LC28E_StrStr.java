package leet.string;

public class LC28E_StrStr {
	// 8 min AC .. didn't think of negative test cases WTH!
	
	public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        
        if(haystack == null || haystack.length() == 0) {
            return -1;
        }        
        
        for(int i=0; i<haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(matches(haystack, i, needle)) {
                    return i;
                }
            }            
        }
        return -1;
    }
    
    public boolean matches(String haystack, int pos, String needle) {
        int j = 0;
        for(int i=pos; i<haystack.length() && j<needle.length(); i++, j++) {
            if(haystack.charAt(i) != needle.charAt(j)) {
                return false;
            }
        }
        return j == needle.length();
    }
}
