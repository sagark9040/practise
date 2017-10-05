package misc;

// 1->2-3->4
// 


public class INCOMPLETEReverseALinkedList {

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
	
	public static void main(String args[]){
		LinkedList ll = new LinkedList();
		INCOMPLETEReverseALinkedList rev = new INCOMPLETEReverseALinkedList();
		
		ll.addNode(new Node(1));
		ll.addNode(new Node(2));
		//ll.addNode(new Node(3));
		//ll.addNode(new Node(4));
		
		ll.printList();
		rev.reverse(ll.head(), null);

		System.out.println("\n\n-----");
		
		ll.printList();
	}	
}

