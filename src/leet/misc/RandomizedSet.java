package leet.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomizedSet {
	 Map<Integer, Integer> numbers;
		ArrayList<Integer> pointers;
		int count = 0;
	    
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        numbers = new HashMap<Integer, Integer>();   
	        pointers = new ArrayList<Integer>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	    	if(numbers.containsKey(val))
	    		return false;
	    	
	    	numbers.put(val, pointers.size());
	        pointers.add(val);
	        count++;
	        
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	if (count == 0 || !numbers.containsKey(val))
	    		return false;
	    	
	        int ptr = numbers.get(val);
	    	int last = pointers.get(pointers.size()-1);
	    	pointers.set(ptr, last);
	    	pointers.remove(pointers.size()-1);
	    	count--;
	    	numbers.remove(val);   
	    	
	    	return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        if (count == 0)
	            return 0;
	    	int range = count + 1;
	        return pointers.get((int)(Math.random()*range));
	    }
    
    public static void main(String args[]) {
    	for(int i=0; i<10; i++)
    		System.out.println(randomWithRange(0, 3));
    	
    }
    static int randomWithRange(int min, int max)
    {
       int range = (max - min) + 1;     
       return (int)(Math.random() * range) + min;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

