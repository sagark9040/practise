package ctci.Chp2_linkedLists;

import java.util.Stack;

//Do we know the size?
//Extra space usage allowed?


public class Q26_LinkedListPalindrome {

	public static void extraSpaceIsPalindrome(Node head){
		Stack<Integer> stack = new Stack<Integer>();
		int length = 0;
		Node curNode = head;
		
		while(curNode != null){
			stack.push(curNode.data);
			curNode = curNode.next;
			length++;
		}
		
		int counter = 0;
		curNode = head; 
		boolean isPalindrome = true;
		
		while(counter < length/2){
			int curStackElem = stack.pop();
			if(curStackElem != curNode.data){
				System.out.println("Not a palindrome");
				isPalindrome = false;
				return;
			}
			curNode = curNode.next;
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

		first.addNode(new Node(7));
		first.addNode(new Node(9));
		first.addNode(new Node(6));
		first.addNode(new Node(9));
		first.addNode(new Node(7));
		
		extraSpaceIsPalindrome(first.head());
	}
	
	public static void notPalindrome(){
		LinkedList first = new LinkedList();

		first.addNode(new Node(7));
		first.addNode(new Node(9));
		first.addNode(new Node(6));
		first.addNode(new Node(9));
		
		extraSpaceIsPalindrome(first.head());
	}
	
}
