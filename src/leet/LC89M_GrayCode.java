package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC89M_GrayCode {
	//OPTIMAL SOLN AT THE BOTTOM
	
	//307pm --> 337 pm suboptimal
    //n=2    //00    //01    //11    //10
    //n=3 000 001 010 100 .. 011  101 .. 111 .. 110
    //Greedy way:
    //0 .. check next (1,2,3) .. cur ^ next = powOfTwo (contains one 1)
    //0, 1 check next (2, 3) .. 0, 1, 3
    //0, 1, 3, 2
    
    //n=3
    //start = 0, bal = 1 to 2^n-1 == 1,2,3,4,5,6,7
    //0, 1 .. bal = 2->7
    //0, 1, 3 .. bal = 2, 4->7
    //0, 1, 3, 2 bal = 4->7 
    //0, 1, 3, 2, 6 bal = 4,5,7
    //0, 1, 3, 2, 6, 4 bal = 5, 7
    //0, 1, 3, 2, 6, 4, 5 bal = 7
    //0, 1, 3, 2, 6, 4, 5, 7 bal = 0, print
    //put a condition where no option available, then circle back
    
    //(start, balanceSet, result)
    //print result if balanceSet = 0 and return
    //iterate (balanceSet and check for every elem and XOR with start)
        //if xor = pow of two?
        //add curr to result and remove from balance set and recur (cur = start, newBal, res)
        //
    
    
    //TCs
    //2^n for n>=1 .. 
    //n=0
    //
	
	int[] result;
    public List<Integer> grayCodeSubOptimal(int n) {
        if(n<1) {
            return Arrays.asList(0);
        }
        
        int start = 0;
        int[] balanceNums = initBalanceNums(n);
        result = new int[(int) Math.pow(2, n)];
        result[0] = start;
        fillResult(start, balanceNums, result, 1);
        
        return result(result);
    }
    
    private List<Integer> result(int[] result2) {
    	List<Integer> res = new ArrayList<Integer>();
    	for(int i:result2) 
    		res.add(i);
		return res;
	}

	private int[] initBalanceNums(int n) {
		int[] bal = new int[(int)Math.pow(2, n)];
		
    	for(int i=1; i<bal.length; i++) {
    		bal[i] = 1;
    	}
		return bal;
	}

	public void fillResult(int start, int[] balanceNums, int[] result, int pos) {
        if(pos == result.length || balanceNums == null || balanceNums.length == 0) {
            return;
        } 
        
        for(int i=0; i<balanceNums.length; i++) {
            if(balanceNums[i] > 0 && isValid(i, start)) {
                result[pos++] = i;
                start = i;
                balanceNums[i] = 0;               
                fillResult(start, balanceNums, result, pos);
            }
        }
        
    }
    
    public boolean isValid(int cur, int prev) {
        int xOR = cur^prev, oneCount = 0;
        while(xOR > 0){
            oneCount += xOR & 1;
            xOR = xOR >> 1;
        }
        return oneCount == 1;
            
    }
    
    public List<Integer> grayCode(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--) {
            	int oneShift = 1<<i;
                rs.add(rs.get(k) | oneShift);
            }
        }
        return rs;
    }
    
    public static void main(String args[]) {
    	LC89M_GrayCode g = new LC89M_GrayCode();
    	for(int i:g.grayCode(2)) 
    		System.out.print(i);
    	System.out.println();
    	for(int i:g.grayCode(3)) 
    		System.out.print(i);
    	System.out.println();
    	for(int i:g.grayCode(0)) 
    		System.out.print(i);
    	System.out.println();
    	for(int i:g.grayCode(1)) 
    		System.out.print(i);
    	System.out.println();
    	for(int i:g.grayCode(-1)) 
    		System.out.print(i);    	
    }
}
