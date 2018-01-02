package leet.string;

/*

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

 */


// TCs
// 1. A is empty
// 2. B is empty
// 3. A is bigger than B
// 4. B is bigger than A
// 5. A and B are both same
// 6. A and B are never compatible


public class LC686E_RepeatedStringMatch {
	
	int match(String a, String b, int count){
		if(a.length() == 0 || b.length() == 0)
			return -1;
				
        StringBuilder newA = new StringBuilder(a);
		while(newA.length() <= b.length()){
			if(newA.indexOf(b) >= 0)
				return count;
			
			newA.append(a);
			count++;
		}
        if(newA.append(a).indexOf(b) >= 0)
            return count+1;
        
		
		return -1;
	}
	
	public static void main(String args[]){
		LC686E_RepeatedStringMatch getMinMatch = new LC686E_RepeatedStringMatch();
		System.out.println(getMinMatch.match("", "cdabcdab", 1));
		System.out.println(getMinMatch.match("abcd", "", 1));
		System.out.println(getMinMatch.match("abcd", "cdabcdab", 1));
		System.out.println(getMinMatch.match("abcd", "s", 1));
		System.out.println(getMinMatch.match("s", "cdabcdab", 1));
		System.out.println(getMinMatch.match("abcd", "abcd", 1));
		System.out.println(getMinMatch.match("abababaaba", "aabaaba", 1));
		System.out.println(getMinMatch.match("abcd", "cdabcdab", 1));
	}
}