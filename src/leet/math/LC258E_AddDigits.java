package leet.math;

public class LC258E_AddDigits {
	public int addDigits(int num) {
        if(num < 1) {
            return num;                
        }
        
        int sum = getSum(num);
        while(sum > 9) {
            sum = getSum(sum);
        }
        
        return sum;
    }
    
    public int getSum(int num) {
        int sum = 0;
        
        while(num > 0) {
            sum += num%10;
            num /= 10;
        }
        
        return sum;
    }
}
