package leet.misc;

import java.util.LinkedHashMap;

public class LC362M_DesignHitCounter {

	//430p
	//BF..	
	//Store all the values as they come.. 1,1,2,2,200,250,300,301,302..
	//O(log n) find the countVal and go left till minus300 
	//LinkedHashMap-time,count  
	
	//THERE ARE QUESTIONS TO ASK THE INTERVIEWER HERE IN TERMS OF DESIGN
	
	
	LinkedHashMap<Integer, Integer> hitsCounter;
    /** Initialize your data structure here. */
    public LC362M_DesignHitCounter() {
    	hitsCounter = new LinkedHashMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!hitsCounter.containsKey(timestamp)) {								//<------ issue here didn't check the contains part
        	hitsCounter.put(timestamp, 1);
        } else {
        	hitsCounter.put(timestamp, hitsCounter.get(timestamp) + 1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	int hits = 0;
        for(int i=0; i<=299; i++) {
        	if(hitsCounter.containsKey(timestamp-i)) {
        		hits += hitsCounter.get(timestamp - i);
        	}
        }
        return hits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */