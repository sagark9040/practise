package ctci.Chp4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/*
5 
3 7 
10 
12 8 6 
50 75 
100 

12 should not be on a new line
*/


public class Q43_ListsOfDepths {

	static ArrayList<LinkedList<TreeNode>> listsOfDepths = new ArrayList<LinkedList<TreeNode>>();
	static LinkedList<TreeNode> finalList = new LinkedList<TreeNode>();
	
	static void createFinalList(TreeNode root){
		if(root == null)			return;
		
		if(root.left == null && root.right == null){
			listsOfDepths.add(new LinkedList<TreeNode>(Arrays.asList(root)));
		}
		
		LinkedList<TreeNode> tempList = new LinkedList<TreeNode>();
		
		root.isFirst = true;
		boolean markNextFirst = false;
		tempList.add(root);
		
		while(!tempList.isEmpty()){
			TreeNode n = tempList.removeFirst();
			
			if(markNextFirst){
				n.isFirst = true;
				markNextFirst = false;
			}
			
			if(n.isFirst){
				if(n.left == null && n.right == null){
					markNextFirst = true;
				}
				else if(n.left != null && n.right == null){
					n.left.isFirst = true;
					tempList.add(n.left);
				}
				else if(n.left == null && n.right != null){
					n.right.isFirst = true;
					tempList.add(n.right);
				}
				else{
					n.left.isFirst = true;
					tempList.add(n.left);
					tempList.add(n.right);
				}				
			}
			else {
				if(n.left != null)
					tempList.add(n.left);					
				if(n.right != null)
					tempList.add(n.right);
			}			
					
			finalList.add(n);
		}
	}
	
	static LinkedList<TreeNode> addToTempList(LinkedList<TreeNode> tempList, TreeNode n, boolean markNextFirst){
		
		if(n.isFirst){
			if(n.left == null && n.right == null)
				markNextFirst = true;
			else if(n.left != null && n.right == null){
				n.left.isFirst = true;
				tempList.add(n.left);
			}
			else if(n.left == null && n.right != null){
				n.right.isFirst = true;
				tempList.add(n.right);
			}
			else{
				n.left.isFirst = true;
				tempList.add(n.left);
				tempList.add(n.right);
			}				
		}
		else {
			if(n.left != null)
				tempList.add(n.left);					
			if(n.right != null)
				tempList.add(n.right);
		}
		
		return tempList;
	}
	
	static void createListOfList(){
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		System.out.println("");
		TreeNode cur = null;
		
		for(TreeNode cur1: finalList){
			if(cur1.isFirst){
				listsOfDepths.add(list);
				list = new LinkedList<TreeNode>(); System.out.println();
			}
			list.add(cur1);	System.out.print(cur1.data + " ");		
		}
		
		if(cur == null){
			listsOfDepths.add(list);
		}
	}
	public static void main(String args[]){
				
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
		
		
		Tree tree = new Tree();
		ArrayList<LinkedList<TreeNode>> allDepths = new ArrayList<LinkedList<TreeNode>>();
		allDepths = ctciSolnDepths(root);
		
		printALofLL(allDepths);
		
		
		//tree.printBinaryTree(root);
		
		/*
		My Solution
		 
		createFinalList(root);
		createListOfList();
		 */
		
		//CTCI Solution
		
	}
	
	private static void printALofLL(ArrayList<LinkedList<TreeNode>> result) {
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}


	public static ArrayList<LinkedList<TreeNode>> ctciSolnDepths(TreeNode root){
		if(root == null)
			return null;
		
		LinkedList<TreeNode> currentLevelNodes = new LinkedList<TreeNode>(Arrays.asList(root));
		LinkedList<TreeNode> parentLevelNodes = new LinkedList<TreeNode>();
		ArrayList<LinkedList<TreeNode>> allDepths = new ArrayList<LinkedList<TreeNode>>();
		
		while(!currentLevelNodes.isEmpty()){
			allDepths.add(currentLevelNodes);
			parentLevelNodes = currentLevelNodes;
			currentLevelNodes = new LinkedList<TreeNode>();
			
			for(TreeNode parentNode: parentLevelNodes){
				if(parentNode.left != null)
					currentLevelNodes.add(parentNode.left);
				if(parentNode.right != null)
					currentLevelNodes.add(parentNode.right);
			}
		}
		
		return allDepths;
	}
	
}




















