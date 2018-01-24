package leet.stack;

import java.util.Stack;

// THIS IS ONE OF THOSE EASY CODING PROBLEMS WHERE I DIDN'T FULLY UNDERSTAND THE QUESTION AND DIDN'T 
// TEST ENOUGH WITH A WIDE RANGE OF TEST CASES!! EX: 2-DIGIT NUMBERS OR NEGATIVE NUMBERS OR LARGE NUMBERS ... ARGGGHHHH 

public class LC682E_BaseballGame {
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0)
            return 0;
        
        Stack<Integer> validNumbers = new Stack<Integer>();
        int curNum = 0;

        //Input: ["5","-2","4","C","D","9","+","+"] :::: 27
        
    	//["5","-2","4","C","D","9","+","+"]
    	//  5   -2     		-4   9   5   14 = 27
        
        for(String cur: ops) {
        	curNum = 0;
        	
        	boolean isNumber = checkIsNumber (cur);
            if(isNumber) {
        		if(cur.charAt(0) == '-') {
        			for (int i = 1; i < cur.length(); i ++)
        			    curNum = curNum * 10 + Character.getNumericValue(cur.charAt(i));

        			curNum = -curNum;
        		} else {
        			for (int i = 0; i < cur.length(); i ++)
        			    curNum = curNum * 10 + Character.getNumericValue(cur.charAt(i));
        		}          	
        		validNumbers.add(curNum);   
            } else if (cur.charAt(0) == 'D') { //Double
            	
            	if(!validNumbers.isEmpty()) 
            		validNumbers.add(validNumbers.peek() * 2);
            	
            } else if (cur.charAt(0) == 'C') { //Cancel
            	
            	if(!validNumbers.isEmpty()) {
            		validNumbers.pop();
            	}
            	
            } else if (cur.charAt(0) == '+') {  // Plus
            	
            	int a = 0, b = 0;
            	if(!validNumbers.isEmpty())
            		a = validNumbers.pop();            		
            	if(!validNumbers.isEmpty())
            		b = validNumbers.pop();

            	validNumbers.push(b);
            	validNumbers.push(a);
            	validNumbers.push(a+b);
            }
        }       
        
        int sum = 0;
        while(!validNumbers.isEmpty())
        	sum+=validNumbers.pop();
        
        return sum;
    }

	private boolean checkIsNumber(String cur) {
		char c = cur.charAt(0);				
		return c == '-' || (c >= '0' && c <= '9');
	}

	public static void main(String args[]) {
		String[] ops = {"1","C","-62","-45","-68"}; //{"5", "-2", "4", "C", "D", "9", "+", "+"};
		LC682E_BaseballGame game = new LC682E_BaseballGame();
		game.calPoints(ops);
	}
	
   
}
