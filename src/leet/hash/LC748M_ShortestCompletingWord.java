package leet.hash;

import java.util.HashMap;
import java.util.Map;

public class LC748M_ShortestCompletingWord {
	 public Map<Character, Integer> generateMap(String str){
	        str = str.toLowerCase();
	        Map<Character, Integer> map = new HashMap<Character, Integer>();
	        
	        for(char c:str.toCharArray()) {
	            if(c < 'a' || c > 'z') {
	                continue;
	            }
	            
	            int count = 1;                        
	            if(map.containsKey(c)) {
	                count += map.get(c);
	            }
	            map.put(c, count);  
	        }
	        return map;
	    }
	    
	    public String shortestCompletingWord(String licensePlate, String[] words) {
	        if(licensePlate == null || licensePlate.length() == 0 || words == null || words.length == 0) {
	            return "";
	        }
	        
	        Map<Character, Integer> map = generateMap(licensePlate);
	        String smallestWord = "";
	        
	        for(String word:words)
	            smallestWord = smallestWord.length() < word.length() ? word : smallestWord;
	        smallestWord += smallestWord;
	        
	        for(String word:words) {
	            Map<Character, Integer> countMap = new HashMap<Character, Integer>(map);
	            for(char c:word.toCharArray()) {
	            	if(!countMap.containsKey(c)) {
	            		break;
	            	} else if(countMap.containsKey(c) && countMap.get(c) > 0) {
	                    countMap.put(c, countMap.get(c)-1);
	                }
	                
	                if(checkMapEmpty(countMap)) {
	                    smallestWord = smallestWord.length() > word.length() ? word : smallestWord;
	                }
	            }            
	        }
	        return smallestWord;
	    }
	    
	    public boolean checkMapEmpty(Map<Character, Integer> map) {
	        for(char c:map.keySet()) {
	            if(map.get(c) > 0)
	                return false;
	        }
	        return true;
	    }
	    
	    public static void main(String args[]) {
	    	
	    	String l = "iLMOl80";
	    	String[] words = {"send","why","want","program","million","wonder","manager","success","likely","them"};
	    	
	    	LC748M_ShortestCompletingWord s = new LC748M_ShortestCompletingWord();
	    	System.out.println(s.shortestCompletingWord(l, words));
	    }
}
