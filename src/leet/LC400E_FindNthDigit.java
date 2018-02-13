package leet;

import java.util.Stack;

public class LC400E_FindNthDigit {

	//Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
	//330pm
	
	//BruteForce = append string of current number to a pre-existing value. Return get(n-1)
	//1 to 9 = 9 [x1] .. digit 1 to digit 9 = 9 digits
	//10 to 99 = 90 [x2] .. 180 digits
	//100 to 999 = 900 [x3] .. 3*900 = 2700 digits
	//1000 to 9999 = 9000 [x4] = 36000 digits

	//Use a loop to first kind of narrow down the nth digit to one of the above ranges.
	//1905th
	//1905 - 180 = 1725th = 100+575 = 675 .. 5 is the answer

	//Corner cases .. nth falls on 100 or 99 or 999 or 10 or 1000
	
	public static void main(String args[]) {
		LC400E_FindNthDigit find = new LC400E_FindNthDigit();
		System.out.println(find.findNthDigit(10));
	}
	
	public int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
	
	public int findNthDigitBuggy(int n) {
		if(n < 10) {
			return n;
		}
		
		int powerOfTen = 2, lowerBound = 10, upperBound = 99, previousDigits = 9;
		while(true) {
			lowerBound = (int) Math.pow(10, powerOfTen-1);			//10
			upperBound = (int) (Math.pow(10, powerOfTen) - 1);      //99
			int nextDigits = previousDigits + powerOfTen * ((int) Math.pow(10, powerOfTen) - (int) Math.pow(10, powerOfTen-1));

			//n = 300
			if(n > previousDigits && n <= nextDigits) {

				int diff = (n-previousDigits)/powerOfTen;
				int actualNum = lowerBound + diff/powerOfTen; 
				int pos = diff % powerOfTen;
				
				return posOfDigitInNumber(actualNum, pos);
			}
			
			
			// 9 + 2*(100-10) = 9 + 180 = 189
			
			
			previousDigits = nextDigits;
			
			
			powerOfTen++;
		}
    }

	private int posOfDigitInNumber(int actualNum, int pos) {
		int num = actualNum; 
		Stack<Integer> stk = new Stack<Integer>();
		
		while(num > 0) {
			int curDigit = num%10;
			stk.add(curDigit);
			num = num/10;
		}
		int count = 0;
		while(!stk.isEmpty()) {
			if(count == pos) {
				return stk.pop();
			} else {
				stk.pop();
			}			
			count++;
		}
		return 0;
	}
	
}

/*
Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

*/