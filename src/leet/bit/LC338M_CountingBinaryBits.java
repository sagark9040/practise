package leet.bit;

public class LC338M_CountingBinaryBits {
	
	//DP solution
	// VERY SLEEK SOLUTION.. EXECUTION IS NOT AT ALL MEDIUM LEVEL ONCE YOU GET THE IDEA RIGHT
	
	public int[] countBits(int num) {
		int[] soln = new int[num+1];
		soln[0] = 0;
		
		for(int i=1; i<=num; i++) {
			soln[i] = (soln[i>>1]) + (i & 1);
		}
		return soln;
	}
	
	
	public int[] MYSOLUTION_countBits(int num) {
        int[] allBits = new int[num+1];
        
        for(int i=0; i<=num; i++) {
            int count = 0;
            int j = i;
            while(j > 0) {		//				<-- Used i earlier here. Infinite loop
                if((j & 1) == 1) {
                    count++;
                }
                j = j >> 1;
            }
            allBits[i] = count;
        }
        return allBits;

    }
	
	public static void main(String args[]) {
		LC338M_CountingBinaryBits cb = new LC338M_CountingBinaryBits();
		for(int a:cb.countBits(5))
			System.out.println(a);
	}
}
