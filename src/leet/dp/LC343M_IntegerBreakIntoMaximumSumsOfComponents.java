package leet.dp;

public class LC343M_IntegerBreakIntoMaximumSumsOfComponents {
	public int integerBreak(int n) {
        if(n<4) {
            return n-1;
        }
        int[] sums = initSums(n+1);
        for(int i=5; i<=n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=1; j<=(i+2)/2; j++) {
                max = Math.max(sums[j]*sums[i-j], max);
            }
            sums[i] = max;
        }
        return sums[n];
    }
    
    public int[] initSums(int n) {
        int[] sums = new int[n];
        sums[0] = 0;
        sums[1] = 1;
        sums[2] = 2;
        sums[3] = 3;
        sums[4] = 4;
        return sums;
    }
}
