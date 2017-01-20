package test;

/*
Given a length n, return the number of strings of length n that can be made up of the letters 'a', 'b', and 'c', 
where there can only be a maximum of 1 'b's and can only have up to two consecutive 'c's 

a - n, b - 1, c - (2n+1)/3 




Example: 
findStrings(3) returns 19 
since the possible combinations are: aaa,aab,aac,aba,abc,aca,acb,baa,bac,bca,caa,cab,cac,cba,cbc,acc,bcc,cca,ccb
and the invalid combinations are: 
abb,bab,bba,bbb,bbc,bcb,cbb,ccc
 */

public class LettersFormed {

	static void print(int n, int count, char[] res, int a, int b, int c) {
		if (count == res.length) {
			System.out.println(res);
			return;
		}
		
		if (a>0) {
			res[count] = 'a';
			print(3, count+1, res, a-1, b, c);
		}
		
		if (b>0) {
			res[count] = 'b';
			print(3, count+1, res, a, b-1, c);
		}
		
		if (!(count > 1 && res[count-1] == 'c' && res[count-2] == 'c')) {
			res[count] = 'c';
			print(3, count+1, res, a, b, c-1);	
		}			
	}
	
	public static void main (String args[]) {
		int n = 4;
		print (n, 0, new char[n], n, 1, (2 * n+1)/3);
	}
	
}
