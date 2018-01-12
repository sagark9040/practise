package leet.array;


/// THIS QTN REQUIRES A LOT OF BACK AND FORTH WITH THE INTERVIEWER!!!!!




public class LC65H_ValidNumber {

	/*
 	Validate if a given string is numeric.

	Some examples:
	"0" => true
	" 0.1 " => true
	"abc" => false
	"1 a" => false
	"2e10" => true
	Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
	*/
	
	// Strip spaces
	// All numbers is valid
	// All numbers with one dot
	// All numbers with no space is valid
	// 2e10 is valid as it has one E only, preceded by and followed by  number
	// Minus sign or plus sign is okay only at the beginning.
	
	public boolean isNumber(String s) {
		s = s.trim();
		
		if(s.indexOf('-') > 0 || s.indexOf('+') > 0 || s.length() == 0)
			return false;
		
		boolean hasDot = false, hasSpace = false, foundE = false;
		int i = -1, count = 0;
		for (char c: s.toCharArray()) {
			i++;
			
			if (c == ' ') return false;
			else if(c == '.') {
				if (hasDot) return false;
				else {
					hasDot = true;
					if (s.length() == 1)
						return false;
				}
			} else if(c == 'e') {
				if(foundE) return false;
				else foundE = true;
				
				if(i == 0 || i == s.length()-1)
					return false;
				else if (!isDigit(s.charAt(i-1)) || !isDigit(s.charAt(i+1)))
					return false;
			} else if (!Character.isDigit(c)) {
				if((i == 0 && (c == '-' || c == '+'))) {}
				else
					return false;
			} else {
				if (Character.isDigit(c))
					count++;
			}
		}
		
		return count > 0;
    }	
	
	public boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String args[]) {
		LC65H_ValidNumber num = new LC65H_ValidNumber();
//		System.out.println(num.isNumber("1+2"));
//		System.out.println(num.isNumber("1.2"));
//		System.out.println(num.isNumber("1.2."));

//			Some examples:
//			"0" => true
//			" 0.1 " => true
//			"abc" => false
//			"1 a" => false
//			"2e10" => true

		System.out.println(num.isNumber(".e1"));
		System.out.println(num.isNumber("-1."));
		System.out.println(num.isNumber(" "));
		System.out.println(num.isNumber("3."));
		System.out.println(num.isNumber("0"));
		System.out.println(num.isNumber(" 0.1"));
		System.out.println(num.isNumber("abc"));
		System.out.println(num.isNumber("1 a"));
		System.out.println(num.isNumber("2e10"));
		System.out.println(num.isNumber("."));		
	}
}
