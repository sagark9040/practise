package ctci.Chp4_TreesAndGraphs;

/*
Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.
Hints: #79, #91
*/

/*Q:

 * Is it a BST or a Binary Tree?
 * 
 * 
 * Soln 1:
 * Do an inorder traversal and if you hit the 'current' node, whatever's next is the answer

 */

public class Q46_SuccessorNode {
	
	public boolean nextNode = false;
	public boolean foundSuccessor = false;
	
	public void getSuccessor(TreeNode node, TreeNode root){
		if(root == null)
			return;
		
		
		
		if(!foundSuccessor)
			getSuccessor(node, root.left);
		
		
		if(nextNode){
			System.out.println(root.data + " <-- successor");
			nextNode = false;
			foundSuccessor = true;
			return;
		}
		
		if(root.data == node.data) 
			nextNode = true;

		if(!foundSuccessor)
			getSuccessor(node, root.right);			
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right  = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		
		root.right.left = new TreeNode(7);
		root.right.left.left = new TreeNode(6);
		root.right.right = new TreeNode(12);
		
		Q46_SuccessorNode successor = new Q46_SuccessorNode();
		Tree.printBinaryTree(root);
		
		testCases(successor, root);
	}
	
	public static void testCases(Q46_SuccessorNode successor, TreeNode root){
		System.out.print(root.data + " <-- Search ");
		successor.getSuccessor(root, root);
		if(!successor.foundSuccessor)
			System.out.println("Search node may be the last one or not present at all.");
		
		System.out.print(root.left.data + " <-- Search ");
		successor = new Q46_SuccessorNode();
		successor.getSuccessor(root.left, root);
		if(!successor.foundSuccessor)
			System.out.println("Search node may be the last one or not present at all.");
		
		System.out.print(root.right.data + " <-- Search ");
		successor = new Q46_SuccessorNode();
		successor.getSuccessor(root.right, root);
		if(!successor.foundSuccessor)
			System.out.println("Search node may be the last one or not present at all.");
		
		
		System.out.print(root.right.data + " <-- Search ");
		successor = new Q46_SuccessorNode();
		successor.getSuccessor(root.right, root);
		if(!successor.foundSuccessor)
			System.out.println("Search node may be the last one or not present at all.");
	}
}
