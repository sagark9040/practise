package leet.linkedlist;

import java.util.Stack;

public class LC234_LinkedListPalindrome{
	/**
	 Definition for singly-linked list.	 
	 */
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}

    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        Stack<Integer> values = new Stack<Integer>();
        while(cur != null) {
            values.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            if(cur.val != values.pop()) 
                return false;
            cur = cur.next;
        }
        return true;
    }

}
