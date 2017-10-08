package ctci.Chp4_TreesAndGraphs;

public class Q45_IsBST {

	static boolean isBST(TreeNode root, int min, int max){
		if(root == null)
			return true;
		
		if(!(root.data >= min) || !(root.data <= max)){
			System.out.print("root:" + root.data + " min:" + min + " max:" + max + "\t THEREFORE --> ");
			return false;
		}
		
		int leftMin = Math.min(min, root.data);
		int rightMax = Math.max(max, root.data);
		
		return isBST(root.left, leftMin, root.data) && isBST(root.right, root.data+1, rightMax);
	}
	
	public static void main(String args[]){
		
		bstSuccess();		
		falseCase();
	}
	
	
	private static void bstSuccess() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right  = new TreeNode(5);
		
		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));		
	}

	static void falseCase(){
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right  = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(12);
		
		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
	}
	
}
