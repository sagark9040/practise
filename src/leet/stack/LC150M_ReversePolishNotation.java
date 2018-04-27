package leet.stack;

import java.util.Stack;

public class LC150M_ReversePolishNotation {
	public int evalRPN(String[] tokens) {
        //853 .. 11 min AC!!
        //if num add to stack
        //if operator - remove top two numbers from stack, perform operation and put result back on the stack
        if(tokens == null || tokens.length == 0)    return 0;
        if(tokens.length == 1)  return Integer.parseInt(tokens[0]);
        
        Stack<Integer> stk = new Stack<>();
        
        for(String token:tokens) {
            if(isNumeric(token))    stk.push(Integer.parseInt(token));
            else {
                int b = stk.pop();
                int a = stk.pop();
                stk.push(getResult(a, b, token));
            }
        }
        
        return stk.pop();
    }
    
    public int getResult(int a, int b, String token) {
        double result = 0d;
        
        if(token.equals("+")) result = a+b;
        else if(token.equals("-")) result = a-b;
        else if(token.equals("*")) result = a*b;
        else if(token.equals("/")) result = a/b;
        
        return (int) result;
    }
    
    public static boolean isNumeric(String str) {  
      try {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe) {  
        return false;  
      }  
      return true;  
    }
}
