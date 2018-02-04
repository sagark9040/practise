package leet.dp;

import java.util.ArrayList;
import java.util.List;

public class LC139M_WordBreak {
	int count;
	
    //143 pm to 233 pm
    //NOTES: SHOULD HAVE THOUGHT ABOUT BOTTOM UP APPROACH INSTEAD OF TOP-DOWN
    //MEANING: Started with string of length = 1 and built on that.
	//I DOUBT I LEARNED MUCH FROM JUST ONE PROBLEM.
    
    
    //1252 am
    //can the word break into more than two or just two?
    
    

    //TCs
    //word may not break
    //word breaks into 2 
    //word breaks into more than 2
    //s is null or len = 0
    //dict is empty or null
    
    //Brute Force
    //start every i-> 0 to < n-1 and end from i+1 to n-1 and check for word break
    //detecting multiple overlapping problems here, so might use DP
    //
     
	
    public boolean wordBreak(String s, List<String> wordDict) {
    	
        if(s.length() == 0) {
            return true;
        }
        for(int i=1; i<=s.length(); i++) {
            if(contains(wordDict, s.substring(0, i)) &&
               wordBreak(s.substring(i), wordDict))
                return true;
        }
        return false;
    }
    
    public boolean contains(List<String> wordDict, String s) {
        for(String word: wordDict) {
            if(word.equals(s))
                return true;
        }
        
        return false;
    }
    
    public static void main(String args[]) {
    	LC139M_WordBreak wb = new LC139M_WordBreak();
    	List<String> wordDict = new ArrayList<String>();
    	//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    	//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    	
    	wordDict.add("abcd");
    	wordDict.add("a");
    	wordDict.add("aa");
//    	wordDict.add("aaa");
//    	wordDict.add("aaaa");
//    	
//    	wordDict.add("aaaaa");
//    	wordDict.add("aaaaaa");
//    	wordDict.add("aaaaaaa");
//    	wordDict.add("aaaaaaaa");
//    	
//    	wordDict.add("aaaaaaaaa");
//    	wordDict.add("aaaaaaaaaa");
    	String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

//    	String s = "aaabcd";
    	System.out.println(s.length());
    	System.out.println(wb.wordBreakOptimized(s, wordDict));
    	System.out.println(wb.count);
    }

    public boolean wordBreakOptimized(String s, List<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
    
}
