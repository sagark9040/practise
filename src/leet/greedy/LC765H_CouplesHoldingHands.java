package leet.greedy;

import java.util.HashMap;

public class LC765H_CouplesHoldingHands {
//430pm -- 530 pm 
//wasn't that hard.. didn't think of data structures to use!! HashMap son!!!	

    
    //[0,1] = true
    //[0,2,1,3,4,5]
    //[0,2,1,3,4,5]
    
    //[0,1,3,4,5,2]
    //[0,1] - all good
    //[0,1,3,4] - 1 mismatch
    //[0,1,3,4,5,6] - 2 mismatch = 1 previous + 1 current
    //    [3,4,5,6]
    
    // 043512
    // 013542
    // 052341
    
    //Brute Force
    //take first pair and swap with the correct 2nd partner - O(n) time .. soln = O(n^2) worst case
    //
    
    //failed for [0,2,4,6,7,1,3,5] since the map was not updated properly
    
    
public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> positions = initMap(row);
        int count = 0;
                
        for(int i=0; i<row.length; i+=2) { // 0,2
            int firstNum = row[i];
            int secondNum = row[i+1];
            
            if((firstNum % 2 == 0 && secondNum == firstNum+1) || 
               (firstNum % 2 != 0 && secondNum == firstNum-1)) {
                continue;
            }
            int actualNum = firstNum % 2 == 0 ? firstNum+1 : firstNum-1;
            positions = swap(row, i+1, positions.get(actualNum), positions);
            count++;
            //System.out.println(count);
        }
        return count;   
    }
    
    HashMap<Integer, Integer> initMap(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int pos = 0;
        for(int r:row) {
            map.put(r, pos++);
        }
        return map;
    }
    
    HashMap<Integer, Integer> swap(int[] row, int firstPos, int secondPos, HashMap<Integer, Integer> map) {
    	int numSec = row[firstPos];
    	map.put(numSec, secondPos);
    	map.put(row[secondPos], firstPos);
    	
        int temp = row[firstPos];
        row[firstPos] = row[secondPos];
        row[secondPos] = temp;
        return map;
    }
    
    public static void main(String args[]) {
    	int[] a = 
    	   {0,2,4,6,7,1,3,5};
    	//  0 1 4 6 7 2 3 5
    	//  0 1 4 5 7 2 3 6
    	//  0 1 4 5 7 6 3 2
    		
    	
    	LC765H_CouplesHoldingHands c = new LC765H_CouplesHoldingHands();
    	System.out.println(c.minSwapsCouples(a));
    }
}
