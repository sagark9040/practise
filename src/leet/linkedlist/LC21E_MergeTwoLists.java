package leet.linkedlist;

public class LC21E_MergeTwoLists {
	//159pm to 212pm AC
	//Got one TC wrong .. where one of them was null, other one wasn't
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, cur = null;
        if(l1 == null && l2 == null) {
            return null;
        } else if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode cur1 = l1, cur2 = l2;
        
        while(true) {
            if (cur1 == null && cur2 == null) {
                break;
            } else if(cur1 != null && cur2 != null) {
                if(head == null) {
                    head = cur1.val > cur2.val ? new ListNode(cur2.val) : new ListNode(cur1.val);
                    cur = head;
                } else {
                    cur.next =  cur1.val > cur2.val ? new ListNode(cur2.val) : new ListNode(cur1.val);
                    cur = cur.next;
                }                                
                if(cur1.val > cur2.val) cur2 = cur2.next;
                else cur1 = cur1.next;
            } else {
                cur.next = cur1 == null ? new ListNode(cur2.val) : new ListNode(cur1.val);
                cur = cur.next;
                if(cur1 == null)    cur2 = cur2.next;
                else    cur1 = cur1.next;
            }            
        }
        return head;
    }
}
