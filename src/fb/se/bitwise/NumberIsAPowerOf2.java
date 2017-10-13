package fb.se.bitwise;

public class NumberIsAPowerOf2 {

	public static void main(String args[]){
		
		int one = 1;
		int powerOne = 2;
		int powerTwo = 4;
		int nonPowerTwo = 6;
		int nonPowerTwoNum = 10;
		
		System.out.println(isPowerOfTwo(one));
		System.out.println(isPowerOfTwo(powerOne));
		System.out.println(isPowerOfTwo(powerTwo));
		System.out.println(isPowerOfTwo(nonPowerTwo));
		System.out.println(isPowerOfTwo(nonPowerTwoNum));
	}
	
	public static boolean isPowerOfTwo(int num){
		if (num == 1)
			return true;
		
		return (num & (num-1)) == 0;
	}	
}
// 110 = 6
// 101 = 5

// 1010
// 1001


// 101 = 5
// 100 = 4

// 100 = 4
//  11