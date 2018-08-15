package leet.hash;

import java.util.HashMap;
import java.util.Map;

public class LC246E_StroboNumber {
	public boolean isStrobogrammatic(String num) {
        //1147a
        Map<Character, Character> stro = getStroboList();
        if(num == null || num.length() == 0) {
        	return true;
        } else if(num != null && num.length() == 1) {
        	return num.charAt(0) == '1' || num.charAt(0) == '8';
        }
        
        for(int i=0; i<=num.length()/2; i++) {
            char left = num.charAt(i);
            char right = num.charAt(num.length()-i-1);
            if(i*2+1 == num.length()) {
                return num.charAt(i) == '1' || num.charAt(i) == '8' || num.charAt(i) == '0';
            } else if(!stro.containsKey(left) || !stro.containsKey(right)) {
                return false;
            } else if (stro.get(left) != right || stro.get(right) != left) {
                return false;
            }            
        }        
        return true;
    }
    
    public Map<Character, Character> getStroboList() {
        Map<Character, Character> stro = new HashMap<Character, Character>();
        stro.put('8','8');
        stro.put('1','1');
        stro.put('6','9');
        stro.put('9','6');
        stro.put('0','0');
        return stro;
    }
    
    public static void main (String args[]) {
    	LC246E_StroboNumber s = new LC246E_StroboNumber();
    	System.out.println(s.isStrobogrammatic("60809"));
    }
}
