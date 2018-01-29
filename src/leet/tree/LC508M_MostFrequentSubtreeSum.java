package leet.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// This question was easier than expected

public class LC508M_MostFrequentSubtreeSum {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	Map<Integer, Integer> sumCount = new HashMap<Integer, Integer>();

    public int[] findFrequentTreeSum(TreeNode root) {
    	
    	sumOfSubtree(root);
    	return computeMaxFreq();
	}
    
    public int[] computeMaxFreq() {
    	int maxCount = Integer.MIN_VALUE;
    	
    	for(Integer key:sumCount.keySet()) {
    		if(sumCount.get(key) > maxCount)
    			maxCount = sumCount.get(key);
    	}
     	
    	ArrayList<Integer> freq = new ArrayList<Integer>();
    	for(Integer key:sumCount.keySet()) {
    		if(sumCount.get(key) == maxCount)
    			freq.add(key);
    	}
    	
    	return convertListToArray(freq);
    }

    public int[] convertListToArray(ArrayList<Integer> freq) {
    	int[] arr = new int[freq.size()];				// CONVERT ARRAYLIST TO ARRAYS ... DIDN'T KNOW THE SHORTHAND

    	for(int i = 0; i < freq.size(); i++) {
    	    if (freq.get(i) != null) {
    	        arr[i] = freq.get(i);
    	    }
    	}
    	return arr;
    }
    
    public int sumOfSubtree(TreeNode root) {
    	if(root == null) return 0;
    	
    	int sumLeft = sumOfSubtree(root.left);
    	int sumRight = sumOfSubtree(root.right);
    	int sum = root.val + sumLeft + sumRight;
    	
    	if(!sumCount.containsKey(sum))
    		sumCount.put(sum, 1);
    	else
    		sumCount.put(sum, sumCount.get(sum)+1);
    	
    	return sum;
    }
    
    public static void main(String args[]) {
    	LC508M_MostFrequentSubtreeSum sub = new LC508M_MostFrequentSubtreeSum();
    	TreeNode t = new TreeNode(5);
    	t.left = new TreeNode(2);
    	t.right = new TreeNode(-5);
    	sub.findFrequentTreeSum(t);
    }
    
//	      5
//	    /  \
//	   2   -5
	
}
