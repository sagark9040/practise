package amz.sde;

public class LongestPathBinTreeNodes {

	public static void main(String args[]) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(4);

		System.out.println(tree.longestPathLength(tree.root));
		System.out.println(tree.maxHeight(tree.root));
	}

}



class BinaryTree {

	Node root;
	int longestPath;

	int longestPathLength(Node root) {
		if (root == null)
			return 0;

		int leftHeight = longestPathLength(root.left);
		int rightHeight = longestPathLength(root.right);
		int totalHeight = Math.max(1 + leftHeight + rightHeight, Math.max(leftHeight, rightHeight));

		if (this.longestPath < totalHeight)
			this.longestPath = totalHeight;

		return 1+Math.max(leftHeight, rightHeight);

	}
	
	int maxHeight(Node root){
		if(root == null)
			return 0;
		
		return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
	}

}

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	void addNode(int data) {

	}
}