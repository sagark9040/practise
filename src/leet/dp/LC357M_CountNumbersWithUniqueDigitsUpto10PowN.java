package leet.dp;

public class LC357M_CountNumbersWithUniqueDigitsUpto10PowN {
	//CONCLUSION:
	//Came up with Brute Force O(N) and then almost came up with logic for the optimal solution.	
	
    //845p
    //Thought of 2 brute forces:
    //1...set of digits for each num from 0 to 10^N...if found a new digit, then false and don't incr count
    //2...sort digits for each num from 0 to 10^N and same as above

    //After 20 mins of BF, derived a formula where
    //N=1 = N-0
    //N=2 = N^2 - 9
    //N=3 = N2 * 8
    
    
    //TCs
    //
    
    
    public int countNumbersWithUniqueDigits(int n) {
        int result = 10;
        if(n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } 
        
        int avblNums = 9;
        int multipliers = 9;
        int combos = 0;
        for(int i=2; i<= n; i++) {
            combos = avblNums * multipliers--;
            result += combos;
            avblNums = combos;
        }
        return result;
    }
}
