package leet.string;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	
List<String> wordDict = new ArrayList<String>();
    
    public boolean wordBreak(String s, List<String> w) {
		
		/*
		l
		le
		lee
		leet
		leetc
		leetco
		leetcod
		leetcode
		*/
        
        wordDict = w;

		if(s == null || s.length() == 0)
			return false;
		

		if(wordBreakSuccess(s))
            return wordBreak;
        
		return listContains(s, wordDict);        
    }
    
    boolean wordBreak = false;
    
    public boolean wordBreakSuccess(String s) {
    	
        for(int i=0; i<s.length(); i++) {
            if(wordBreakSuccess(s.substring(0, i)) && wordBreakSuccess(s.substring(i)))
            	wordBreak = true;
        }    
        
        return false;
    }    
	
	public boolean listContains(String s, List<String> wordDict) {
		for(String word: wordDict)
			if(word.equals(s))
				return true;
		
		return false;
	}
	
	public static void main(String args[]) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("cd");
		l.add("abc");
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak("abcd", l));
	}
}

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). 
Please reload the code definition to get the latest changes.
*/