package leet.tree;

public class ClosestValueInBST {

	double closestGap = Double.MAX_VALUE;
	int closestNodeVal = 0;
	
	// Brute Force
	public int closestValue(TreeNode root, double target) {		
		closestValueUtil(root, target);
		return closestNodeVal;
	}
	
    public void closestValueUtil(TreeNode root, double target) {
        
    	if(root == null)
    		return;
    	
    	closestValueUtil(root.left, target);    	
    	
    	//double leftGap = 0, rightGap = 0;
    	double gap = Math.abs(root.val - target);
    	if (gap < closestGap) {
    		closestGap = gap;
    		closestNodeVal = root.val;
    	}
    	
    	closestValueUtil(root.right, target);
    }

	
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


