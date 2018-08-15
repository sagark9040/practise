package leet;

import java.util.HashMap;
import java.util.Map;

public class FlipGame2 {

	public boolean oneCanWin = false;
    
    public boolean canWinSubOptimal(String s) {
        if(s == null || s.length() < 2) { 
        	return false;
        }
        
        for(int i=0; i<s.length()-1; i++) {
        	if(s.substring(i, i+2).equals("++")) {
        		String t = s.substring(0, i) + "--" + s.substring(i+2);
        		if(!canWinSubOptimal(t)) {
        			return true;
        		}
        		
        	}
        }
        
        return false;
    }
    
    public boolean canWin(String s) {
    	Map<String, Boolean> map = new HashMap<String, Boolean>();    	
    	return canWin(s, map);
    }
    
    
	
	private boolean canWin(String s, Map<String, Boolean> map) {
		if(map.containsKey(s)) {
			return map.get(s);
		}

		for(int i = 0; i < s.length() - 1; i++) {
	        if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
	            String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
	            if(!canWin(opponent, map)) {
	                map.put(s, true);
	                return true;
	            }
	        }
	    }
	    map.put(s, false);
	    return false;
	}

	public static void main(String args[]) {
		FlipGame2 f = new FlipGame2();
//		System.out.println(f.canWin("++"));
//		System.out.println(f.canWin("+"));
//		System.out.println(f.canWin("-"));
//		System.out.println(f.canWin("--"));
//		
//		System.out.println();
//		System.out.println(f.canWin("+++"));
//		System.out.println(f.canWin("++++"));
		long time = System.currentTimeMillis();
		System.out.println(f.canWinSubOptimal("++-++--++++++++-+++++--++"));
		System.out.println(System.currentTimeMillis() - time);
		
		
		time = System.currentTimeMillis();
		System.out.println(f.canWin("++-++--++++++++-+++++--++"));
		System.out.println(System.currentTimeMillis() - time);
//		System.out.println(f.canWin("+-++--++"));
	}
	
}

/**
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you 
and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and 
therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
*/
