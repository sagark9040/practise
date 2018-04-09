package leet.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC652M_DuplicateSubTrees {

	//824pm ... 50 min AC ... I was on the right track, a little help might have been needed.. POST ORDER IT WAS as I suspected.
    //Should've just added a '#' instead of a null and separators for left and right children
    // FUCK!!!! 
    
    //Data Structure like set to save a subtree
    //  1
    //2   2 
    
    //      1
    //   2     3
    // 3          1
    //           2
    //          3
    
    // 1  
    //   2
    
    // 2
    //   4
    
    //    2
    //  4
    
    //  1
    // 2
    
    // 2
    // 21
    
    // 1
    // 12
    // 
    
    // keep going left, find the first leaf and add it to the set
    // 
    
    // nullnull3
    // 3null2
    // nullnull3
    // 3null2
    // null3
    // 3null2null1
    // 3null2null1
    // 3null2
    
    //      1
    //          2
    //              3
    // 321
    // null 
    // null null 
    // null null null 3
    //
    
    
    //    1
    //  2
    // 3
    // 3 2 1
    
//     2
//       4
        
//     2
//   4
    
    // if left == null // add null else add left list
    // if right == null // add null else add right list
    // add left + right + root.val
    
    
    
    //     1 
    //    / \
    //   2   3
    //  /   / \
    // 4   2   4
    //    /
    //   4

    // 8:51 At every single node's subtree, is preorder and post order present?
    // 
    
    List<TreeNode> result = new ArrayList<TreeNode>();
    Set<String> set = new HashSet<String>();
    Set<String> alreadyAdded = new HashSet<String>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preOrder(root);
        return result;
    }
    
    public String preOrder(TreeNode node) {
        if(node == null)    return "#";
        String serialized = node.val + "," + preOrder(node.left) + "," + preOrder(node.right);
        if(set.contains(serialized) && !serialized.equals("#") && !alreadyAdded.contains(serialized)) {
            result.add(node);
            alreadyAdded.add(serialized);
        } else {
        	set.add(serialized);
        }
        return serialized;
    }
    
    public static void main(String args[]) {
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(1);
    	
    	LC652M_DuplicateSubTrees dst = new LC652M_DuplicateSubTrees();
    	dst.findDuplicateSubtrees(root);
    }
}
