package src.in.gd;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Implement a stack using two queues 
 * Nov 6, 2016.
 */
public class StacksUsingQueue {

	//Stack methods
	//1. Push
	//2. Pop
	//3. Peek
	
	/*
	count=4
	total=7
	1|2|3|4| | | | 
	
	4
	3
	2
	1
	
	Push is O(1) operation
	
	Pop -
	
	N-1 times into the second queue
	|.|.|.|.|.|.|.| 				|1|2|3|.|.|.|.|	
	
	*/
	
	public static void main(String args[]){
		Stack stk = new Stack(5);
		
		System.out.println(stk.pop());
		
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		
		System.out.println(stk.pop());
		
		stk.push(5);
		
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());

	}
	
	


static class Stack{
	
	int count, max;
	
	Stack(int max){
		this.count = 0;
		this.max = max;
	}
	
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	void push(int n){
		if(count<max){
			q1.add(n);
			count++;
//			System.out.println(//count+ " " + max);
		}
		else{
			System.out.println("Stack full");
		}
	}
	
	int pop(){
		
		if(count<1)
			return -1;
		
		if(count == 1) {
			count--;
			return q1.poll();
		}
		
		while(count>1){
			q2.add(q1.poll());
			count--;
		}
		int ret = q1.poll();
		count=q2.size();
		
		q1=q2;
		return ret;
	}	
	
}

}
