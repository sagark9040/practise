package leet.tree;

import java.util.ArrayList;
import java.util.List;


//AC 10 mins

public class LC230M_KthSmallestElementInABST {
	List<Integer> smallest = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k, 0);
        return smallest.get(k-1);
    }
    
    public void findKthSmallest(TreeNode root, int k, int curCount) {
        if(root == null || curCount >= k) {
            return;
        }
        
        findKthSmallest(root.left, k, curCount);
        smallest.add(root.val);
        findKthSmallest(root.right, k, curCount+1);        
    }
}
