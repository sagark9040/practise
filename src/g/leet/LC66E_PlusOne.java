package g.leet;

public class LC66E_PlusOne {
	public static int[] plusOne(int[] digits) {
        if(digits.length < 1)
            return digits;
        
        int leftOver = 0;
        int[] plusOne = digits;
        boolean isFirstDigit = true;
        
        int pos = digits.length-1;
        for(pos = digits.length-1; pos >= 0; pos--){
            
        	int sum = digits[pos] + leftOver;
            
            if(isFirstDigit) {
               sum++;  
               isFirstDigit = false;
            }
            
            int newDig = 0;
            if(sum >= 10){
                newDig = sum%10;
                leftOver = 1;
            }
            else{
                newDig = sum;
                leftOver = 0;
            }
            plusOne[pos] = newDig;            
        }
        if(leftOver == 1){
            int[] newPlusOne = new int [plusOne.length+1];
            newPlusOne[0] = 1;
            int p = 1;
            for(int curDigi: plusOne){
            	newPlusOne[p] = curDigi;
            	p++;
            }
            return newPlusOne;
        }
        return plusOne;            
    }
	
	public static void main(String args[]){
	
		// printArray(plusOne(new int[]{9}));
		printArray(plusOne(new int[]{9,9}));
	}

	private static void printArray(int[] js) {		
		for(Integer i: js)
			System.out.print(i + " ");
		
		System.out.println();
	}
}
