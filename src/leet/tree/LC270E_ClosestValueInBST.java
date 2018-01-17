package leet.tree;

// PRETTY SIMPLE SOLUTION WITH SECOND ATTEMPT MAKING IT ULTIMATELY SUCCESSFUL.

public class LC270E_ClosestValueInBST {

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
    
    public void closestValueUtilEfficient(TreeNode root, double target) {
        
    	if(root == null)
    		return;

    	//double leftGap = 0, rightGap = 0;
    	double gap = Math.abs(root.val - target);
    	if (gap < closestGap) {
    		closestGap = gap;
    		closestNodeVal = root.val;
    	}
    	
    	if (root.val > target)
    		closestValueUtilEfficient(root.left, target); 
    	else	
    		closestValueUtilEfficient(root.right, target); 
    	
    }
}