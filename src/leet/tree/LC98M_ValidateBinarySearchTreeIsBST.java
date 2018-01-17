package leet.tree;

public class LC98M_ValidateBinarySearchTreeIsBST {

	// Empty tree is BST?
	// One node is BST - yes
	// Left tree is only less than, right is only greater than
	// LinkedList as a BST
	// Proper BST
	// Wrong BST with extreme nodes failing
	
	
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
		
	public boolean isValidBST(TreeNode root, int min, int max) {
		// base case
		if(root == null)
			return true;
				
		if(root.val < min || root.val > max)
			return false;

		
		int minLeft = min;
		int maxLeft = root.val-1 < max ? root.val-1 : max;
		
		int minRight = root.val + 1 > min ? root.val+1 : min;
		int maxRight = max;

		
		return isValidBST(root.left, minLeft, maxLeft) && isValidBST(root.right, minRight, maxRight);
    }	
	
	public static void main(String args[]) {
		LC98M_ValidateBinarySearchTreeIsBST valid = new LC98M_ValidateBinarySearchTreeIsBST();
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(15);
		node.left.right = new TreeNode(9);
		node.right.left = new TreeNode(12);
		System.out.println(valid.isValidBST(node));
	}
}
