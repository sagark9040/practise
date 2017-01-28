package in.gd.senDev;

import java.util.Stack;

public class ReversePolishNotation {

	/*static Stack stk = new Stack();
	
	static int rpn(char[] expression) {
		
		for(Character c:expression) {
			if(Character.isDigit(c)) {
				stk.push(Character.getNumericValue(c));
			}
			else{
				int a = (int) stk.pop();				
				int b = (int) stk.pop();
				
				switch (c){
					case '+':stk.push(a+b);break;
					case '-':stk.push(b-a);break;
					case '*':stk.push(a*b);break;
					case '/':stk.push(b/a);break;
				}
					
				
			}
		}
		
		if (stk.count != 1) {
			System.out.println("Error");
			return -1;
		}
		
		return stk.pop();
		
	}
	
	public static void main(String args[]) {
		
		char[] c = {'2','1'}; // = {'2', '1', '+', '3', '*'};

		System.out.println(rpn(c));
		
	}*/
	
}
