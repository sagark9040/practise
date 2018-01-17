package leet.tree;

import ctci.Chp4_TreesAndGraphs.Tree;
import ctci.Chp4_TreesAndGraphs.TreeNode;

/**
Inorder Successor in BST
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Java	





  Definition for a binary tree node.

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

 */

//Thoughts 
// Iterate in order fashion and then once node p has been found, the next to show is the  successor

//TCs
//Empty tree
//One element tree
//Last leaf as p
//Last of left subtree as p
//Root as p
//p not present
//LinkedList as tree, p somewhere there

public class LC285M_InOrderSuccessor {
	boolean isNext = false;
	TreeNode nextElem = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	if (root == null || p == null)
    		return null;
    	
    	inOrdeSuccessorUtil(root, p);
    	return nextElem;
    }
    public void inOrdeSuccessorUtil(TreeNode root, TreeNode p) {

    	inorderSuccessor(root.left, p);
    	if (isNext) {
    		nextElem = root;
    		isNext = false;
    	}

    	if (root == p) {
    		isNext = true;
    	}
    	inorderSuccessor(root.right, p);
    }
    
    public static void main(String args[]) {
    	TreeNode treeNode = new TreeNode(4);

    	treeNode.left = new TreeNode(2);
    	treeNode.left.left = new TreeNode(1);
    	treeNode.left.right = new TreeNode(3);
    	
    	treeNode.right = new TreeNode(6);
    	treeNode.right.left = new TreeNode(5);
    	treeNode.right.right = new TreeNode(7);
    	treeNode.right.right.right = new TreeNode(8);
    	
    	printBinaryTree(treeNode, 0);
    	System.out.println();
    	LC285M_InOrderSuccessor inOrder = new LC285M_InOrderSuccessor();
    	
    	TreeNode p = treeNode.right.right.right;
    	TreeNode next = inOrder.inorderSuccessor(treeNode, p);
		if(next != null)
    		System.out.println("P -->" + p.data + " Next-->" + next.data);
    }
    
    public static void printBinaryTree(TreeNode root, int level){		
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.data);
	    }
	    else
	        System.out.println(root.data);
	    printBinaryTree(root.left, level+1);
	}   
}