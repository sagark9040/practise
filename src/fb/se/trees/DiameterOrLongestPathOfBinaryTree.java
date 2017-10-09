package fb.se.trees;

//Given a full binary tree, find the longest path between any two nodes. (Essentially, find the diameter of a full binary tree.)

public class DiameterOrLongestPathOfBinaryTree {
	
	int longestPath = 0;
	
	int getHeight(TreeNode root){
		if(root == null)
			return -1;
		
		if(root.left == null && root.right == null) return 0;
		
		int leftHeight = getHeight(root.left) + 1;
		int rightHeight = getHeight(root.right) + 1;
		
		if ((leftHeight + rightHeight) > longestPath)
			longestPath = leftHeight + rightHeight;
		
		return Math.max(leftHeight, rightHeight);
	}
	public static void main(String args[]){
		smallTree();
		longerTree();
		oneElementTree();
		twoElementTree();
		threeElementTree();
	}

	public static void oneElementTree(){
		TreeNode tree = new TreeNode();
		tree = new TreeNode(1);
		DiameterOrLongestPathOfBinaryTree l= new DiameterOrLongestPathOfBinaryTree();
		
		Tree.printBinaryTree(tree);		
		System.out.println("Height:" + l.getHeight(tree));
		System.out.println("Longest Path:" + l.longestPath);
	}
	
	public static void twoElementTree(){
		TreeNode tree = new TreeNode();
		tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		DiameterOrLongestPathOfBinaryTree l= new DiameterOrLongestPathOfBinaryTree();
		
		Tree.printBinaryTree(tree);		
		System.out.println("Height:" + l.getHeight(tree));
		System.out.println("Longest Path:" + l.longestPath);
	}
	
	public static void threeElementTree(){
		TreeNode tree = new TreeNode();
		DiameterOrLongestPathOfBinaryTree l= new DiameterOrLongestPathOfBinaryTree();
		
		tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		
		Tree.printBinaryTree(tree);		
		System.out.println("Height:" + l.getHeight(tree));
		System.out.println("Longest Path:" + l.longestPath);
	}
	
	public static void smallTree(){
		TreeNode tree = new TreeNode();
		DiameterOrLongestPathOfBinaryTree l= new DiameterOrLongestPathOfBinaryTree();
		
		tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		tree.left.left.left = new TreeNode(4);
		
		Tree.printBinaryTree(tree);		
		System.out.println("Height:" + l.getHeight(tree));
		System.out.println("Longest Path:" + l.longestPath);
	}
	
	public static void longerTree(){
		TreeNode tree = new TreeNode();
		DiameterOrLongestPathOfBinaryTree l= new DiameterOrLongestPathOfBinaryTree();

		tree = new TreeNode();
		tree = new TreeNode(2);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(3);
		tree.right.left = new TreeNode(8);
		tree.right.left.left = new TreeNode(9);
		tree.right.left.left.left = new TreeNode(10);
		
		tree.right.right = new TreeNode(4);
		tree.right.right.right = new TreeNode(5);
		tree.right.right.right.right = new TreeNode(6);
		tree.right.right.right.right.right = new TreeNode(7);

		Tree.printBinaryTree(tree);
		
		System.out.println("Height:" + l.getHeight(tree));
		System.out.println("Longest Path:" + l.longestPath);
	}
}
