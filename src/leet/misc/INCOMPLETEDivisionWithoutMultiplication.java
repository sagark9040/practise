package leet.misc;


// Fails
//-2147483648
//-1


public class INCOMPLETEDivisionWithoutMultiplication {
	public static void main(String args[]){
		System.out.println(divide(1, -1));
	}
	
	public static int divide(int dividend, int divisor) {
	    //handle special cases
	    if(divisor==0) return Integer.MAX_VALUE;
	    if(divisor==-1 && dividend == Integer.MIN_VALUE)
	        return Integer.MAX_VALUE;
	 
	    //get positive values
	    long pDividend = Math.abs((long)dividend);
	    long pDivisor = Math.abs((long)divisor);
	 
	    int result = 0;
	    while(pDividend>=pDivisor){
	        //calculate number of left shifts
	        int numShift = 0;    
	        while(pDividend>=(pDivisor<<numShift)){
	            numShift++;
	        }
	 
	        //dividend minus the largest shifted divisor
	        result += 1<<(numShift-1);
	        pDividend -= (pDivisor<<(numShift-1));
	    }
	 
	    if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
	        return result;
	    }else{
	        return -result;
	    }
	}
	public static int divides(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        if(divisor == 1)
            return dividend;
        if(dividend == 0)
            return 0;
        
        boolean dividendIsNeg = false, divisorIsNeg = false;
        if(dividend < 0)
            dividendIsNeg = true;
        
        if(divisor < 0)
            divisorIsNeg = true;
        boolean minValue = false;
        
        
        if(dividend == Integer.MIN_VALUE) {
        	dividend = Integer.MAX_VALUE;
        	minValue = true;
        }
        	
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int multiplication = 1;
        int quotient = 0;
        
        while(multiplication < dividend){
            multiplication += divisor;
            quotient++;
        }
        
        if(dividendIsNeg && divisorIsNeg)
            return quotient;
        if(dividendIsNeg || divisorIsNeg){
        	
        	if(minValue)
        		return -(quotient+1);
        	
            return -quotient;
        }
        return quotient;
    }
}
