package leet.tree;

import ctci.Chp4_TreesAndGraphs.Tree;
import ctci.Chp4_TreesAndGraphs.TreeNode;

/**
Inorder Successor in BST
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Java	


1

2
 * Definition for a binary tree node.
3
 * public class TreeNode {
4
 *     int val;
5
 *     TreeNode left;
6
 *     TreeNode right;
7
 *     TreeNode(int x) { val = x; }
8
 * }
9
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

public class InOrderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		return p;

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
    	
    	Tree tree = new Tree();
    	printBinaryTree(treeNode, 0);
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