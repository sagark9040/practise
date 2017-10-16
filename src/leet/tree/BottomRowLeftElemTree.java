package leet.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BottomRowLeftElemTree {

	 
	 
     public static int findBottomLeftValue(TreeNode root) {
		
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        children.add(root);
        int first = 0;
        
        while(!children.isEmpty()){
        	first = children.peek().val;
        	Queue<TreeNode> parents = children;
        	children = new LinkedList<TreeNode>();
        	
        	for(TreeNode parent: parents){
        		if(parent.left != null)
        			children.add(parent.left);
        		if(parent.right != null)
        			children.add(parent.right);
        	}
        }        
        return first;
     }
     
     public static void main(String args[]){
    	 singleElement();
    	 exampleOneFromLeet();
    	 exampleTwoFromLeet();
     }

	private static void exampleTwoFromLeet() {
		TreeNode root = new TreeNode(1);
		System.out.println(findBottomLeftValue(root));
	}

	private static void exampleOneFromLeet() {
//	        1
//	       / \
//	      2   3
//	     /   / \
//	    4   5   6
//	       /
//	      7
	      TreeNode root = new TreeNode(1);
	      root.left = new TreeNode(2);
	      root.left.left = new TreeNode(4);
	      root.right = new TreeNode(3);
	      root.right.left = new TreeNode(5);
	      root.right.right = new TreeNode(6);
	      root.right.left.left = new TreeNode(7);
	      
	      System.out.println(findBottomLeftValue(root));
	}

	private static void singleElement() {
		// TODO Auto-generated method stub
		
	}
	
	
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
