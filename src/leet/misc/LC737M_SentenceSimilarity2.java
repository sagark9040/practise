package leet.misc;

import java.util.HashMap;

public class LC737M_SentenceSimilarity2 {

	//1220 am .. took 20 mins to code .. 30 more to pass all the TCs..
	// Lookout for corner cases!!!!
	
	
	
    //all of similar words need to able to be clubbed together somehow, such that calling word1 will tell if word2 is similar or not
    //great-good
    //good-great
    //fine-good
    //good-fine
    //Thinking of an array of hashset, where if key was found, add this new similar to that set
    //Iterate through the words1 and 2 and everytime check in array<set> for matches
    //Complexity = O(n x d) -> n = size of words1,2 and d = size of array
    
    //Scratch the above 
    //Use every pair and insert both values in a map with value,position ... keep counter of position increasing
    //If one of the value in the pair is already present the other one gets the same value, if not then both get the new value.
    
    //while checking, return match of val1 and val2
    
    //TCs
    //pairs are empty - false
    //words are empty - false
    //words not equal length - false
    //words same length but one is present other is not - fasle
    //words are same length and match - true
    //words are same length and both are absent - false
	
	public static void main(String args[]) {
		//String[] words1 = {"great","acting","skills"};
		//String[] words2 = {"fine","painting","talent"};
		//String[][] pairs = {{"great","fine"},{"drama","acting"},{"skills","talent"}};
					
		String[] words1 = {"a","very","delicious","meal"};
		String[] words2 = {"one","really","delicious","dinner"};
		String[][] pairs = {{"great","good"},{"extraordinary","good"},{"well","good"},{"wonderful","good"},{"excellent","good"},{"fine","good"},{"nice","good"},{"any","one"},{"some","one"},{"unique","one"},{"the","one"},{"an","one"},{"single","one"},{"a","one"},{"truck","car"},{"wagon","car"},{"automobile","car"},{"auto","car"},{"vehicle","car"},{"entertain","have"},{"drink","have"},{"eat","have"},{"take","have"},{"fruits","meal"},{"brunch","meal"},{"breakfast","meal"},{"food","meal"},{"dinner","meal"},{"super","meal"},{"lunch","meal"},{"possess","own"},{"keep","own"},{"have","own"},{"extremely","very"},{"actually","very"},{"really","very"},{"super","very"}};
		System.out.println(areSentencesSimilarTwo(words1, words2, pairs));
	}
							
	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null || pairs == null || pairs.length == 0 || words1.length != words2.length) {
            return false;
        }
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        int count = 0;
        for(String[] pair:pairs) {
            if(!dict.containsKey(pair[0]) && !dict.containsKey(pair[1])) {
                dict.put(pair[0], count); dict.put(pair[1], count);
                count++;
            } else {
                if(dict.containsKey(pair[0])) {
                    dict.put(pair[1], dict.get(pair[0]));   
                }
                else {
                    dict.put(pair[0], dict.get(pair[1]));   
                }                
            }                
        }
        
        for(int i=0; i<words1.length; i++) {
            if(words1[i].equals(words2[i])) {           // EDGE CASE OF STRING EQUALS
                continue;
            } else if(!dict.containsKey(words1[i]) || !dict.containsKey(words2[i]) || dict.get(words1[i]) != dict.get(words2[i])) {
            	System.out.println(words1[i] + " " + words2[i]);
                return false;
            }
        }
        return true;
    }
}
