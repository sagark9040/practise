package ctci.Chp4_TreesAndGraphs;

public class TreeNode{
	public int data;
	public TreeNode left, right;
	public boolean isFirst;
	
	public TreeNode(int i) {
		this.data = i;
	}
	
	public void setLeftChild(TreeNode left){
		this.left = left;
	}
	
	public void setRightChild(TreeNode right){
		this.right = right;
	}
}