package ctci.linkedLists;

public class Q22_ReturnKthElementOfLL {

	private static int kThElement(Node head, int k) {

		Node cur = head;
		Node fast = head;

		if (k < 1)
			return -1;

		for (int i = 2; i <= k; i++) {
			if (fast.next == null)
				return -1;

			fast = fast.next;
		}

		while (fast.next != null) {
			cur = cur.next;
			fast = fast.next;
		}

		return cur.data;
	}

	private static int recurse(Node head, int i) {

		if (head == null)
			return i++;

		if (i >= 4)
			return head.data;

		return recurse(head.next, i);

	}

	private static int redo(Node head, int k) {

		Node fast = head;
		Node slow = null;

		for (int i = 2; i <= k; i++) {
			if (fast != null)
				fast = fast.next;

			else
				return -1;
		}

		int i = 1;
		
		while (fast != null) {
			fast = fast.next;
			
			if(i==1)
				slow = head;
			else
				slow = slow.next;
			
			i++;
		}
		return slow != null && k!=0 ? slow.data : -1;
	}	

	public static void main(String args[]) {

		LinkedList ll = new LinkedList();

		ll.addNode(new Node(1));
		ll.addNode(new Node(2));
		ll.addNode(new Node(3));
		ll.addNode(new Node(4));

		// System.out.println(kThElement(ll.head(), 0));
		// System.out.println(kThElement(ll.head(), 1));
		// System.out.println(kThElement(ll.head(), 2));
		// System.out.println(kThElement(ll.head(), 3));
		// System.out.println(kThElement(ll.head(), 4));
		// System.out.println(kThElement(ll.head(), 5));

		System.out.println(redo(ll.head(), 0));
		System.out.println(redo(ll.head(), 1));
		System.out.println(redo(ll.head(), 2));
		System.out.println(redo(ll.head(), 3));
		System.out.println(redo(ll.head(), 4));
		System.out.println(redo(ll.head(), 5));
		

	}

}
