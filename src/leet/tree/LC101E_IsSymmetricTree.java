package leet.tree;

public class LC101E_IsSymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	public boolean isSymmetric(TreeNode rootOne, TreeNode rootTwo) {
		if (rootOne == null && rootTwo == null)
			return true;
		if (rootOne == null || rootTwo == null)
			return false;
		if (rootOne.val != rootTwo.val)
			return false;

		return isSymmetric(rootOne.left, rootTwo.right) && isSymmetric(rootOne.right, rootTwo.left);
	}
}
