package test.j12;

import java.util.LinkedList;
import java.util.Queue;

//- Trees & Graphs - BFS/DFS, Pre,Post,In traversals, Adj List, Matrix
//- DAG, AVL, R/B
//- Arrays/Lists/Stacks/Queues/HashMaps/HashSets/HashTables/LL-Insertions, Deletions, Retrieval
//- Iterator, Comparator
//- Bit Shifts


class Tree{
	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int d){
			data = d;
		}
	}

	
	Node root;
	
	void addNode(int data){
		boolean isLeft = false;
		
		if(root == null){
			root = new Node(data);
			return;
		}
		Node cur = root;
		Node parent = cur;
		while(cur!=null){
			parent = cur;
			if(data<cur.data){
				cur=cur.left;	
				isLeft = true;
			}
			else{
				cur=cur.right;
				isLeft = false;
			}
		}
		
		if(isLeft)
			parent.left = new Node(data);
		else
			parent.right = new Node(data);
		return;
	}
	
	void bfsTraversal(){
		if(root == null) //This if block is a problem 
			return;
			
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){ //TODO is empty or .hasElements()
			Node node = q.remove(); // TODO: Poll
			System.out.print(node.data + " ");
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
	}
	
	void dfsTraversalInOrder(Node root){
		if(root == null)
			return;
		
		dfsTraversalInOrder(root.left);
		System.out.print(root.data + " ");
		dfsTraversalInOrder(root.right);
	}
	
	void dfsTraversalPreOrder(Node root){
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		dfsTraversalPreOrder(root.left);
		dfsTraversalPreOrder(root.right);
	}
}

public class TreeNodeImpl{
	public static void main(String args[]){
		Tree tree = new Tree();		
		tree.addNode(4);
		tree.addNode(2);
		tree.addNode(6);
		tree.addNode(1);
		tree.addNode(7);
		tree.addNode(5);
		tree.addNode(3);
		
		System.out.println("\nBFS:");
		tree.bfsTraversal();
		
		System.out.println("\nDFS In Order:");
		tree.dfsTraversalInOrder(tree.root);
		
		System.out.println("\nDFS Pre Order:");
		tree.dfsTraversalPreOrder(tree.root);
	}
	
//			4
//		2		6
//	  1	  3	  5   7
}








