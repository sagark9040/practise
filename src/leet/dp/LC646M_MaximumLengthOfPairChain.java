package leet.dp;

import java.util.Arrays;
import java.util.Comparator;

public class LC646M_MaximumLengthOfPairChain {
//123pm --> 140p AC .. saw 2D sorting technique
    
    public int findLongestChain(int[][] pairs) {
        if(pairs.length < 2) {
            return pairs.length;
        }
        
        Arrays.sort(pairs, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
                if(a[0] == b[0]){
                       return a[1] - b[1];
                }
                return a[0] - b[0];
            }  
        });
        
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        
        for(int i=0; i<pairs.length-1; i++) {
            for(int j=i+1; j<pairs.length; j++) {
                int[] iPair = pairs[i];
                int[] jPair = pairs[j];
                
                if(iPair[1] < jPair[0]) {
                    dp[j] = dp[i] + 1;
                }
            }            
        }
       
        return dp[pairs.length-1];
    }
}
