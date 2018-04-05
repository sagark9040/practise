package leet.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC117M_PopulatingNextRightPointers {
	// 1126

	// root - l,r,next all null
	// root - l->null
	// root - l->r r->null

	// 1

	// 1
	// 2

	// 1
	// 2 --> 3

	// 1
	// 3 --> null

	// 1
	// 2 3
	// 4 5

	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		Queue<TreeLinkNode> parents = new LinkedList<TreeLinkNode>();
		parents.offer(root);

		while (!parents.isEmpty()) {
			Queue<TreeLinkNode> children = new LinkedList<TreeLinkNode>();

			while (!parents.isEmpty()) {
				TreeLinkNode parent = parents.poll();

				if (parent.left != null) {
					children.offer(parent.left);
				}
				if (parent.right != null) {
					children.offer(parent.right);
				}
			}

			TreeLinkNode node = children.isEmpty() ? null : children.peek();
			TreeLinkNode prev = null;
			for (TreeLinkNode n : children) {
				if (n == node) {
					prev = node;
				} else {
					prev.next = n;
					prev = prev.next;
				}
			}

			parents = new LinkedList<TreeLinkNode>(children);
		}

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
