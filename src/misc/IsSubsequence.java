package misc;

import java.util.ArrayList;
import java.util.List;

public class IsSubsequence {
	public String findLongestWord(String s, List<String> d) {
        if(s == null || s.length() == 0)
            return "";
        
        String longestWord = "";
        
        for(String dictWord: d){
            if(isSubsequence(dictWord, s)){
                if(dictWord.length() > longestWord.length())
                    longestWord = dictWord;
                else if(dictWord.length() == longestWord.length() && (dictWord.compareTo(longestWord) < 0)){
                    longestWord = dictWord;
                }
            }
        }
        
        return longestWord;
    }
    
    public boolean isSubsequence(String a, String b){
		if(a.length() > b.length())
			return false;
			
		int indexOfB=0; 
		for(char charA: a.toCharArray()){
			while(indexOfB < b.length() && b.charAt(indexOfB) != charA){
				indexOfB++;
			}
			
			if(indexOfB == b.length())
				return false;
			
			indexOfB++;
		}
		
		return true;
	}
	
	public static void main(String args[]){
		String[] valid = {"gar", "sagar"};
		String[] inValid = {"srg", "sagar"};
		String s = "bab";
		List<String> a = new ArrayList<String>();
		a.add("ba");
		a.add("ab");
		a.add("a");
		a.add("b");
		
		System.out.println(valid[0].compareTo(valid[1]));
		
		IsSubsequence isSub = new IsSubsequence();
		System.out.println(isSub.findLongestWord(s, a));
		System.out.println(isSub.isSubsequence(inValid[0], inValid[1]));
	}
}
