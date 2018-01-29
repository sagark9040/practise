package leet.array;

import java.util.HashSet;
import java.util.Set;

public class LC414E_ThirdMax {
	public static int thirdMax(int[] nums) {
	   int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
       Set<Integer> count = new HashSet<Integer>(3);
       
        
        for(int num:nums) {
        	count.add(num);
        	
            if(num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (num < max && num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num < secondMax && num >= thirdMax) {
                thirdMax = num;
            }
        }
        
        return (count.size() >= 3) ? thirdMax : max;
    }
	
	public static void main(String args[]) {
		int[] a = {1,2,2,5,3,5};
		System.out.println(thirdMax(a));	
	}
}
