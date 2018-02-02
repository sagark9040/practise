package leet.tree;

public class LC298M_BinaryTreeLongestConsequetiveSequence {

	    //1008pm to 1020 pm!!! 
	    //Seems like a classic DFS candidate
	    //Everytime I traverse either left or right, I pass the prev number, prev seq
	    
	    int maxSeq = 0;
	    public int longestConsecutive(TreeNode root) {
	        if(root == null)    return maxSeq;
	        if(root.left == null && root.right == null)     return 1;
	        
	        dfs(root, Integer.MIN_VALUE, 0);
	        return maxSeq;
	    }
	    
	    public void dfs(TreeNode root, int prevVal, int curSeq) {
	        if(root == null)    return;
	        curSeq = root.val == prevVal+1 ? curSeq+1 : 1;
	        maxSeq = Math.max(maxSeq, curSeq);
	        
	        dfs(root.left, root.val, curSeq);
	        dfs(root.right, root.val, curSeq);
	    }
	}