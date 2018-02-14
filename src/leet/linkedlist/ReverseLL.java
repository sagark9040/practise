package leet.linkedlist;

import java.util.Stack;

public class ReverseLL {
	public ListNode rev (ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Stack<ListNode> allNodes = new Stack<ListNode>();
		
		while(head != null) {
			allNodes.push(head);
			head = head.next;
		}
		
		head = null;
		ListNode cur = null;
		while(!allNodes.isEmpty()) {
			if(head == null) {
				head = allNodes.pop();
				cur = head;
				cur.next = null;
			} else {
				cur.next = allNodes.pop();
				cur = cur.next;
				cur.next = null;
			}				
		}
		
		return head;
	}
	
	void print(ListNode cur) {
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}		
		System.out.println();
	}
	
	public static void main(String args[]) {
		ReverseLL r = new ReverseLL();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		r.print(head);
		r.print(r.rev(head));
	}
}
