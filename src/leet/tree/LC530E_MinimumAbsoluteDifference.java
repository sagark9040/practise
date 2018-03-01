package leet.tree;

import java.util.Set;
import java.util.TreeSet;

public class LC530E_MinimumAbsoluteDifference {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    // 1,2,3,4 - go over them one by one and find the minimum diff
	    // range of these values? 
	    // duplicates? - 1, 1 zero
	    //1143
	    
	    int minDiff = Integer.MAX_VALUE;
	    public int getMinimumDifference(TreeNode root) {
	        Set<Integer> values = new TreeSet<Integer>();        
	        recordValues(root, values);
	        return minDiff == 0 ? minDiff : getMinDiff(values);
	    }
	    
	    public int getMinDiff(Set<Integer> values) {
	        int prev = Integer.MAX_VALUE;
	        
	        for(int v:values) {
	            if(Math.abs(v-prev) < minDiff) {
	                minDiff = Math.abs(v-prev);
	            }
	            prev = v;            
	        }
	        return minDiff;
	    }
	    
	    public void recordValues(TreeNode root, Set<Integer> values) {
	        if(root == null)    return;
	        
	        if(values.contains(root.val)) {
	            minDiff = 0;
	            return;
	        }
	        
	        values.add(root.val);
	        recordValues(root.left, values);
	        recordValues(root.right, values);
	    }
	}
}
