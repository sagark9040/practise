package ctci.Chp2_linkedLists;

public class Q25_SumLists {

	private static Node sumLists(Node first, Node second){
		Node resultTemp = null, resultHead = null, carry = null;
		
		// Iterate through all the digits of both the numbers
		while(first != null || second != null){
			int result = getValue(carry) + getValue(first) + getValue(second);
			
			// When the sum of digits is greater than 1, we carry 1 forward
			carry = result > 9 ? new Node(1) : null;
			
			// For the units place value
			if (resultHead == null){
				resultTemp = new Node(result%10);
				resultHead = resultTemp;
			}
			else {
				resultTemp.next = new Node(result%10);
				resultTemp = resultTemp.next;
			}
			//System.out.println("-->" + resultTemp.data);
			first = first != null ? first.next : first;
			second = second != null ? second.next : second;
		}
		if (carry != null)
			resultTemp.next = new Node(1);
		
		// If the resultHead is null, both the numbers were zero		
		return resultHead != null ? resultHead : new Node(0);
	}
	
	private static int getValue(Node number){
		return number != null ? number.data : 0;
	}
	
	public static void main(String args[]){
		
		sumListsTestCases();
		
	}

	private static void sumListsTestCases() {
		
		LinkedList first = new LinkedList();

		first.addNode(new Node(7));
		first.addNode(new Node(9));
		first.addNode(new Node(6));
		first.printList();
		
		LinkedList second = new LinkedList();

		second.addNode(new Node(9));
		second.addNode(new Node(0));
		second.addNode(new Node(3));
		second.addNode(new Node(9));
		second.printList();
		
		LinkedList result = new LinkedList(sumLists(first.head(), second.head()));
		result.printList();
		
	}
	
	
	
}
