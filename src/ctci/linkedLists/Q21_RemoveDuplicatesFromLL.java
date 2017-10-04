package ctci.linkedLists;

import java.util.HashSet;
import java.util.Set;

// Two methods:
// 1. Uses extra space 
// 2. Cannot use extra space. So use O(N^2) method.

public class Q21_RemoveDuplicatesFromLL {

	private static void removeDupsUsingBuffer(Node head) {
		Set<Integer> elements = new HashSet<Integer>();

		Node cur = head;

		elements.add(cur.data);

		while (cur.next != null) {
			if (elements.contains(cur.next.data))
				cur.next = cur.next.next;
			else {
				elements.add(cur.next.data);
				cur = cur.next;
			}
		}
	}

	private static void removeDupsUsingPointer(Node head) {

		Node cur = head;

		while (cur != null) {
			Node ptr = cur.next;
			Node prev = cur;

			while (ptr != null) {

				// Pointer can either be equal to cur node or not
				// If equal:

				if (cur.data == ptr.data) {
					prev.next = ptr.next;
				}
				
				// if no equal
				else {
					prev = prev.next;
				}
				
				ptr = ptr.next;
				
			}
			
			cur = cur.next;
			ptr = cur != null ? cur.next : null;

		}

	}

	public static void main(String args[]) {

		LinkedList ll = new LinkedList(new Node(1));

		ll.addNode(new Node(1));
		ll.addNode(new Node(2));
		ll.addNode(new Node(3));
		ll.addNode(new Node(4));
		ll.addNode(new Node(1));
		ll.addNode(new Node(10));
		ll.addNode(new Node(5));

//		ll.printList();
//		removeDupsUsingBuffer(ll.head());
//		ll.printList();

		ll.removeAll();

		ll.addNode(new Node(5));
		ll.addNode(new Node(5));
		ll.addNode(new Node(1));
		ll.addNode(new Node(1));
		ll.addNode(new Node(2));
		ll.addNode(new Node(3));
		ll.addNode(new Node(4));
		ll.addNode(new Node(1));
		ll.addNode(new Node(10));
		ll.addNode(new Node(5));
		ll.addNode(new Node(5));

		ll.printList();
		removeDupsUsingPointer(ll.head());
		ll.printList();

	}

}
