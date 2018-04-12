package leet.tree;

public class LC814M_TreePruning {
	public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return null;
        }    
        
        if(root.left == null && root.right == null) {
            return root.val == 0 ? null : root;
        }
        
        if(root.left != null) {
            root.left = pruneTree(root.left);            
        }
        
        if(root.right != null) {
            root.right = pruneTree(root.right);
        }
        
        return root.left != null || root.right != null ? root : (root.val == 1 ? root : null);
    }
}
