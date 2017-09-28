package src.in.gd;


public class SquareRootOfNumber {

	static double getSquareRoot (double number) {
		
		if (number < 0) {
			System.out.println("Negative number will not have a square root.");
			return -1;
		}
		
		double low = 0;
		double high = number + 1;
		double mid = (low+high)/2;
		double epsilon = 0.0000001;
		
		if (number == 0 || number == 1)
			return number;
		
		while (Math.abs(number - (mid * mid)) > epsilon) {

			if (number > mid*mid)
				low = mid + epsilon;
			else
				high = mid - epsilon;
			
			//System.out.println(low + " " + mid + " " + high);
			
			mid = (double)(low+high)/2;			
		}
		
		return mid;

	}

	public static void main (String args[]) {
		
		System.out.println(getSquareRoot(0));
		System.out.println(getSquareRoot(0.25));
		System.out.println(getSquareRoot(1));
		System.out.println(getSquareRoot(2));
		System.out.println(getSquareRoot(3));
		System.out.println(getSquareRoot(4));
		System.out.println(getSquareRoot(24));
		
	}
}
