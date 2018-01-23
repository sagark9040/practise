package fb.se.trees;

public class LC226E_InvertBinaryTreeLeftToRight {
	
	//Easiest problem on LC I felt.
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = tempRight;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
