package ctci.Chp2_linkedLists;

public class Node {

	public int data;
	public Node next;
	
	public Node(int d){
		this.setData(d);
		this.setNext(null);
	}
	
	public Node(int d, Node head){
		this.setData(d);
		this.setNext(head);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
