package leet.dp;

import java.util.Arrays;

//Took longer than expected!!

public class LC746_MinCostClimbingStairs {
	int[] climbingCost;
    int[] cost;
    public int minCostClimbingStairs(int[] c) {
        
        cost = getCost(c);
        climbingCost = new int[cost.length+1];
        Arrays.fill(climbingCost, -1);
        
        return calcCost(climbingCost, cost.length-1);        
    }
    
    public int calcCost(int[] cc, int t) {
        if(t == 0) {
            return cost[0];
        } else if (t == 1) {
            return cost[1];
        } else {
            if(cc[t] >= 0) {
                return cc[t];
            } else {
                cc[t] = Math.min(calcCost(cc, t-1), calcCost(cc, t-2)) + cost[t]; // 				<--- OFF BY ONES!!!
                return cc[t];
            }
        }
    }
    
    int[] getCost(int[] c) {
        int[] cost = new int[c.length+1];
        int pos = 0;
        for(int cur:c) {
            cost[pos] = cur;
            pos++;
        }
        cost[pos] = 0;
        return cost;
    }
}
