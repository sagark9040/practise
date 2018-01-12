package leet.string;

import java.util.Stack;

// Use extra space unless not specified. 
// Using pointers (like I initially thought), use EXTREME PRECAUTION.

public class LC345E_ReverseVowelsOnly {

	 // 1015 pm
    // Even number of vowels
    // Odd num
    // Zero vowels
    // All vowels
    
    // Method 1:
    // First pass add all vowels to stack. Second pass, pop when cur is a vowel and append that.
    
    // Method 2 (without stack, use two pointers):
    // Two pointers - one from start and one from end.
    
    public String reverseVowels(String s) {
        //Empty or one word string
        if(s == null || s.length() < 2)
            return s;
        
        StringBuffer sb = new StringBuffer();        
        Stack<Character> vowels = new Stack<Character>();
        
        for(Character c: s.toCharArray()) {
            if(isVowel(c))
                vowels.push(c);
        }
                    
        for(Character c: s.toCharArray()) {
            if(isVowel(c))
                sb.append(vowels.pop());
            else
                sb.append(c);
        }    
        return sb.toString();
    }
    
    public boolean isVowel(char c) {
        if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u')
            return true;
        return false;
    }
}
