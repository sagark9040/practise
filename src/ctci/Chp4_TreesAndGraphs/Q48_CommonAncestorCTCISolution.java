package ctci.Chp4_TreesAndGraphs;

public class Q48_CommonAncestorCTCISolution {

	int findCommonAncestor(TreeNode root, TreeNode first, TreeNode second){
		ResultAnc r = commonAncestor(root, first, second);
		if(r.isAncestor)
			return r.node.data;
					
		return Integer.MIN_VALUE;
	}
	
	ResultAnc commonAncestor(TreeNode root, TreeNode first, TreeNode second){
		if(root == null) 
			return new ResultAnc(null, false);
		
		if(root == first && root == second)
			return new ResultAnc(root, true);

		ResultAnc resultLeft = commonAncestor(root.left, first, second);
		
		if(resultLeft.isAncestor)
			return resultLeft;
		
		ResultAnc resultRight = commonAncestor(root.right, first, second);
		
		if(resultRight.isAncestor)
			return resultRight;
		
		if(resultLeft.node != null & resultRight.node != null)
			return new ResultAnc(root, true);
		else if(root == first || root == second){
			boolean isAncestor = resultLeft.node != null || resultRight.node != null;
			return new ResultAnc(root, isAncestor);
		}
		else
			return new ResultAnc(resultLeft.node != null ? resultLeft.node : resultRight.node, false);				
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);		
		
		TreeNode eight = new TreeNode(8);
		root.left.left.left = eight;		
		TreeNode seven = new TreeNode(7);
		root.left.right.right = seven;
		
		root.right.right.right = eight;
		
		Q48_CommonAncestorCTCISolution commonAncestor = new Q48_CommonAncestorCTCISolution();		
		System.out.println(commonAncestor.findCommonAncestor(root, root.left.left.left , root.left.right.right));
		Tree.printBinaryTree(root);
	}
	
}

class ResultAnc{
	public TreeNode node;
	public boolean isAncestor;
	
	public ResultAnc(TreeNode n, boolean isAncestor){
		node = n;
		this.isAncestor = isAncestor;
	}
}