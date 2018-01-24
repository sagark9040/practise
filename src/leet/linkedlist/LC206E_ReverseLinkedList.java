package leet.linkedlist;

public class LC206E_ReverseLinkedList {

	//Very simple
	
    ListNode newHead = null;
    public ListNode reverseList(ListNode head) {
       reverseUtil(head, null);
        return newHead;
    }
    public ListNode reverseUtil(ListNode node, ListNode prev) {
       if(node == null || node.next == null) {
           newHead = node;
           return node;
       }
        
        ListNode cur = reverseUtil(node.next, node);
        cur.next = node;
        node.next = null;
        return node;
    }

}
