package leet.tree;

public class LC124H_BinaryTreeMaximumPathSum {
	 //1044pm .. 36 min AC .. didn't even consider negatives!!!!! FML!!!
    //26 min .. 67/92 TCs, did not consider negatives!!!
    //At any node, path sum = max(left) + max(right) + self
    
//     1
//  4     5
// 8 6
    
    
//     1
        
    
//         1
//     4        6
//            8   10     
        
//         1
//     5       4
//   9   10  6   5
                
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {        
        maxPathSum2(root);
        return maxSum;
    }
    
    public int maxPathSum2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        int sum = 0, rightSum = 0, leftSum = 0;
        if(root.right != null) {
            rightSum = maxPathSum2(root.right);
        } 
        if (root.left != null) {
            leftSum = maxPathSum2(root.left);
        }
        if(leftSum > 0)
            sum += leftSum;
        if(rightSum > 0)
            sum += rightSum;
        sum += root.val;
        maxSum = Math.max(sum, maxSum);
        return Math.max(root.val, Math.max(leftSum, rightSum) + root.val);
    }
}
