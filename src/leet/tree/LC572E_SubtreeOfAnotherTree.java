package leet.tree;

public class LC572E_SubtreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return false;
		}

		if (matchingSubtree(s, t)) {
			return true;
		}

		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	public boolean matchingSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;
		if (s.val != t.val)
			return false;

		return matchingSubtree(s.left, t.left) && matchingSubtree(s.right, t.right);
	}

	// both are null - true
	// left not null and same - true
	// right not null and same - true

}