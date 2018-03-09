package leet.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC24M_SwapNodesInPairs {

	/*
	 * //504
	 * 
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 * 
	 * 1 1-2 … 2-1 1-2-3 .. 2-1-3 1-2-3-4 .. 2-1-4-3
	 * 
	 * node = null return null node.next == null return node node.next.next ==
	 * null node temp = node.next; temp.next = node; node.next =
	 * recurse(node.next.next); return temp;
	 */

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode third = head.next.next; // null
		ListNode temp = head.next; // 2->null
		head.next = null;
		temp.next = head; // 2.next = 1(->2)
		temp.next.next = swapPairs(third); // 1->2->null

		return temp;
	}
}
