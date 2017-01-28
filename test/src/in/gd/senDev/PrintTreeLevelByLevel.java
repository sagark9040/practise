package in.gd.senDev;


// Iterative Queue based Java program to do level order traversal
// of Binary Tree

/* importing the inbuilt java classes required for the program */
import java.util.Queue;
import java.util.LinkedList;

/* Class to represent Tree node */
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = null;
		right = null;
	}
}

/* Class to print Level Order Traversal */
public class PrintTreeLevelByLevel {

	Node root;

	/* Given a binary tree. Print its nodes in level order
	     using array for implementing queue  */
	void printLevelOrder(Queue<Node> curLevel) 
	{
		Queue<Node> nextLevel = new LinkedList<Node>();

		while (!curLevel.isEmpty()) {
			Node elem = curLevel.poll();
			System.out.print(elem.data + " ");
			
			if(elem.left != null)
				nextLevel.add(elem.left);
			if(elem.right != null)
				nextLevel.add(elem.right);
		}
		System.out.println();
		
		if (!nextLevel.isEmpty())
			printLevelOrder(nextLevel);
		
	}

	public static void main(String args[]) 
	{
		/* creating a binary tree and entering 
	         the nodes */
		PrintTreeLevelByLevel tree_level = new PrintTreeLevelByLevel();
		tree_level.root = new Node(1);
		tree_level.root.left = new Node(2);
		tree_level.root.right = new Node(3);
		tree_level.root.left.left = new Node(4);
		tree_level.root.left.right = new Node(5);
		tree_level.root.right.left = new Node(6);
		tree_level.root.right.right = new Node(7);
		tree_level.root.left.left.left = new Node(8);
		tree_level.root.left.left.right = new Node(9);

		System.out.println("Level order traversal of binary tree is - ");
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(tree_level.root);
		tree_level.printLevelOrder(queue);
	}
}
