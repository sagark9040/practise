package leet.greedy;

public class LC134M_GasStation {
	
	//20 mins for initial 11/16 TCs
	//Corner cases were a problem. This below is a LC soln. Fuck me!
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sumGas = 0;
		int sumCost = 0;
		int start = 0;
		int tank = 0;
		for (int i = 0; i < gas.length; i++) {
			sumGas += gas[i];
			sumCost += cost[i];
			tank += gas[i] - cost[i];
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		if (sumGas < sumCost) {
			return -1;
		} else {
			return start;
		}
	}
}
