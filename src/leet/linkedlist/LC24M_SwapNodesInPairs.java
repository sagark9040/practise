package leet.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC24M_SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode third = head.next.next; // null
        ListNode temp = head.next; // 2->null
        head.next = null;
        temp.next = head;  // 2.next = 1(->2)  
        temp.next.next = swapPairs(third);  //1->2->null
        

        
        return temp;
    }
}
