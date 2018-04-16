package leet.math;

public class LC191E_HammingWeightCount1sInNumberBit {
	public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count = (n & 1) == 1 ? count+1 : count;
            n = n >>> 1;
        }    
        return count;
    }
	
	public static void main(String args[]) {
		int n = Integer.MAX_VALUE;
		LC191E_HammingWeightCount1sInNumberBit h = new LC191E_HammingWeightCount1sInNumberBit();
		System.out.println(h.hammingWeight(n));
		
	}
}

//  2147483648 (10000000000000000000000000000000)