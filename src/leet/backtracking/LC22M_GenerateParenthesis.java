package leet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22M_GenerateParenthesis {
	// 3pm-325pm with eclipse
	// CONCLUSION: USE A PROPER EXAMPLE FOR BACKTRACKING.. AND DON'T FORGET TO
	// BACKTRACK!!!!!!

	// 0 or n<0 -empty arraylist
	// 1 - ()
	// 2 - (()) ()()
	// 3 - "((()))", "(()())", "(())()", "()(())", "()()()"

	// countOpen >= countClosed for every i from 1 to n

	// start with countOpen = n, countClosed = n
	// insert countOpen first - (
	// insert either ) or another countOpen if it's valid (countOpen > 0)
	// recurse with the updated countOpen

	// ((())), (()()), (())()

	// ""
	// ( 2,3
	// (( 1,3
	// ((( 0,3
	// ((() 0,2
	// ((()) 0,1
	// ((())) 0,0

	// ((())

	List<String> pairs = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder();
		generateParenthesis(n, n, sb);
		return pairs;
	}

	public void generateParenthesis(int countOpen, int countClosed, StringBuilder sb) {
		if (countOpen == 0 && countClosed == 0) {
			pairs.add(sb.toString());
			return;
		}

		if (countOpen > 0) {
			sb.append("(");
			//countOpen--;
			generateParenthesis(countOpen-1, countClosed, sb);
			sb.setLength(sb.length() - 1);
			//countOpen++;
		}

		if (countClosed > 0 && countClosed > countOpen) { // <----- used less than instead of greater than!!!
			sb.append(")");
			//countClosed--;
			generateParenthesis(countOpen, countClosed-1, sb);
			//countClosed++;
			sb.setLength(sb.length() - 1);

		}
	}

	public static void main(String args[]) {
		int n = 3;
		LC22M_GenerateParenthesis gp = new LC22M_GenerateParenthesis();
		for (String s : gp.generateParenthesis(n))
			System.out.println(s);
	}
}
