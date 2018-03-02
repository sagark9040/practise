package leet.tree;

public class LC106E_BalancedBinaryTree {
	public boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedTree(root);
        return balanced;
    }
    
    public int isBalancedTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftHeight = isBalancedTree(root.left);
        int rightHeight = isBalancedTree(root.right);
        
        if(Math.abs(leftHeight - rightHeight) > 1 && balanced) {
            balanced = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;        
    }
}
