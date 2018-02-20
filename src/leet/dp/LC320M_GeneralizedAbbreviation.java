package leet.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC320M_GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
        if(word == null || word.length() < 1) {
            return Arrays.asList("");
        }
        
        ArrayList<String> abbr = new ArrayList<String>();        
        abbr.add(String.valueOf(word.charAt(0)));
        abbr.add("1");
        
        for(int i=1; i<word.length(); i++) {
            ArrayList<String> prevAbbr = abbr;
            abbr = new ArrayList<String>();
            for(String cur:prevAbbr) {
                abbr.add(cur+word.charAt(i));
                abbr.add(cur+1);
            }            
        }
        return condenseNumbers(abbr);
    }
    
    public List<String> condenseNumbers(List<String> abbr) {
        List<String> condensedAbbr = new ArrayList<String>();
        
        for(String curAbbr:abbr) {
            int num = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<curAbbr.length(); i++){
                if(Character.isDigit(curAbbr.charAt(i))) {
                    num++;
                } else {
                    if(num>0) {
                        sb.append(String.valueOf(num));
                    }
                    num = 0;
                    sb.append(curAbbr.charAt(i));
                }
            }
            if(num>0) {
            	sb.append(String.valueOf(num));
            }
            
            condensedAbbr.add(sb.toString());
        }
        
        return condensedAbbr;
    }
    
    public static void main(String args[]) {
    	String word = "word";
    	LC320M_GeneralizedAbbreviation g = new LC320M_GeneralizedAbbreviation();
    	for(String w:g.generateAbbreviations(word))
    		System.out.print(w + " ");
    }
}
