package ctci.Chp4_TreesAndGraphs;

public class Q42_CreateMinBST {

	 static TreeNode createMinBST(int[] arr, int start, int end){
		
		//Base cases not necessary, to be honest here 
		if(arr.length == 0) return null;
		if(arr.length == 1) return new TreeNode(arr[0]);
		 
		TreeNode root = null;
		
		if(start <= end) {
		
			int mid = (start + end)/2;
			root = new TreeNode(arr[mid]);		
			
			root.setLeftChild(createMinBST(arr, start, mid-1));
			root.setRightChild(createMinBST(arr, mid+1, end));
			
		}
		
		return root;
	}
	
	public static void main(String args[]){		

		// Test Cases		
		emptyArray();
		oneElemArray();
		twoElemArray();
		multipleElementsArray();
		
	}

	public static void emptyArray(){
		int[] arr = {};
		TreeNode root = createMinBST(arr, 0, arr.length-1);
		Tree.printBinaryTree(root);
	}
	public static void oneElemArray(){
		int[] arr = {1};
		TreeNode root = createMinBST(arr, 0, arr.length-1);
		Tree.printBinaryTree(root);
	}
	public static void twoElemArray(){
		int[] arr = {1, 2};
		TreeNode root = createMinBST(arr, 0, arr.length-1);
		Tree.printBinaryTree(root);
	}
	public static void multipleElementsArray(){
		int[] arr = {1, 2, 3, 4, 5};
		TreeNode root = createMinBST(arr, 0, arr.length-1);
		Tree.printBinaryTree(root);
	}
	
}
