package leet.tree;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinTr {
	public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
    
    public static void main(String args[]) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.right = new TreeNode(7);
    	
    	root.right.right.right = new TreeNode(6);    	
    	
    	WidthOfBinTr w = new WidthOfBinTr();
    	System.out.println(w.widthOfBinaryTree(root));
    }
}
