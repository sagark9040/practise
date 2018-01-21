package leet.linkedlist;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class LC2M_AddTwoNumbers {
	
    // Looks simple enough.
    // What about negative numbers?
    // 999 + 1
    // 
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l2 == null ? l1 : l2;
        
        ListNode res = null, head = null; int overFlow = 0;
        
        while(l1 != null || l2 != null) {
            if (res == null) {
                int val = l1.val + l2.val;
                overFlow = val > 9 ? 1 : 0;
                res = new ListNode(val % 10);
                head = res;
            } else {
                int l1Val = l1 != null ? l1.val : 0;
                int l2Val = l2 != null ? l2.val : 0;
                int val = l1Val + l2Val + overFlow;
                overFlow = val > 9 ? 1 : 0;
                ListNode newNode = new ListNode(val % 10);  /// THIS PART CAUSED ISSUES !!!!!!
                res.next = newNode;							/// THIS PART CAUSED ISSUES !!!!!!
                res = res.next;
            }   
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        res.next = overFlow == 1 ? new ListNode(1) : null;
        return head;
    }
    
    public static void main(String args[]) {
    	ListNode l1 = new ListNode(9);
    	l1.next = new ListNode(9);
    	l1.next.next = new ListNode(9);
    	
    	ListNode l2 = new ListNode(1);
    	
    	LC2M_AddTwoNumbers add = new LC2M_AddTwoNumbers();
    	add.addTwoNumbers(l1, l2);
    }
}
