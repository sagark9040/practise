package leet.tree;

public class LC111E_MinimumDepthOfTree {
	
	// THIS WAS A SIMPLE PROBLEM. TC for one subtree being null and other not would've failed!
	
	public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }
    
    public int getMinDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } 
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        int leftDepth = getMinDepth(root.left);
        int rightDepth = getMinDepth(root.right);
        int curDepth = Math.min(leftDepth, rightDepth) + 1;
        
        return leftDepth == 0 || rightDepth == 0 ? leftDepth+rightDepth+1 : curDepth; //<------ CHECKING l =0 r = 0 is KEY!!!!
    }
}
