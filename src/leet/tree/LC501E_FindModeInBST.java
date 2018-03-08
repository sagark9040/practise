package leet.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC501E_FindModeInBST {
	//753pm
    //1,2,2
    //1-1
    //2-2
    
    //1-1,2 ... 2-0
    //1-1 .. 2-1 .. maxCount = 2
    
    //Algo:
    //Iterate through the tree in-order
    //          update the map -> elem, count
    //          update the count -> remove from old count's set and update in the new counte's
    //          update the maxCount if applicable
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	Map<Integer, Set<Integer>> counts = new HashMap<Integer, Set<Integer>>();
	int maxCount = 0;

	public int[] findMode(TreeNode root) {
		populateMaps(root);
		int[] res = {};
		return (maxCount == 0) ? res : toInt(counts.get(maxCount));
	}

	public int[] toInt(Set<Integer> set) {
		int[] a = new int[set.size()];
		int i = 0;
		for (Integer val : set)
			a[i++] = val;
		return a;
	}

	public void populateMaps(TreeNode root) {
		if (root == null) {
			return;
		}

		populateMaps(root.left);
		int count = 0;
		if (map.containsKey(root.val)) {
			count = map.get(root.val);
		}

		Set<Integer> mySet = new HashSet<Integer>();
		if (count > 0) {
			mySet = counts.get(count);
			mySet.remove(root.val);
			counts.put(count, mySet);
		}

		mySet = new HashSet<Integer>();
		if (counts.containsKey(count + 1)) {
			mySet = counts.get(count + 1);
		}
		mySet.add(root.val);
		map.put(root.val, count + 1);
		counts.put(count + 1, mySet);
		maxCount = Math.max(maxCount, count + 1);

		populateMaps(root.right);
	}
}
