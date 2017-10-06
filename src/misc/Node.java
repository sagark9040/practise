package misc;

public class Node {

	private int data;
	private Node next;
	
	public Node(int d){
		this.setData(d);
		this.setNext(null);
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
