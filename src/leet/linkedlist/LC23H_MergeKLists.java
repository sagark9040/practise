package leet.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC23H_MergeKLists {
	
	// I WAS USING PQ FOR JUST THE FIRST NODES OF EACH ROW IN THE ARRAY. THAT WAS aiming k log k x N complexity
	// INSTEAD I COULD JUST USE THE PQ AND INSERT ALL THE NODES IN THERE.
	

	// OPTIMAL LC SOLN
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

	public ListNode mySoln_mergeKLists(ListNode[] lists) {
        if(lists == null)   return null;
        if(lists.length == 1) return lists[0];
        int numOfLists = lists.length;
        ListNode head = null, currentNode = null;
        
        while(true) {
            PriorityQueue<LNode> pq = new PriorityQueue<LNode>(numOfLists, new Comparator<LNode>() {
                public int compare(LNode n1, LNode n2) {
                	return n1.val - n2.val;
                }
            });

            boolean allNulls = true;
            for(int i=0; i<numOfLists; i++) {
                ListNode cur = lists[i];
                if(cur != null) {
                    pq.offer(new LNode(cur.val, i));
                    allNulls = false;
                }
            }
            if(allNulls)
                break;
            LNode firstNode = pq.poll();           // Not sure about this operation            
            if(head == null) {
                head = new ListNode(firstNode.val);
                currentNode = head;
            } else
                currentNode.next = new ListNode(firstNode.val); 
            
            lists[firstNode.pos] = lists[firstNode.pos].next;
        }
        return head;   
    }
    class LNode {
        int val;
        int pos;
        LNode(int v, int p) {
            val = v;
            pos = p;
        }
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
