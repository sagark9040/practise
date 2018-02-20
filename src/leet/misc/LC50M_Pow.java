package leet.misc;

public class LC50M_Pow {
	// forgot the negatives !!!!!!!!!!!!!!!!
	//My soln didn't work for Integer.MIN_VALUE caused overflow and gave infinites.
	
    
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE && n > 1) {
            return 0.0d;
        }
        
        double res = getPow(x, Math.abs(n)); 
        return n < 0 ? 1/res : res;
    }
    
    public double getPow(double x, int n) {
        if(n==0)
            return 1;
        double half = myPow(x, n/2);
        if(n%2 == 0) {
            return half * half;
        } else {
            return x*half*half;
        }
    }
}
