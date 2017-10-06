package misc;

public class LinkedList {

	private Node head;

	LinkedList(Node node) {
		this.head = node;
	}

	public LinkedList() {
		this.head = null;
	}

	Node head(){
		return head;
	}
	
	public void removeAll() {
		this.head = null;
	}
	
	public void addNode(Node n) {

		if (this.head == null) {
			this.head = n;
			return;
		}

		Node cur = this.head;

		while (cur.getNext() != null) {
			cur = cur.getNext();
		}

		cur.setNext(n);

	}

	public void printList() {
		Node cur = this.head;
		
		System.out.println("\n Linked List: ");
		while(cur != null) {
			System.out.print(cur.getData() + " ");
			cur = cur.getNext();
		}
		
	}
	
	
}
