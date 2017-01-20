package test;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 */
public class IsBTaBST {
	
	public boolean isValidBST (Node1 root, int min, int max) {
		//Is a null tree valid?
		if (root == null)
			return true;
		
		//One node tree is valid for sure.
		if (root.left == null && root.right == null)
			return true;
		
		if (root.left!=null && root.left.data <= root.data && root.left.data <= max) {
			max = root.left.data;
			isValidBST (root.left, min, max);
		}	
			
		else
			return false;
		
		if (root.right!=null && root.right.data > root.data && root.right.data > min) {
			min = root.right.data+1;
			isValidBST (root.right, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		else
			return false;
		
		//null --> false
		 
		//1 -- true
		
		//		20 				--> true
		//	10		30
		// 5  15  25  35
		
		//		20				--> false
		//	10		30
		// 5  25  25  35
		
		//		  20				--> false
		//	10		    30
		// 5  15    25    35
		//		  18  28 
		//			 24 30
	
		return false;
	
	}
	
	public static void main (String args[]) {
		
	}
}

/*
 * This is our building block of a Binary Tree
 */
class Node1 {
	Node1 left;
	Node1 right;
	int data;
	
	Node1 (int d) { //The value of the node is contained in 'data'
		data = d;
		left = null;
		right = null;
	}
}


  