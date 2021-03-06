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
		
		LinkedList firstList = new LinkedList();

		firstList.addNode(new Node(7));
		firstList.addNode(new Node(9));
		firstList.addNode(new Node(6));
		firstList.printList();
		
		LinkedList secondList = new LinkedList();

		secondList.addNode(new Node(9));
		secondList.addNode(new Node(0));
		secondList.addNode(new Node(3));
		secondList.addNode(new Node(9));
		secondList.printList();
		
		LinkedList result = new LinkedList(sumLists(firstList.head(), secondList.head()));
		result.printList();
		
	}
	
	
	
}
