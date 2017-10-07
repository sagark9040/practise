package ctci.Chp4_TreesAndGraphs;

public class Tree{
	public TreeNode root;

	public Tree(TreeNode node) {
		this.root = node;
	}
	
	public Tree() {
		// TODO Auto-generated constructor stub
	}

	public void printTree(TreeNode root){
		
		System.out.println(root.data);
		printTree(root.left); 
		System.out.print(" ");
		printTree(root.right);
		
	}	
	public static void printBinaryTree(TreeNode root){
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("	 			BINARY TREE									    ");
		System.out.println("------------------------------------------------------------------------------------");
		printBinaryTree(root, 0);
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
	
	public static void main(String args[]){
		TreeNode n5 = new TreeNode(5);
		n5.left = new TreeNode(3);
		
		n5.left.left = new TreeNode(1);
		n5.left.right = new TreeNode(4);
		
		n5.right = new TreeNode(10);
		
		n5.right.left = new TreeNode(8);
		n5.right.right = new TreeNode(12);
		
		printBinaryTree(n5);
	}
}

class TreeNode{
	public TreeNode(int i) {
		this.data = i;
	}

	public int data;
	public TreeNode left, right;
	
	public void setLeftChild(TreeNode left){
		this.left = left;
	}
	
	public void setRightChild(TreeNode right){
		this.right = right;
	}
}
