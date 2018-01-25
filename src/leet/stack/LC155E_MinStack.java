package leet.stack;

import java.util.Stack;

public class LC155E_MinStack {
	/** initialize your data structure here. */
	Stack<Integer> values;
	Stack<Integer> minimum;
	
	public LC155E_MinStack() {
        values = new Stack<Integer>();
        minimum = new Stack<Integer>();
    }
    
    public void push(int x) {
        values.push(x);
        
        int curMin = Integer.MAX_VALUE;
        if(!minimum.isEmpty()) {
        	curMin = minimum.peek();
        }
        if(curMin > x)
        	minimum.push(x);
        else
        	minimum.push(curMin);
    }
    
    public void pop() {
        if(!values.isEmpty()) {
        	minimum.pop();
        	values.pop();
        }
    }
    
    public int top() {
    	if(!values.isEmpty()) {
    		return values.peek();
    	}
    	return -1;        
    }
    
    public int getMin() {
        if(!minimum.isEmpty())
        	return minimum.peek();
        
        return Integer.MAX_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/