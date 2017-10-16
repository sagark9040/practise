package leet.string;

public class LC5M_LongestPalindromeSubstring {
	//TCs
    //Empty string
    //Single length string
    //All same alphabet string - the string itself is the longest palindrome

    //Brute Force
    //Get all substrings O(N^2) and then in O(N) time get if that is a palindrome or not
    //Note the longest palindrome as you go. Total --> O(N^3)
    
    //Thinking of N^2 solution and if I can somehow note down the character count.
    //Didn't find logic that would be helpful.
    
    //Thinking that if I start find the max palindrome for all i alphabets, centered around str[i]
    //That should be O(N^2)
    
    public String longestPalindrome(String s) {
        s = s.toLowerCase();
        if(s.length() < 2)
            return s;
        
        String rev = new StringBuilder(s).reverse().toString();
        if(s.equals(rev))
            return s;        
        
        char[] ch = s.toCharArray();
        String longestPalin = "";
        
        //Forgot what was the length method for char, so used string's length method.
        //That itself could be wrong, lol.
        for(int i=0; i<s.length(); i++){
            String tempLongest = getLongestPalinAroundThis(ch, i);
            if(tempLongest.length() > longestPalin.length())
                longestPalin = tempLongest;
            
            if(i>(s.length()/2) && longestPalin.length() >= s.length()/2)
            	break;
        }
        return longestPalin;
    }
    
    public String getLongestPalinAroundThis(char[] ch, int i){
        String tempLongestPalin = String.valueOf(ch[i]);
        int left = i-1, right = i+1;
        
        while(left >= 0 && right < ch.length){
            if(ch[left] == ch[right])
                tempLongestPalin = String.valueOf(ch[left]) + tempLongestPalin + String.valueOf(ch[right]);
            else
                break;
                
            left--; right++;
        }
        
        left = i-1; right = i;    
        String tempLongestPalin2 = "", tempLongestPalin3 = "";
        while(left >= 0 && right < ch.length){
            if(ch[left] == ch[right])
                tempLongestPalin2 = String.valueOf(ch[left]) + tempLongestPalin2 + String.valueOf(ch[right]);
            else
                break;
                
            left--; right++;
        }

        left = i; right = i+1;        
        while(left >= 0 && right < ch.length){
            if(ch[left] == ch[right])
                tempLongestPalin3 = String.valueOf(ch[left]) + tempLongestPalin3 + String.valueOf(ch[right]);
            else
                break;
                
            left--; right++;
        }

        
        if(tempLongestPalin.length() >= tempLongestPalin2.length() && tempLongestPalin.length() >= tempLongestPalin3.length())
        	return tempLongestPalin;
        if(tempLongestPalin2.length() >= tempLongestPalin.length() && tempLongestPalin2.length() >= tempLongestPalin3.length())
        	return tempLongestPalin2;
        return tempLongestPalin3;
    }
    
    public static void main(String args[]){
    	LC5M_LongestPalindromeSubstring pali = new LC5M_LongestPalindromeSubstring();
//    	System.out.println(pali.longestPalindrome(""));
//    	System.out.println(pali.longestPalindrome("s"));
//    	System.out.println(pali.longestPalindrome("sb"));
//    	System.out.println(pali.longestPalindrome("bbad"));
//    	System.out.println(pali.longestPalindrome("sbab"));
//    	System.out.println(pali.longestPalindrome("bsbzx"));
//    	System.out.println(pali.longestPalindrome("aaaaa"));
    	System.out.println(pali.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
    }
}
