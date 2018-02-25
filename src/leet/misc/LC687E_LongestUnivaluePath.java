package leet.misc;

public class LC687E_LongestUnivaluePath {
	
	// THIS ANSWER PASSED 35 test cases on Leetcode. Failed at 36th. There were a total of 68 test cases!	
	
	public static int longestUnivaluePathNOTSURE(TreeNode root) {
		//Base case --> zero or 1 node in the tree
        if(root == null || (root.left == null & root.right == null))
            return 0;
        
        int longestPathToLeft = longestUnivaluePathNOTSURE(root.left);
        int longestPathToRight = longestUnivaluePathNOTSURE(root.right);
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
	
	static int ans;
    public static int longestUnivaluePathOPTIMAL(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public static int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		System.out.println(longestUnivaluePathOPTIMAL(root));
		
		
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		System.out.println(longestUnivaluePathOPTIMAL(root));
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
