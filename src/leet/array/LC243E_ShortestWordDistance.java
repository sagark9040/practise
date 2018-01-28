package leet.array;

import java.util.ArrayList;

public class LC243E_ShortestWordDistance {
	// Thoughts:
    // Write down array list of pos for both word 1 and 2. Sort them. Use two pointers.
    // 
    
    
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0 || word1 == null || word2 == null)
            return 0;
        
        ArrayList<Integer> posOne = new ArrayList<Integer>(); // DIDN't NEED THESE ARRAYLISTS!!!!
        ArrayList<Integer> posTwo = new ArrayList<Integer>();
        
        int minDist = Integer.MAX_VALUE, p1 = -1, p2 = -1;
        
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(word1))
                p1 = i;
            if(words[i].equals(word2))
                p2 = i;
            if(p1 != -1 && p2 != -1)
                minDist = Math.min(minDist, Math.abs(p1-p2));
        }
        return minDist;
    }
}
