package ctci.dpAndRec;

public class Q89_PairsOfValidParenthesis {
	public static void main(String args[]) {
		int n = 3;
		char[] slots = new char[n*2];		
		parenthesisPairs(0, slots, n, n);
	}

	private static void parenthesisPairs(int pos, char[] slots, int op, int cl) {
		if(pos == slots.length) {
			print(slots);
			return;
		}
		if(op <= cl && op > 0) {
			slots[pos] = '('; 
			parenthesisPairs(pos+1, slots, op-1, cl);
		}
		if(cl > 0) {
			slots[pos] = ')'; 
			parenthesisPairs(pos+1, slots, op, cl-1);
		}
	}

	private static void print(char[] slots) {
		for(char c:slots)
			System.out.print(c);
		
		System.out.println();
	}
	
}
