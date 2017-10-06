package misc;

// 1->2-3->4
// 


public class ReverseALinkedList {

	Node head;
	
	public Node reverse(Node cur, Node prev){
		if(cur == null) return cur;
		
		if(cur.getNext() == null) {
			head = cur;
			head.setNext(prev);
			return head;
		}
		
		Node next = cur.getNext();
		cur.setNext(prev);
		reverse(next, cur);
		
		return head;
	}
	

	
	
	public static void main(String args[]){
		String mode = "iterative";
		//String mode = "recursive";
		
		emptyList(mode);
		singleElement(mode);
		twoElements(mode);
		severalElements(mode);
	}
	
	public static void emptyList(String mode){
		LinkedList ll = new LinkedList();
		ReverseALinkedList rev = new ReverseALinkedList();	
		ll.printList();
		ll = new LinkedList(rev.reverse(ll.head(), null));
		ll.printList();
	}
	
	public static void singleElement(String mode){
		LinkedList ll = new LinkedList();
		ReverseALinkedList rev = new ReverseALinkedList();
		
		ll.addNode(new Node(1));
		ll.printList();
		ll = new LinkedList(rev.reverse(ll.head(), null));
		ll.printList();
	}
	
	public static void twoElements(String mode){
		LinkedList ll = new LinkedList();
		ReverseALinkedList rev = new ReverseALinkedList();
		
		ll.addNode(new Node(1));
		ll.addNode(new Node(2));
		ll.printList();
		ll = new LinkedList(rev.reverse(ll.head(), null));
		ll.printList();
	}
	
	public static void severalElements(String mode){
		LinkedList ll = new LinkedList();
		ReverseALinkedList rev = new ReverseALinkedList();
		
		ll.addNode(new Node(1));
		ll.addNode(new Node(2));
		ll.addNode(new Node(3));
		ll.addNode(new Node(4));
		ll.printList();
		ll = new LinkedList(rev.reverse(ll.head(), null));
		ll.printList();
	}
}