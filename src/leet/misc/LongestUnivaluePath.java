package leet.misc;

public class LongestUnivaluePath {
	
	// THIS ANSWER PASSED 35 test cases on Leetcode. Failed at 36th. There were a total of 68 test cases!	
	
	public static int longestUnivaluePath(TreeNode root) {
		//Base case --> zero or 1 node in the tree
        if(root == null || (root.left == null & root.right == null))
            return 0;
        
        int longestPathToLeft = longestUnivaluePath(root.left);
        int longestPathToRight = longestUnivaluePath(root.right);
        int longestPath = 0;
        
        if(root.left != null && root.right != null && 
           root.left.val == root.val && root.right.val == root.val) {
            longestPath = longestPathToLeft + longestPathToRight + 2;
            return longestPath;
        }
        else if(root.left != null && root.left.val == root.val) {
            longestPathToLeft += 1;                
        }
        else if(root.right != null && root.right.val == root.val) {
            longestPathToRight += 1;
        }
        
        longestPath = Math.max(longestPath, Math.max(longestPathToLeft, longestPathToRight));
        return longestPath;            
    }
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		System.out.println(longestUnivaluePath(root));
		
		
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		System.out.println(longestUnivaluePath(root));
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
