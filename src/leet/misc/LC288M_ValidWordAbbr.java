package leet.misc;

import java.util.HashMap;
import java.util.Map;

public class LC288M_ValidWordAbbr {
    //1150 am to 1200
    //Looks straight forward. Iterate dictionary, calculate the abbr and add to hashset
    //Check incoming word against the hashset
    
	Map<String, Integer> abbr = new HashMap<String, Integer>();
    
    public LC288M_ValidWordAbbr(String[] dictionary) {
        for(String d:dictionary) {
            if(d.length() < 3) {
                if(abbr.containsKey(d))
                    abbr.put(d, abbr.get(d)+1);
                else
                    abbr.put(d, 1);
            }
            else {
                if(abbr.containsKey(getAbbriv(d)))
                    abbr.put((getAbbriv(d)), abbr.get((getAbbriv(d)))+1);
                else
                    abbr.put((getAbbriv(d)), 1);              
            }
        }
    }
    
    public String getAbbriv(String d) {
        if(d == null || d.length() == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(d.charAt(0));
        sb.append(d.length()-2);
        sb.append(d.charAt(d.length()-1));
        return sb.toString();
    }
    
    public boolean isUnique(String word) {
        if(abbr.containsKey(getAbbriv(word)))
            return abbr.get(getAbbriv(word)) == 1;
        else
            return true;
    }
    
    public static void main(String args[]) {
    	String[] dict = {"deer","door","cake","card"};
    	LC288M_ValidWordAbbr v = new LC288M_ValidWordAbbr(dict);
    	v.isUnique("door");
    	
    	//		[[[]],["dear"],["door"],["cart"],["cake"]]
    }
}
