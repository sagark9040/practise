package ctci.Chp2_linkedLists;

import java.util.Stack;

//Do we know the size?
//Extra space usage allowed?


public class Q26_LinkedListPalindrome {

	static PalinResult recurPalin(Node head, int length){
		if(head == null) return new PalinResult(head, true);
		
		if(length <=0) return new PalinResult(head, true);
			
		if(length == 1) return new PalinResult(head.getNext(), true);
		
		PalinResult result = recurPalin(head.getNext(), length-2);
		
		if(result.result == false)
			return result;
		
		if(result.node.getData() != head.getData())
			return new PalinResult(head, false);
		
		result.node = result.node.getNext();
		
		return result;
		
		
	}
	
	static void extraSpaceIsPalindrome(Node head){
		Stack<Integer> stack = new Stack<Integer>();
		int length = 0;
		Node curNode = head;
		
		while(curNode != null){
			stack.push(curNode.getData());
			curNode = curNode.getNext();
			length++;
		}
		
		int counter = 0;
		curNode = head; 
		boolean isPalindrome = true;
		
		while(counter < length/2){
			int curStackElem = stack.pop();
			if(curStackElem != curNode.getData()){
				System.out.println("Not a palindrome");
				isPalindrome = false;
				return;
			}
			curNode = curNode.getNext();
			counter++;
		}
		
		
		if(isPalindrome)
			System.out.println("Is Palindrome");
	}
	
	public static void main(String args[]){
		isPalindrome();
		notPalindrome();
	}
	
	public static void isPalindrome(){
		LinkedList first = new LinkedList();

		first.addNode(new Node(1));
		first.addNode(new Node(7));
		first.addNode(new Node(9));
		first.addNode(new Node(6));
		first.addNode(new Node(9));
		first.addNode(new Node(7));
		first.addNode(new Node(1));
		
		System.out.println(recurPalin(first.head(), 5).result);
	}
	
	public static void notPalindrome(){
		LinkedList first = new LinkedList();

		first.addNode(new Node(7));
		first.addNode(new Node(9));
		first.addNode(new Node(6));
		first.addNode(new Node(9));
		
		System.out.println(recurPalin(first.head(), 4).result);
	}
	
}

class PalinResult{
	Node node;
	boolean result;
	
	PalinResult(Node node, boolean result){
		this.node = node;
		this.result = result;
	}
}
