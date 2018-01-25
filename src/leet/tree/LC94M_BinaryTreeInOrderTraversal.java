package leet.tree;

import java.util.ArrayList;
import java.util.List;

public class LC94M_BinaryTreeInOrderTraversal {
	
	// This should have been Easy not Medium!	
	
	
    List<Integer> order;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        order = new ArrayList<Integer>();
        traverse(root);
        return order;
    }
    
    public void traverse(TreeNode root) {
        if(root == null)
            return;
        traverse(root.left);
        order.add(root.val);            /// wrote ROOT here instead of ROOT.VAL
        traverse(root.right);
        return;
    }
    
}

