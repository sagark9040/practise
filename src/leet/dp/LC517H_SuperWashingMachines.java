package leet.dp;

public class LC517H_SuperWashingMachines {
	// 1208 pm 45 mins
	// TC failed for [4,0,0,4] didn't account for two machines doing the same transfer.
	
	//0044
	//
	
	 public int findMinMoves(int[] machines) {
	        if(machines.length == 1) {
	            return 0;
	        }
	        
	        if(validAvg(machines)) {
	            int count = 0, max = 0;
	            int avg = getSum(machines) / machines.length;
	            for(int i=0; i<machines.length; i++) {
	                count += machines[i] - avg;
	                max = Math.max(Math.max(max, Math.abs(count)), machines[i]-avg);
	            }            
	            return max;
	        } else {
	            return -1;
	        }
	    }
	    
	    public boolean validAvg(int[] machines) {
	        return getSum(machines) % machines.length == 0;
	    }
	    
	    public int getSum(int[] machines) {
	        int sum = 0;
	        for(int machine:machines) {
	            sum += machine;
	        }
	        return sum;
	    }
}

/**
1208

[12345]
[22245] - 2
[32235] - 5
[33234] - 8
[33333] - 10

[123] - 1 - [222]

//calculate average value
//114 
//213
//222

141

105

if(averageIsFine()){
	for(int i=0; i<len; i++) {
		if(num[i] < avg) {
			count += Math.abs(avg - num);
		}
	}
}

sum has to be % = 0

//46/100 TCs
//Didn’t cover 4,0,0,4 TC of simultaneous transfer, didn’t even think of it.

*/
