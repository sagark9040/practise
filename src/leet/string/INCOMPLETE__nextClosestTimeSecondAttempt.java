package leet.string;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


// TOOK OVER AN HOUR !!!! WTH !!!! 


public class INCOMPLETE__nextClosestTimeSecondAttempt {
	/*Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

	You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

	Example 1:

	Input: "19:34"
	Output: "19:39"
	Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
	Example 2:

	Input: "23:59"
	Output: "22:22"
	Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's tim
	*/
	
	// I was doing one digit at a time. KEY WAS TO CONVERT THE TIME INTO A NUMBER FOR CHECKING!!!!
	
	int[][] eligDigits = new int[][] {{0, 1, 2},{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {0, 1, 2, 3, 4, 5}, {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}};
	Set<Integer> digits = new TreeSet<Integer>();
	public String nextClosestTime(int[] time) {
		
		// 1212 pm
		// [012][0123456789]:[012345][0123456789]
		
		// TCs
		// 22:22 --> same numbers
		

		int[] digitsArray = new int[4];
		int pos = 0;
		
		for(int i:time) {
				digits.add(i);
				digitsArray[pos++] = i;
		}		
		
		for(int i=3; i>=0; i--) {
			digitsArray[i] = getNextLogicalValue(digitsArray[i], i);
		}
		
		return "";       
    }

	private int getNextLogicalValue(int curVal, int pos) {
		int nextVal = curVal + 1;
		nextVal = nextVal % eligDigits[pos].length;
		while(!digits.contains(nextVal)) {			
			nextVal ++;
			nextVal = nextVal % eligDigits[pos].length;
		}
		
		return nextVal; 
	}
	
	public static void main(String args[]) {
		INCOMPLETE__nextClosestTimeSecondAttempt next = new INCOMPLETE__nextClosestTimeSecondAttempt();
		//next.nextClosestTime(new int[]{2,2,3,4});
		next.next("01:01");
	}
	
	public String next(String time) {
		
		int minutes = Character.getNumericValue(time.charAt(4)) +
						Character.getNumericValue(time.charAt(3)) * 10 + 
							Character.getNumericValue(time.charAt(1)) * 60 + 
								Character.getNumericValue(time.charAt(0)) * 720;
		
		Set<Integer> digits = new HashSet<Integer>();
		digits.add(Character.getNumericValue(time.charAt(4)));
		digits.add(Character.getNumericValue(time.charAt(3)));
		digits.add(Character.getNumericValue(time.charAt(1)));
		digits.add(Character.getNumericValue(time.charAt(0)));
		
		System.out.println(minutes);
		
		for(int i=0; i<1440; i++) {
			
		}
		
		//int[] digits = getDigits(time);
		return "";
	}

	private int[] getDigits(String time) {

		int pos = 0;
		
		for(char c: time.toCharArray()) {
			System.out.println(c);
			if (c != ':')
				digits.add(Character.getNumericValue(c));
		}
		
		System.out.println("All eligible timings");
		
		Set<Integer> elig = new HashSet<Integer>();
		
		int[] tim = new int[4];
		for (int i=3; i>=0; i--) {
			for(int d: digits) {
				
			}
		}
		
		return null;
	}
}
