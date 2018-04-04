package leet.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC676M_MagicDictionary {


    //521 .. 24min AC .. similar to wordladder


    // dog, god, dag, a, b, c, sagar, word

    // got … m length … O(m) * 26 … do a O(1) search operation

    // TCs
    // already in dict as is .. god - valid? 
    // no match 
    // empty string
    // dict is empty 
    // all ascii?
    // case matters?


    /** Initialize your data structure here. */
    Set<String> dict;
    public LC676M_MagicDictionary() {
        dict = new HashSet<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dictionary) {
        for(String word:dictionary) {
            dict.add(word);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] wordArr = word.toCharArray();

        for(int i=0; i<wordArr.length; i++) {
            wordArr = word.toCharArray();
            for(int j=97; j<=122; j++) {                
                wordArr[i] = (char) j;
                if(dict.contains(String.valueOf(wordArr)) && !word.equals(String.valueOf(wordArr))) 
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */