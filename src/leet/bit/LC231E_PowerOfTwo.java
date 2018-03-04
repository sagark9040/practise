package leet.bit;

public class LC231E_PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
        int numOfOnes = 0;
        while(n > 0) {
            numOfOnes += ((n & 1) == 1 ? 1 : 0);     
            n /= 2;
        }
        return numOfOnes == 1;
    }
}
