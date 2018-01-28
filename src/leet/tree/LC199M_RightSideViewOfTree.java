package leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199M_RightSideViewOfTree {
	public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        
        ArrayList<Integer> lastNodes = new ArrayList<Integer>();
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        Queue<TreeNode> parents = new LinkedList<TreeNode>();
        
        children.add(root);
        
        while(!children.isEmpty()) {
            parents = children;
            children = new LinkedList<TreeNode>();
            
            TreeNode last = null;
			while(!parents.isEmpty()) {
                TreeNode cur = parents.poll();
                if(cur.left != null) {   children.add(cur.left); last  = cur.left; }
                if(cur.right != null) {   children.add(cur.right);	last = cur.right; }
            }
			
            if (last != null)
            	lastNodes.add(last.val);
        }       
        return lastNodes;
    }
}
