package leet.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC382M_LinkedListRandomNode {

	List<Integer> list = new ArrayList<Integer>();

    ListNode head;

    public LC382M_LinkedListRandomNode(ListNode head) {
    	this.head = head;
        ListNode cur = head;
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }        
    }
    
    /** Returns a random node's value. */
    public int getRandomWithSizeKnown() {
        if(list.size() == 0) {
            return 0;
        } else {
            int val = 0;
            val = (int) Math.floor(Math.random() * list.size());            
            return list.get(val);
        }    
    }
    
    
    // LC solution for unknown size    
    public int getRandomWithoutKnowingSize() {
    	ListNode cur = this.head;
    	int val = cur.val;
    	Random random = new Random();  
    	for(int i=1; cur!=null; i++) {
    		cur = cur.next;
    		if(random.nextInt(i+1) == i) {
    			val = cur.val;
    		}
    	}
    	return val;
    }
}
