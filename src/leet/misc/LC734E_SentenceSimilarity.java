package leet.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC734E_SentenceSimilarity {
	
	// 845 pm
    // Will save the pairs in map
    // Thought about sorting but of no use. Need to maintain order.
	
	
	// 			IMPORTANT  ---- LIKE A FOOL I DIDN'T READ THE ONE-TO-MANY CONDITION .. ARGHHHH 
	
	
	
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null || pairs == null || words1.length != words2.length)
            return false;
        
        Map<String, HashSet<String>> pairInfo = new HashMap<String, HashSet<String>>();
        for(String[] pair:pairs) {
        	if (!pairInfo.containsKey(pair[0])) {
                pairInfo.put(pair[0], new HashSet<String>());			//    <---     ONE TO MANY
            }
            if (!pairInfo.containsKey(pair[1])) {
                pairInfo.put(pair[1], new HashSet<String>());
            }
            
            pairInfo.get(pair[0]).add(pair[1]);
            pairInfo.get(pair[1]).add(pair[0]);
        }
        
        for(int i=0; i<words1.length; i++) {
            if(!isMatch(words1[i], words2[i], pairInfo))
                return false;
        }
        return true;
    }
    
    public boolean isMatch(String word1, String word2, Map<String, HashSet<String>> pairInfo) {
        if(word1.equals(word2)) return true;
        if(pairInfo.containsKey(word1)) {
            if(pairInfo.get(word1).contains(word2)) return true;
        }

        return false;
    }
    
    public static void main(String args[]) {
    	String[] words1 = {"this","summer","thomas","get","actually","actually","rich","and","possess","the","actually","great","and","fine","vehicle","every","morning","he","drives","one","nice","car","around","one","great","city","to","have","single","super","excellent","super","as","his","brunch","but","he","only","eat","single","few","fine","food","as","some","fruits","he","wants","to","eat","an","unique","and","actually","healthy","life"};
    	String[] words2 = {"this","summer","thomas","get","very","very","rich","and","possess","the","very","fine","and","well","car","every","morning","he","drives","a","fine","car","around","unique","great","city","to","take","any","really","wonderful","fruits","as","his","breakfast","but","he","only","drink","an","few","excellent","breakfast","as","a","super","he","wants","to","drink","the","some","and","extremely","healthy","life"};
    	String[][] pairs = {{"good","nice"},{"good","excellent"},{"good","well"},{"good","great"},{"fine","nice"},{"fine","excellent"},
    						{"fine","well"},{"fine","great"},{"wonderful","nice"},{"wonderful","excellent"},{"wonderful","well"},
    						{"wonderful","great"},{"extraordinary","nice"},{"extraordinary","excellent"},{"extraordinary","well"},
    						{"extraordinary","great"},{"one","a"},{"one","an"},{"one","unique"},{"one","any"},{"single","a"},
    						{"single","an"},{"single","unique"},{"single","any"},{"the","a"},{"the","an"},{"the","unique"},{"the","any"},
    						{"some","a"},{"some","an"},{"some","unique"},{"some","any"},{"car","vehicle"},{"car","automobile"},
    						{"car","truck"},{"auto","vehicle"},{"auto","automobile"},{"auto","truck"},{"wagon","vehicle"},
    						{"wagon","automobile"},{"wagon","truck"},{"have","take"},{"have","drink"},{"eat","take"},{"eat","drink"},
    						{"entertain","take"},{"entertain","drink"},{"meal","lunch"},{"meal","dinner"},{"meal","breakfast"},
    						{"meal","fruits"},{"super","lunch"},{"super","dinner"},{"super","breakfast"},{"super","fruits"},
    						{"food","lunch"},{"food","dinner"},{"food","breakfast"},{"food","fruits"},{"brunch","lunch"},
    						{"brunch","dinner"},{"brunch","breakfast"},{"brunch","fruits"},{"own","have"},{"own","possess"},
    						{"keep","have"},{"keep","possess"},{"very","super"},{"very","actually"},{"really","super"},
    						{"really","actually"},{"extremely","super"},{"extremely","actually"}};
    	
    	LC734E_SentenceSimilarity ss = new LC734E_SentenceSimilarity();
    	System.out.println(ss.areSentencesSimilar(words1, words2, pairs));
    }
}
