package ctci.Chp2_linkedLists;

public class Q27_IntersectLinkedList {

	static void findIntersection(Node first, Node second){
		
		Node firstCurrent = first, secondCurrent = second, firstLast = null, secondLast = null;
		
		while(firstCurrent != null){
			if(firstCurrent.next == null)
				firstLast = firstCurrent;
			
			firstCurrent = firstCurrent.next;
		}
		
		while(secondCurrent != null){
			if(secondCurrent.next == null)
				secondLast = secondCurrent;
			
			secondCurrent = secondCurrent.next;
		}
		
		if (firstLast == secondLast) {
			System.out.println("Lists intersect" + firstLast.data);
		}
	}

	public static void main(String args[]){
		
		Node common10 = new Node(10);
		Node common4 = new Node(4);
		common10.next = common4;
		
		
		LinkedList first = new LinkedList();

		first.addNode(new Node(7));
		first.addNode(new Node(9));
		first.addNode(new Node(6));
		first.addNode(common10);
		
		first.printList();
		
		LinkedList second = new LinkedList();

		second.addNode(new Node(9));
		second.addNode(new Node(0));
		second.addNode(new Node(3));
		second.addNode(common10);
		
		second.printList();
		
		findIntersection(first.head, second.head);
		
		
	}
	
}
