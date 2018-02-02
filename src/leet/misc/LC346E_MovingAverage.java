package leet.misc;

import java.util.LinkedList;
import java.util.Queue;

public class LC346E_MovingAverage {
	Queue<Integer> queue = null;
    int size = 0;
    int sum = 0;
    
    public LC346E_MovingAverage(int s) {
        queue = new LinkedList<Integer>();
        size = s;
    }
    
    public double next(int val) {
        if(queue.size() == size) {
            int remVal = queue.poll();
            sum -= remVal;            
        }
        queue.offer(val);
        sum += val;
        return (double) sum/queue.size(); 		/// forgot to add double!!!!!!
    }
    
    public static void main(String args[]) {
    	LC346E_MovingAverage m = new LC346E_MovingAverage(3);
    	System.out.println(m.next(1));
    	System.out.println(m.next(10));
    	System.out.println(m.next(3));
    	System.out.println(m.next(5));
    	
    }
}
