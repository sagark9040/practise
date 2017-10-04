package in.gd.ssde;

public class ReverseALinkedList {

	public static void main(String args[]) {

//		LinkedList ll = new LinkedList();
//		ll.addNode(new Node(1));
//		ll.addNode(new Node(2));
//		ll.addNode(new Node(3));
//
//		ll.print();
//		ll.reverse();
//		System.out.println();
//		ll.print();
//		
//		ll.reverse();
//		System.out.println();
//		ll.print();
	}

	class Node{

		int data;
		Node next;

		Node(int data){
			this.data = data;
			this.next = null;
		}

	}

	class LinkedList {

		Node head;

		LinkedList() {

		}

		void addNode (Node newNode) {			

			if (head == null)
				head = newNode;

			else {
				Node currentNode = head;

				while (currentNode.next != null) { 
					currentNode = currentNode.next;
				}

				currentNode.next = newNode;							
			}			
		}

		void print() {

			Node currentNode = head;

			while (currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
		
		void reverse() {
	        Node prev = null;
	        Node current = head;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        this.head = prev;

	    }
		
	    // A simple and tail recursive function to reverse
	    // a linked list.  prev is passed as NULL initially.
	    Node reverseUtil(Node curr, Node prev) {
	 
	        /* If last node mark it head*/
	        if (curr.next == null) {
	            head = curr;
	 
	            /* Update next to prev node */
	            curr.next = prev;
	            return null;
	        }
	 
	        /* Save curr->next node for recursive call */
	        Node next1 = curr.next;
	 
	        /* and update next ..*/
	        curr.next = prev;
	 
	        reverseUtil(next1, curr);
	        return head;
	    }

	}
}
	





