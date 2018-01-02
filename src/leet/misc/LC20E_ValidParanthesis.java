package leet.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20E_ValidParanthesis {

	public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        Map<Character, Character> open = openParen();
        Map<Character, Character> close = closearen();
        
        for(Character c: s.toCharArray()){
            if(open.containsKey(c))
            	brackets.add(c);
            else if(close.containsKey(c)){
                if(brackets.isEmpty()) return false;
                else if(brackets.peek() != close.get(c)) return false;
                else brackets.pop();                    
            }
        }
        return brackets.isEmpty() == true;
    }
    
    public Map<Character, Character> openParen(){
    	Map<Character, Character> brackets = new HashMap<Character, Character>();
    	brackets.put('{', '}');
    	brackets.put('(', ')');
    	brackets.put('[', ']');
    	return brackets;
    }
    public Map<Character, Character> closearen(){
    	Map<Character, Character> brackets = new HashMap<Character, Character>();
    	brackets.put(']', '[');
    	brackets.put('}', '{');
    	brackets.put(')', '(');
    	return brackets;
    }
    
    
    public static void main(String args[]){
    	LC20E_ValidParanthesis paren = new LC20E_ValidParanthesis();
    	System.out.println(paren.isValid("()"));
    }
	
}
