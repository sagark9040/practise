package misc;

// 1->2-3->4
// 


public class ReverseALinkedList {

	Node head;
	
	public Node reverse(Node curr, Node prev){
		
		if(curr == null || curr.next == null){
			head = curr;	
			
			curr.next = prev;
			return null;
		}
		
		Node next1 = curr.next;
		curr.next = prev;
		reverse(next1, curr);
		
		return head;
	}
	
	public Node rev(Node cur, Node prev){
		if(cur == null || cur.next == null) {
			this.head = cur;		
			return this.head;
		}
		
		Node next = cur.next;
		cur.next = prev;
		reverse(next, cur);
		
		return this.head;
	}
	
	public static void main(String args[]){
		LinkedList ll = new LinkedList();
		ReverseALinkedList rev = new ReverseALinkedList();
		
		ll.addNode(new Node(1));
		ll.addNode(new Node(2));
		ll.addNode(new Node(3));
		ll.addNode(new Node(4));
		ll.addNode(new Node(5));
		ll.addNode(new Node(6));
		
		ll.printList();
		//rev.reverse(ll.head(), null);
		ll = new LinkedList(rev.rev(ll.head(), null));

		System.out.println("\n\n-----");
		
		ll.printList();
		ll = new LinkedList(rev.rev(ll.head(), null));
		ll.printList();
	}	
}

