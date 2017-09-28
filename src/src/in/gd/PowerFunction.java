package src.in.gd;

public class PowerFunction {

	public static double pow(double a, int b){
		//check the validity of a and b
		if(a == 0 && b == 0)
			return Integer.MIN_VALUE;

		if(a == 0)
			return 0;

		if(b == 0)
			return 1;

		if(b == 1)
			return a;

		boolean aMinus = a < 0? true: false;
		boolean bMinus = b < 0? true : false;

		int bAbs = Math.abs(b);
		double aAbs = Math.abs(a);

		//check if b is odd
		double tempAnswer;
		if( (b & 1) != 0){
			tempAnswer = pow(aAbs, bAbs - 1) * aAbs;
		}
		else{
			tempAnswer = pow(aAbs * aAbs, bAbs / 2);
		}

		if(bMinus)
			tempAnswer = 1.0 / tempAnswer;
		if(aMinus && (b & 1)!= 0)
			tempAnswer *= -1;

		return tempAnswer;

	}
	
	
	/*
		
If you have a linkedIn phone interview, mostly this question will be asked to you. 

provide the simple solution first 
while loop (b times) 
{ 
result = result*a 
} 


Then note that it might be possible to divide this into smaller recursive problem. 
we can use the property that a^b = (a^2)^(b/2) 
here we square a, and divide b by 2. In doing this we divide the problem space into half. 

so essentially, 

when b i s even 
pow(a,b) = pow(a^2, b/2); 
when b is odd 
pow(a, b) = a*pow(a^2, b/2); 

Based on above, provide a recursive solution. 

Then note that recursion uses stack - which is essentially extra memory. 
To save on memory usage, we can convert this implementation into an iterative one. 
and then provide the solution with while loop. 

If you still have time, then note that 
for odd and even b, right shifting the bits by one is equivalent to dividing b by 2.so use b=b>>1, instead of division. 
also note that one can check if b is even or odd by this bit operation: if(b&01 === 1) implies that b is odd.

	 */
	
	static double powerIterative(double base, double coeff) {
		
		if (coeff == 1)
			return base;
		
		if (coeff == 0 )
			return 1;
		
		boolean isCoeffPositive = coeff > 0 ? true : false;
		boolean isCoeffEven = coeff%2 == 0 ? true: false;
		
		int count = 1;
		double result = 1;
		
		while (count <= Math.abs(coeff)/2) {
			result = result*base;
			count ++;
		}
		
		result *= result;
		
		if (!isCoeffEven)
			result *= base;
		
		if (!isCoeffPositive)
			return 1/result;
		
		return result;
		
	}

	public static void main(String[] args){
		
		System.out.println(powerIterative(2,4));
		System.out.println(powerIterative(2,-3));
		System.out.println(powerIterative(1,1));
		System.out.println(powerIterative(0,0));
		System.out.println(powerIterative(3,-2));
		System.out.println(powerIterative(7,3));
		
		return ;
	}
}

