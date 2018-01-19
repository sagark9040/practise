package leet.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import sun.misc.Queue;

public class LRUCache {

    Map<Integer, Integer> map;
    Queue q;
    int size = 0, capacity;
    
    public LRUCache(int cap) {
    	
    	capacity = cap;    	
        map = new HashMap<Integer, Integer>();
        q = new Queue();
        
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        	return map.get(key);
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        	return;
        
        if(size == capacity) {
        	try {
				int removedVal = (int) q.dequeue();
				map.remove(removedVal);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } else {
        	size++;
        }
        
    	map.put(key, value);
    	q.enqueue(key);
    }
    
    public static void main(String args[]) {
    	LRUCache cache = new LRUCache( 2 /* capacity */ );

    	System.out.println(cache.get(0));
    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));       // returns -1 (not found)
    	System.out.println(cache.get(3));       // returns 3
    	System.out.println(cache.get(4));  
    	
    	
    }
}