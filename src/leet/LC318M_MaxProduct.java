package leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LC318M_MaxProduct {
	//850p
    //only ascii letters lower case?
    //O(n^2) would be comparing each word to each other word. 
    //
    
    //TCs
    //empty words
    //one word - output?
    
    
    public int maxProduct(String[] words) {
        if(words == null) {
            return 0;
        }
        
        int maxProduct = 0;
        
        for(int i=0; i<words.length-1; i++) {
            for(int j=i+1; j<words.length; j++) {
                HashSet<Character> setA = populateSet(words[i]);
                HashSet<Character> setB = populateSet(words[j]);
                if(haveUniqueCharacters(setA, setB)) {
                    maxProduct = Math.max(maxProduct, words[i].length()*words[j].length());
                }
            }
        }
        return maxProduct;
    }
    
    HashSet<Character> populateSet(String word) {
        HashSet<Character> thisSet = new HashSet<Character>();
        for(char c:word.toCharArray()) {
            thisSet.add(c);
        }
        return thisSet;
    }
    
    boolean haveUniqueCharacters(HashSet<Character> setA, HashSet<Character> setB) {
        if(setA.size() <= setB.size()) {
            for(char aChar:setA) {
                if(setB.contains(aChar)) {
                    return false;
                }
            }            
            return true;
        } else {
            return haveUniqueCharacters(setB, setA);
        }
    }
    
    public int maxProduct_Optimal(String[] words) {
        int max = 0;

        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });

        int[] masks = new int[words.length]; // alphabet masks

        for(int i = 0; i < masks.length; i++){
            for(char c: words[i].toCharArray()){            	
            	int curVal = 1 << (c - 'a'); //  			<-------     TWO CRUCIAL LINES
                masks[i] |= curVal;			 //							                
            }
        }
    
        for(int i = 0; i < masks.length; i++){
            if(words[i].length() * words[i].length() <= max) break; //prunning
            for(int j = i + 1; j < masks.length; j++){
                if((masks[i] & masks[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                    break; //prunning
                }
            }
        }

        return max;
    }
    
    public static void main(String args[]) {
    	LC318M_MaxProduct m = new LC318M_MaxProduct();
    	String[] words = {"z", "a", "b", "c", "d", "z"}; //{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    	System.out.println(m.maxProduct_Optimal(words));
    }
}
