package fb.se.trees;

/*Given

	  1
	 / \
	2   5
   / \   \
  3   4   6
The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
*/
	             
public class FlattenABinaryTreeToLL {
	TreeNode list = new TreeNode();
	
	void inOrder(TreeNode root){
		if(root == null)
			return;
		
		System.out.println(root.data);
		list.right = root;
		
		inOrder(root.left);
		inOrder(root.right);		
	}
	
	public static void main(String args[]){
		FlattenABinaryTreeToLL flatten = new FlattenABinaryTreeToLL();
		
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		Tree.printBinaryTree(root);
		flatten.list = root;
		flatten.inOrder(root);

		Tree.printBinaryTree(flatten.list);
	}
	
}

class ListNode{
	int data;
	ListNode next;
}
