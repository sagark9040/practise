package fb.se.trees;

public class LC156M_BinaryTreeUpsideDown {
	
	// Was able to get this after a rough work, level by level.
	// Forgot to test for single node tree - got that wrong initially.
	
    boolean foundRoot = false; 
    TreeNode finalRoot = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root != null && root.left == null && root.right == null) // Had to add this check later for tree is size 1.
            return root;
        
        upsideDownBinaryTreeUtil(root);
        return finalRoot;
    }
    
    public TreeNode upsideDownBinaryTreeUtil(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;
        
        TreeNode newRoot = upsideDownBinaryTreeUtil(root.left);
        if(!foundRoot) {
            foundRoot = true;
            finalRoot = newRoot;
        }
        newRoot.right = root;
        newRoot.left = root.right;
        root.left = null; root.right = null;
        
        return newRoot.right;
    }
}
