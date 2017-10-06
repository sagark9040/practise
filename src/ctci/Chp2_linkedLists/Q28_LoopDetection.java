package ctci.Chp2_linkedLists;

public class Q28_LoopDetection {

	static void loopDetection(Node head){
		if(head == null || head.next == null){
			System.out.println("No loop found");
			return;
		}
		
		Node slow = head, fast = head;
		
		while(slow != null && fast != null){

			slow = slow.next;
			fast = fast.next != null ? fast.next.next : null ;		
			
			if(slow == fast){
				System.out.println("LOOP DETECTED!!!!");
				return;
			}
			
								
		}
		
		System.out.println("No loop found");
	}
	
	public static void main(String args[]){
		Node common10 = new Node(10);
		Node common4 = new Node(4);
		Node common5 = new Node(5);
		common10.next = common4;
		common4.next = common5;
		common5.next = common10;
		
		
		LinkedList first = new LinkedList();

		first.addNode(new Node(7));
		first.head.next = null;
		first.addNode(new Node(9, first.head));
		first.addNode(new Node(6));
		first.addNode(common10);
		
		loopDetection(first.head);
	}
	
}
