package leet.misc;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
	    int end = 1<<n;
	    for (int i = 0; i < end; i++) {
	    	int valI = i;
	    	int valShift = i>>1;
	    	int res = i ^ i>>1;
	    	
	    	result.add(res);
	    	
	    }
	    return result;
	}
	public static void main(String args[]) {
		grayCode(2);
	}
}
