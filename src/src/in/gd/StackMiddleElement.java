package src.in.gd;

import java.util.LinkedList;
import java.util.List;

// http://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/

/*

Find middle element of a stack in constant time. Delete it in constant time.

Use a LinkedList data structure with an extra pointer to the middle element. Also, you need another variable Var to store whether the LinkedList has an even or odd elements.

Push which adds an element to the top of stack.
Add the element to the head of the LinkedList. Update the pointer to the middle element according to Var

Pop which removes an element from top of stack.
Remove the head of the LinkedList. Update the pointer to the middle element according to Var

Find Middle which will return middle element of the stack.
Use the pointer to the middle element

Delete Middle which will delete the middle element

*/

public class StackMiddleElement {
	
	
	
	




}


class DoublyLinkedList<T>{
	
	int data;
	DoublyLinkedList next, prev;
	
	public DoublyLinkedList(int val) {
		this.data = val;
		this.next = null;		
	}
}

