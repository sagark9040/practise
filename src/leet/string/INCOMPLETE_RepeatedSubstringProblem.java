package leet.string;

public class INCOMPLETE_RepeatedSubstringProblem {
	boolean repeatFound = true;
	public boolean repeatedSubstringPattern(String s) {
		if(s.length() %2 == 1)
			return false;
		
		helper(s);
		return repeatFound;
    }

	private void helper(String s) { //0123 //012345
		int l = 0, r = (s.length()+1)/2;
		while(r<s.length() && repeatFound) {
			if(s.charAt(l) != s.charAt(r))
				repeatFound = false;
			l++; r++;
		}
	}
	
	public static void main(String args[]) {
		INCOMPLETE_RepeatedSubstringProblem r = new INCOMPLETE_RepeatedSubstringProblem();
		System.out.println(r.repeatedSubstringPattern("ababab"));		
	}
}

//int l = str.length();
//for(int i=l/2;i>=1;i--) {
//	if(l%i==0) {
//		int m = l/i;
//		String subS = str.substring(0,i);
//		StringBuilder sb = new StringBuilder();
//		for(int j=0;j<m;j++) {
//			sb.append(subS);
//		}
//		if(sb.toString().equals(str)) return true;
//	}
//}
//return false;