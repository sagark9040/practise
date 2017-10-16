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
        return tempLongestPalin;
    }
}
