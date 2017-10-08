package ctci.Chp4_TreesAndGraphs;

public class Q44_CheckTreeIsBalanced {
	
	public static void main(String args[]){
		TreeBalancer treeBal = new TreeBalancer();
		
		// Pass Cases
		emptyTree(treeBal);
		singleElementTree(treeBal);
		twoElementTreeLeftChild(treeBal);
		twoElementTreeRightChild(treeBal);
		multiElementTree(treeBal);
		
		//Failure Test Cases
		unbalancedTree(treeBal);
		linkedList(treeBal);
	}
	
	private static void emptyTree(TreeBalancer treeBal) {
		TreeNode root = null;
		
		System.out.println(treeBal.isBalanced(root, 0));
	}
	
	private static void singleElementTree(TreeBalancer treeBal) {
		TreeNode root = new TreeNode(1);
		
		System.out.println(treeBal.isBalanced(root, 0));		
	}

	private static void twoElementTreeLeftChild(TreeBalancer treeBal) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);		
		
		System.out.println(treeBal.isBalanced(root, 0));
	}
	
	private static void twoElementTreeRightChild(TreeBalancer treeBal) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);		
		
		System.out.println(treeBal.isBalanced(root, 0));
	}
	
	private static void multiElementTree(TreeBalancer treeBal) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);		
		
		System.out.println(treeBal.isBalanced(root, 0));
	}
	
	private static void unbalancedTree(TreeBalancer treeBal) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.left.left.right = new TreeNode(6);
		
		System.out.println(treeBal.isBalanced(root, 0));
	}
	
	private static void linkedList(TreeBalancer treeBal) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(20);
		root.left.left.left = new TreeNode(3);
		root.left.left.left.left = new TreeNode(30);

		//Tree.printBinaryTree(root);
		System.out.println(treeBal.isBalanced(root, 0));
	}
}

class TreeBalancer{
	
	boolean isBalanced;
	
	//My method is effectively similar to this
	public int checkHeightCTCI(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = checkHeightCTCI(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up
		
		int rightHeight = checkHeightCTCI(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	boolean isBalanced(TreeNode root, int height){
		isBalanced = true;
		@SuppressWarnings("unused")
		int getHeight = getHeight(root, height);
		return isBalanced;
	}
	
	int getHeight(TreeNode root, int height){
		
		if(root == null || (root.left == null && root.right == null))
			return 0;
		
		int leftHeight = getHeight(root.left, height) + 1;
		int rightHeight = getHeight(root.right, height) + 1;
		
		if(isBalanced && Math.abs(leftHeight - rightHeight) > 1)
			isBalanced = false;
		
		return Math.max(leftHeight, rightHeight);			
	}

	
	
}
