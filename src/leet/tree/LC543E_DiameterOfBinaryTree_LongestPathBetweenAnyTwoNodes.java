package leet.tree;

public class LC543E_DiameterOfBinaryTree_LongestPathBetweenAnyTwoNodes {
	//450 pm .. 508 pm
	
	int longestPath = 0;
	
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return longestPath;
    }

    
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
		threeElementTree();
	}
	public static void threeElementTree(){
		TreeNode tree;
		
		tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.left.left = new TreeNode(4);
		tree.left.left.left = new TreeNode(6);
		tree.left.left.left.left = new TreeNode(7);
		tree.left.left.left.left.left = new TreeNode(8);
		tree.left.right = new TreeNode(5);
		
		tree.right = new TreeNode(3);
		
		printBinaryTree(tree);		

		
	}
	
	public static void printBinaryTree(TreeNode root){
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("	 			BINARY TREE									    ");
		System.out.println("------------------------------------------------------------------------------------");
		printBinaryTree(root, 0);
	}
	public static void printBinaryTree(TreeNode root, int level){		
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.val);
	    }
	    else
	        System.out.println(root.val);
	    printBinaryTree(root.left, level+1);
	}  
	
}
