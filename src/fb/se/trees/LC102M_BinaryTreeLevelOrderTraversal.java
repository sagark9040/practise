package fb.se.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */

public class LC102M_BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
	    if(root == null)						//							<---- I FORGOT THIS INITIALLY
			return new ArrayList<List<Integer>>();	
        
		List<List<Integer>> nodes = new ArrayList<List<Integer>>();		
		Queue<TreeNode> parent = new LinkedList<TreeNode>();
		Queue<TreeNode> children = new LinkedList<TreeNode>();
		List<Integer> row = new ArrayList<Integer>();
		
		children.add(root);
		row.add(root.val);
		
		while(!children.isEmpty()) {
			parent = children;			
			nodes.add(row);			
			row = new ArrayList<Integer>();
			children = new LinkedList<TreeNode>();
			while(!parent.isEmpty()) {
				TreeNode cur = parent.poll();
				
				if(cur.left != null) {children.add(cur.left); row.add(cur.left.val);}
				if(cur.right != null) {children.add(cur.right); row.add(cur.right.val);}
			}
		}
		return nodes;
    }
}
