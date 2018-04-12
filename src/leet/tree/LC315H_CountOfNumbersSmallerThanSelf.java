package leet.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LC315H_CountOfNumbersSmallerThanSelf {

	// 102 .. 52 min AC .. way too slow!!!
	// got 35 min 11/16 TCs .. probably not for all TCs, stil SLOW!

	Map<Integer, Integer> values = new HashMap<Integer, Integer>();

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		TreeNodeLowerCount root = null;
		for (int i = nums.length - 1; i >= 0; i--) {
			int num = nums[i];
			TreeNodeLowerCount node = new TreeNodeLowerCount(num, 0, 0);
			root = addToTree(node, root);
			list.add(values.get(num));
		}

		return reverseList(list);
	}

	public List<Integer> reverseList(List<Integer> list) {
		Stack<Integer> stk = new Stack<Integer>();
		for (int num : list) {
			stk.push(num);
		}

		List<Integer> res = new ArrayList<Integer>();
		while (!stk.isEmpty())
			res.add(stk.pop());

		return res;
	}

	public TreeNodeLowerCount addToTree(TreeNodeLowerCount node, TreeNodeLowerCount current) {
		if (current == null) {
			current = new TreeNodeLowerCount(node.val, node.lowerCount, node.count);
			values.put(node.val, node.count);
			return current;
		} else if (node.val > current.val) {
			node.count++;
			node.count += current.lowerCount;
			current.right = addToTree(node, current.right);
		} else {
			current.lowerCount++;
			current.left = addToTree(node, current.left);
		}
		return current;
	}
}

class TreeNodeLowerCount {
	int val;
	int count;
	int lowerCount;
	TreeNodeLowerCount left, right;

	TreeNodeLowerCount(int v, int l, int c) {
		val = v;
		count = c;
		lowerCount = l;
	}
}
