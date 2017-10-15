package ctci.Chp4_TreesAndGraphs;

// If one of the nodes is null or not present then it returns the node that is present as the common ancestor
// Could add check that if one of the nodes is not present then show appropriate message. 
public class Q48_CommonAncestor {

	TreeNode commonAncestor(TreeNode root, TreeNode a, TreeNode b){
		if(root == null)	return null;

		if(root == a || root == b) return root;
		
		TreeNode left = commonAncestor(root.left, a, b);
		TreeNode right = commonAncestor(root.right, a, b);
		
		if(left != null && right != null)	return root;
		if(left != null || right != null)	return left != null ? left : right;
		if(left == null && right == null)	return null;
		
		return null;
 	}
	
	public static void main(String args[]){
		Q48_CommonAncestor common = new Q48_CommonAncestor();
		TreeNode root = CreateTree();
		

		//emptyTree(common, null);
		//singleNode(common, new TreeNode(10));

		regularAncestor(common, root);
		Tree.printBinaryTree(root);
		
		//oneNodeAncestorOfAnother(common, root);
		
		noAncestor(common, root);		
	}

	private static void noAncestor(Q48_CommonAncestor common, TreeNode root) {
		System.out.println(common.commonAncestor(root, new TreeNode(1000), root.left.left.left).data);				
	}
//
//	private static void oneNodeAncestorOfAnother(Q48_CommonAncestor common, TreeNode root) {
//		System.out.println(common.commonAncestor(root, root.left.left.left, root.left));	
//	}

	private static void regularAncestor(Q48_CommonAncestor common, TreeNode root) {
		System.out.println(common.commonAncestor(root, root.left.left.left, root.left.right.right).data);		
	}

//	private static void singleNode(Q48_CommonAncestor common, TreeNode root) {
//		System.out.println(common.commonAncestor(root, new TreeNode(100), new TreeNode(500)));		
//	}
//
//	private static void emptyTree(Q48_CommonAncestor common, Object object) {
//		
//	}

	private static TreeNode CreateTree() {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		root.left.left.left = new TreeNode(8);
		root.left.right.right = new TreeNode(7);
		
		
		return root;
	}
	
}
