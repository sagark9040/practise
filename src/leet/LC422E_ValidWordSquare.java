package leet;

import java.util.ArrayList;
import java.util.List;

public class LC422E_ValidWordSquare {
	
	//1205
	//null? true
	//lowercase? digits? ASCII or unicode? length-how long?
	//if m not equal to n then false
	
	
	public boolean validWordSquare(List<String> words) {
		
		//base case, empty list = true
		if(words == null || words.size() == 0) {
			return true;
		}
		int n = words.size();
		//assumption - lowercase, all alph only, ascii
		for(int i=0; i<n; i++){
            for(int j=0; j<words.get(i).length(); j++){
                if(j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
		
		return true;
    }

	@SuppressWarnings("unused")
	private char getChar(List<String> words, int i, int j) {
		if(words == null || i >= words.size() || j >= words.size() || words.get(i).length() >= j || words.get(j).length() >= i) {
			return '.';
		} else {
			return words.
					get(i).
					charAt(j);
		}
	}
	
	public static void main(String args[]) {
		List<String> l = new ArrayList<String>();
//		l.add("abcd");
//		l.add("bnrt");
//		l.add("crm");
//		l.add("dt");
		
		l.add("abc");
		l.add("b");
		
		LC422E_ValidWordSquare v = new LC422E_ValidWordSquare();
		System.out.println(v.validWordSquare(l));
 	}
}

/*

Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

Note:
The number of words given is at least 1 and does not exceed 500.
Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.
Example 2:

Input:
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crm".
The fourth row and fourth column both read "dt".

Therefore, it is a valid word square.
Example 3:

Input:
[
  "ball",
  "area",
  "read",
  "lady"
]

Output:
false

Explanation:
The third row reads "read" while the third column reads "lead".

Therefore, it is NOT a valid word square.

*/