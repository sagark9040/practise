package leet.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LowestCommonAncestor {

	TreeNode commonAncestor = null;
	
	class Result {
		boolean isAncestor = false;
		TreeNode node;
		
		Result(TreeNode n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}
	
    //CTCI Solution for non-present or null node p and q.
	public Result lowestCommonAncestoryCTCI(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		
		Result left = lowestCommonAncestoryCTCI(root.left, p, q);
		if(left.isAncestor)
			return left;
		
		Result right = lowestCommonAncestoryCTCI(root.right, p, q);
		if(right.isAncestor)
			return right;
		
		// Currently at ancestor
		if (left != null && right != null) {
			return new Result(root, true);
		} else if (root == p || root == q) {
			// If one child is not null then, root is the lca of itself and the non-null child
			boolean isAncestor = left.node != null || right.node != null ? true : false;
			return new Result(root, isAncestor);
		} else {
			return new Result(left != null ? left.node : right.node, false);
		}
		
	}
    
    // ASSUMPTION - NODES ARE BOTH PRESENT
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null || root == p || root == q)
			return root;
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	return left == null ? right : right == null ? left : root;    		
    }
    
    public static void main(String args[]) {
    	TreeNode root = new TreeNode(1);
    	LowestCommonAncestor low = new LowestCommonAncestor();
    	TreeNode lca = low.lowestCommonAncestor(root, root, new TreeNode(10));
    	System.out.println(lca.val);
    }
}
