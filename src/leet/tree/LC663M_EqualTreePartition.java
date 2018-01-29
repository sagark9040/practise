package leet.tree;

import java.util.HashMap;
import java.util.Map;

 ///// VERY VERY INTERESTING SOLUTION ... SMART WAY TO SOLVE A PROBLEM THAT OTHERWISE MIGHT BE TRICKY FOR CORNER CASES

public class LC663M_EqualTreePartition {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int sum = 0;
	
    public boolean checkEqualTree(TreeNode root) {
    	if(root == null || (root.left == null && root.right == null))
    		return false;
    	
    	sum = getAllSums(root);
    	if(sum == 0)
    		return map.containsKey(sum) && map.get(sum) > 1;
        return sum%2 == 0 && map.containsKey(sum/2);
	}

	public int getAllSums(TreeNode root) {
		if(root == null)	return 0;
		
		int leftSum = getAllSums(root.left);
		int rightSum = getAllSums(root.right);
		int cur = leftSum + root.val + rightSum;
		if(!map.containsKey(cur))
			map.put(cur, 1);
		else
			map.put(cur, map.get(cur) + 1);
		
		return cur;				
	}
}