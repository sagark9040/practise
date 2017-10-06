package ctci.Chp2_linkedLists;

public class LinkedList {

	public Node head;

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

		while (cur.next != null) {
			cur = cur.next;
		}

		cur.next = n;

	}

	public void printList() {
		Node cur = this.head;
		
		System.out.println("\n Linked List: ");
		while(cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		
	}
	
	
}
