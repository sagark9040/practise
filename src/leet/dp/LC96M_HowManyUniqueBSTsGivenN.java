package leet.dp;

public class LC96M_HowManyUniqueBSTsGivenN {
	
	//Was close, should've continued and not given up at n=3 
	//Then learned from Tushar Roy's solution
	//On the right track
	
	public int numTrees(int n) {
        int[] total = new int[n+1];
        total[0] = 1;
        total[1] = 1;
        
        for(int i=2; i<=n; i++) {
            int sum = 0;
            for(int j=0; j<i; j++) {
                sum += total[j] * total[i-j-1];
            }
            total [i] = sum;
        }
        
        return total[n];
    }
}
