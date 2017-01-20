package test;

public class BinaryTreeDeepestNodeIn {
	
	//Do a DFS. Add 1 to each of the traversals as we go down. -1 as we go up.
	
	//start with root
	//if root is null then return 0;
	//if (root.left is not null then recurse it with node.left until a value depth is greater than maxDepth
	
	static Node getDeepestNode (Node node, int depth, Node deepestNode, int maxDepth) {
		
		if (node == null)
			return null;
		
		if (depth >= maxDepth) { //add a boolean flag to the recursive call to check isLeftChild. 
			deepestNode = node;
			maxDepth = depth;
		}
		
		if (node.left != null)
			getDeepestNode(node.left, depth+1, deepestNode, maxDepth);
				
		if (node.right != null)
			getDeepestNode(node.right, depth+1, deepestNode, maxDepth);
		
		return deepestNode;
	}
	
	

	public static void main (String args[]) {
		Node root = new Node (3);
		Node deepestNode = getDeepestNode (root, 0, null, 0);
	}
}
class Node {
	int data;
	int depth;
	Node left;
	Node right;
	
	public Node (int data) {
		this.data = data;
	}
	
	Node(int data, int depth) {
		this.data = data;
		this.depth = depth;
	}
}