package leet.misc;

public class SolveTheEquation {
	int leftX, leftNum, rightX, rightNum;
    public String solveEquation(String equation) {
    	return "";
    }
    
    public void getTokens(String equation) {
    	String[] tokens = equation.split("(?=[=])");
    	String[] tokensLeft = tokens[0].split("(?=[+-])");
    	String[] tokensRight = tokens[1].split("(?=[+-])");
    			  	
    	for(String token:tokensLeft) {    		    		
    		if(token.contains("x")) {
    			token.replace("x", "");
    			token.replace("=", "");
    		}
			if(token.charAt(0) == '-')
				leftX -= Integer.valueOf(token.substring(1));
			else
				leftX += Integer.valueOf(token);
    	}
    	
    	for(String token:tokensRight) {
    		if(token.contains("x")) {
    			token.replace("x", "");
    			token.replace("=", "");
    		}
			if(token.charAt(0) == '-')
				rightX -= Integer.valueOf(token.substring(1));
			else
				leftX += Integer.valueOf(token);
		}
    	
    	return;
    }
        
    public static void main(String args[]) {
    	SolveTheEquation solve = new SolveTheEquation();
    	solve.getTokens("2x+3x-6x=x+2");
    }
}

/*
Example 1:
Input: "x+5-3+x=6+x-2"
Output: "x=2"
Example 2:
Input: "x=x"
Output: "Infinite solutions"
Example 3:
Input: "2x=x"
Output: "x=0"
Example 4:
Input: "2x+3x-6x=x+2"
Output: "x=-1"
Example 5:
Input: "x=x+2"
Output: "No solution"
*/