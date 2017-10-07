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
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.left.left.left = new TreeNode(6);
		
		System.out.println(treeBal.isBalanced(root, 0));		
	}
}

class TreeBalancer{
	
	boolean isBalanced = true;
	
	boolean isBalanced(TreeNode root, int height){
		
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
