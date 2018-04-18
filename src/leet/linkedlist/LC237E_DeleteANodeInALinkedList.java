package leet.linkedlist;

public class LC237E_DeleteANodeInALinkedList {
	public void deleteNode(ListNode node) {
        if(node.next == null)  {
            node = null;
            return;
        }
        
        int nextVal = node.next.val;
        node.val = nextVal;
        node.next = node.next.next;
    }
}
