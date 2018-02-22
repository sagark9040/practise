package leet.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC762E_PrimeNumberOfSetBitsInBinaryRepresentation {
	//1037pm-1049pm AC
    public int countPrimeSetBits(int L, int R) {
        int countPrimeSets = 0;
        for(int val=L; val<=R; val++) {
            int countOnes = countOnes(val);
            if(isPrime(countOnes)) {
                countPrimeSets++;
            }
        }
        return countPrimeSets;
    }
    
    int countOnes(int v) {
        int count = 0;
        while(v > 0) {
            if((v & 1) == 1) {
                count++;
            }
            v = v >> 1;
        }
        return count;
    }
    
    boolean isPrime(int v) {        
        Integer[] a = new Integer[]{2,3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        Set<Integer> primes = new HashSet<Integer>(Arrays.asList(a));		//		<--------		WASN'T SURE ABOUT THIS
        return primes.contains(v);
    }
}
