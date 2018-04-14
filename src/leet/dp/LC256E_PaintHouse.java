package leet.dp;

public class LC256E_PaintHouse {
	 
    //1204 .. looked at soln
    //red, blue, green

    //len = 0
    //len = 1 .. min of cost[0][0] .. 01 .. 02
    //len = 2 .. two mins of cost[0][0] .. 01 .. 02
    //len = 3 .. min of two costs
    //len = 4 .. min of two costs
    //len = 5 .. min of two costs 
    
    
    
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int len = costs.length;
        for(int i=1; i<costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(costs[len-1][0], Math.min(costs[len-1][1], costs[len-1][2]));        
    }
}
