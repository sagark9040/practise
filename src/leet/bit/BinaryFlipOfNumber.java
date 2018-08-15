package leet.bit;

public class BinaryFlipOfNumber {
    public int findComplement(int num) {
        int res = 0, i = num;
        while(i > 0) {
        	int dig = i%2;
        	
        	if(dig == 1)
        		res = res * 2 + 0;
        	else 
        		res = res * 2 + 1;
        	
        	i/=2;
        }
        return res;
    }
    
    public static void main(String args[]) {
    	int num = 8;
    	BinaryFlipOfNumber flip = new BinaryFlipOfNumber();
    	System.out.println(flip.findComplement(num));
    	//System.out.println(5 ^ 1);
    }
}

//101
//