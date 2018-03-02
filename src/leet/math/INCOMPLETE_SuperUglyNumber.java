package leet.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class INCOMPLETE_SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Integer> skipPrimeFactors = getSkipPrimeFactors(primes[primes.length-1], primes);     
        int count = 1;
        int uglyNumber = 1;
        for(int i=2; i<Integer.MAX_VALUE && count < n; i++) {
            if(isDivisible(i, skipPrimeFactors)) {
                continue;
            } else {
                uglyNumber = i;   
                System.out.println(i);
                count++;
            }
        }
        return uglyNumber;
    }
    
    public boolean isDivisible(int num, Set<Integer> skipPrimeFactors) {
        for(int p:skipPrimeFactors) {
            if(num % p == 0 && p > 1) {
                return true;
            }
        }
        return false;
    }
    
    public Set<Integer> getSkipPrimeFactors(int last, int[] primeNums) {
        Set<Integer> primes = new HashSet<Integer>();
        fillSieve();
        for(int p:primeNums)
            primes.add(p);
        Set<Integer> skipPrimeFactors = new HashSet<Integer>();
        for(int i=2; i<=999; i++) {
            if(isPrime(i) && 
            		!primes.contains(i)) {
                skipPrimeFactors.add(i);
            }
        }
        return skipPrimeFactors;
    }
    
    boolean[] primes=new boolean[1000];
    public void fillSieve() {
        Arrays.fill(primes,true);        // assume all integers are prime.
        primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
        for (int i=2;i<primes.length;i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
    }

    public boolean isPrime(int n) {
    	
        return primes[n];
    }
    
    public static void main(String args[]) {
    	int[] primes = {2, 7, 13, 19};
    	INCOMPLETE_SuperUglyNumber su = new INCOMPLETE_SuperUglyNumber();
    	System.out.println(su.nthSuperUglyNumber(12, primes));
    }
}
