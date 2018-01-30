package leet.misc;

public class LC738M_MonotoneIncreasingDigits_Greedy {
	
	// Looked at the optimal solution after successfully attempting the brute force soln..lol
	// MOST IMPORTANT TAKEAWAY was knowing the point from right to left where the number is monotonic already. Marking the point down.
	// THEN COMING BACK TO THAT MARKED POINT AND UPDATING THE SOLUTIONS ACCORDINGLY
	
	public int monotoneIncreasingDigits(int N) {
	       
        char[] digits = String.valueOf(N).toCharArray();
        int nines = digits.length;
        for(int i=digits.length-1; i>0; i--) {
            if(digits[i] < digits[i-1]) {
                nines = i-1;
                digits[i-1]--;
            }
        }
        
        for(int i=nines+1; i<digits.length; i++)
            digits[i] = '9';
        
        return Integer.parseInt(new String(digits));
    }    
    
    public static int monotoneIncreasingDigitsBruteForce(int N) {
        for(int i=N; i>=1; i--){
            if(isMonotone(i))
                return i;
        }
        return 1;
    }
    
    public static boolean isMonotone(int num) {
        boolean isMonotone = true;
        int n = num, prev = 9;
        while(n>0) {
            int dig = n%10;
            if(prev < dig)
                return false;
            
            n=n/10;
            prev = dig;
        }
        
        return isMonotone;
    }
    
    public static void main(String args[]) {
    	monotoneIncreasingDigitsBruteForce(1994);
    }
}
