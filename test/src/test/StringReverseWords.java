package test;

import java.util.Stack;

public class StringReverseWords {
	public static char[] reverse (String str) {
		char[] charArr = str.toCharArray();
		if (null == str || str.length() < 2)
			return str.toCharArray();
		
		for (int i=0; i <(str.length()/2); i++) {
			char temp = charArr[i];
			charArr[i] = charArr[str.length()-1-i];
			charArr[str.length()-1-i] = temp;		
		}
		
		Stack<Character> s = new Stack<Character>();
		int lastBlank = 0;
		for (int i=0;i<charArr.length;i++) {
			
			if(charArr[i]==' ') {
				int j = 0;
						s.push(' ');				
				while (!s.isEmpty()) {
					charArr[lastBlank+j] = s.pop();
					j++;
				}	
				lastBlank = i;
				s.clear();
			}
			else{
				s.push(charArr[i]);
			}
		}
		
		int j = 0;				
		while (!s.isEmpty()) {
			charArr[lastBlank+j] = s.pop();
			j++;
		}
		return charArr;
	}
	
	public static void main (String args[]) {
		//System.out.println(reverse(""));
		//System.out.println(reverse("s"));
		//System.out.println(reverse("sa"));
		System.out.println(reverse("sagar kangutkar"));
		System.out.println(reverse(" sagar  kangutkar  java"));
	}
}
