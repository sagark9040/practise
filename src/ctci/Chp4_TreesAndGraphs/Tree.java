package ctci.Chp4_TreesAndGraphs;

public class Tree{
	public Node root;

	public Tree(Node node) {
		this.root = node;
	}
	
	public Tree() {
		// TODO Auto-generated constructor stub
	}

	public void printTree(Node root){
		
		System.out.println(root.data);
		printTree(root.left); 
		System.out.print(" ");
		printTree(root.right);
		
	}	
	public static void printBinaryTree(Node root){
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("	 			BINARY TREE									    ");
		System.out.println("------------------------------------------------------------------------------------");
		printBinaryTree(root, 0);
	}
	public static void printBinaryTree(Node root, int level){		
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
	
	public static void main(String args[]){
		Node n5 = new Node(5);
		n5.left = new Node(3);
		
		n5.left.left = new Node(1);
		n5.left.right = new Node(4);
		
		n5.right = new Node(10);
		
		n5.right.left = new Node(8);
		n5.right.right = new Node(12);
		
		printBinaryTree(n5);
	}
}

class Node{
	public Node(int i) {
		this.data = i;
	}

	public int data;
	public Node left, right;
	
	public void setLeftChild(Node left){
		this.left = left;
	}
	
	public void setRightChild(Node right){
		this.right = right;
	}
}
