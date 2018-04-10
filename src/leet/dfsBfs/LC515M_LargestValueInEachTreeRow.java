package leet.dfsBfs;

import java.util.ArrayList;
import java.util.List;

import ctci.Chp4_TreesAndGraphs.TreeNode;

public class LC515M_LargestValueInEachTreeRow {
	
	// careful about largest value or smallest value ..	
	// 10 min AC .. didn't really learn much from this
	
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> maxValues = new ArrayList<>();
		maxValue(root, maxValues, 0);
		return maxValues;
	}

	public void maxValue(TreeNode root, List<Integer> maxValues, int level) {
		if(root == null) return;

		if(maxValues.size() <= level)
			maxValues.add(root.data);
		if(maxValues.get(level) < root.data)   
			maxValues.set(level, root.data);

		maxValue(root.left, maxValues, level+1);
		maxValue(root.right, maxValues, level+1);
	}
}
/*
	          1
	         / \
	        3   2
	       / \   \  
	      5   3   9 

 */
 
