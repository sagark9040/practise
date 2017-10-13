package fb.se.trees;

import java.util.ArrayList;
import java.util.LinkedList;

//calculate average value of each level of BT

//Thoughts:
//Traverse each level of a Binary Tree and get the total number of elements.
//Also get the sum of the level whilst doing that.
//Keep adding that to the list of averages that we've gathered so far.

/* ------------------------------------------------------------
 *							IMPORTANT
 * ------------------------------------------------------------
 * Similar to the print list of depths of binary tree question 
 */


public class AverageValueOfEachLevelBinTree {

	ArrayList<Integer> averages = new ArrayList<Integer>();
	ArrayList<Integer> numOfNodes = new ArrayList<Integer>();
	
	void getAveragesByLevel(TreeNode root){
		if(root == null)
			return;
		
		LinkedList<TreeNode> childNodes = new LinkedList<TreeNode>();
		LinkedList<TreeNode> parentNodes = new LinkedList<TreeNode>();
		
		childNodes.add(root);
		int sum = root.data;
		int numOfNodes = 1;
		averages.add(sum/numOfNodes);
		
		while(!childNodes.isEmpty()){
			
			parentNodes = childNodes;
			childNodes = new LinkedList<TreeNode>();
			sum = 0;
			numOfNodes = 0;
			
			for(TreeNode parent: parentNodes){				
				if(parent.left != null){
					childNodes.add(parent.left);
					sum += parent.left.data;
					numOfNodes++;
				}
				
				if(parent.right != null){
					childNodes.add(parent.right);
					sum+= parent.right.data;
					numOfNodes++;
				}				
			}
			
			if(numOfNodes > 0)
				averages.add(sum/numOfNodes);			
		}
	}
	
	public static void main(String args[]){
		AverageValueOfEachLevelBinTree avgValue = new AverageValueOfEachLevelBinTree();
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(6);
		
		root.left.right.right = new TreeNode(50);
		root.right.right.right = new TreeNode(75);
		
		root.left.right.right.left = new TreeNode(100);
		avgValue.getAveragesByLevel(root);
		
		for(Integer val: avgValue.averages){
			System.out.println(val);
		}
	}
}

