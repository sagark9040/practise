package leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LC103M_BinaryTreeZigZagOrderTraversal {
	// 835pm
	// level order traversal
	// root .. add to list .. keep track of level, if even - in order, if odd -
	// reverse
	// 0 // 3
	// 1 // 9 20 (rev)
	// 2 // 15 7

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> previousLevel = new LinkedList<TreeNode>();
		previousLevel.offer(root);
		int level = 0;

		while (!previousLevel.isEmpty()) {

			Queue<TreeNode> pre = new LinkedList<TreeNode>(previousLevel);
			if (level % 2 == 0) {
				result.add(toList(pre));
			} else {
				result.add(toList(reverse(pre)));
			}

			Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();

			while (!previousLevel.isEmpty()) {
				TreeNode previous = previousLevel.poll();

				if (previous.left != null)
					currentLevel.offer(previous.left);
				if (previous.right != null)
					currentLevel.offer(previous.right);
			}
			previousLevel = currentLevel;
			level++;
		}

		return result;
	}

	Queue<TreeNode> reverse(Queue<TreeNode> queue) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!queue.isEmpty()) {
			stack.add(queue.peek());
			queue.remove();
		}
		while (!stack.isEmpty()) {
			queue.add(stack.peek());
			stack.pop();
		}
		return queue;
	}

	List<Integer> toList(Queue<TreeNode> q) {
		List<Integer> result = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			result.add(q.poll().val);
		}
		return result;
	}

}