package leet.tree;

public class LC112E_PathSum {
	//325pm --> 414p including optimal ----- CHECKOUT OPTIMAL SOLN
    
    //go to leftmost root return the sum at that to the parent
    //go to rightmost root return the sum at that to the parent
    //parent adds itself to the sum of l, and then sumOf r 
    //if foundSum || parent+l = sum || parent+r = sum ... foundSum = true
    //return p+l+r 
    
    //levels = [0, 1, 2, 3]
    
    public boolean hasPath = false;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        // OH MY GOD!! THIS SOLUTION IS SO SIMPLE YET EASY TO MISS
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    
    
    public boolean hasPathSumSubOptimal(TreeNode root, int sum) {
        int[] levels = new int[getMaxDepth(root)];
        hasPathSum(root, sum, levels, 0);
        return hasPath;
    }
    
    public void hasPathSum(TreeNode root, int sum, int[] levels, int curLevel) {
        
        if(root == null || hasPath) {
            return;
        }

        levels[curLevel] = root.val;
        if(!hasPath && pathSumsToTarget(levels, sum) && 
           root.left == null && root.right == null) { //need to check if cur root = leaf
            hasPath = true;
            return;
        }
        
        hasPathSum(root.left, sum, levels, curLevel+1);
        hasPathSum(root.right, sum, levels, curLevel+1);   
    }
    
    public boolean pathSumsToTarget(int[] levels, int target) {
        int sum = 0;
        for(int l:levels) {
            sum += l;            
        }
        return sum == target;
    }
    
//     Given the below binary tree and sum = 22,

//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \      \
//         7    2      1
    
    public int getMaxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.right == null && root.left == null) {
            return 1;
        }
        
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        return Math.max(left, right) + 1;
    }
    
    public static void main(String args[]) {
    	LC112E_PathSum p = new LC112E_PathSum();
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(-2);
		t.right = new TreeNode(-3);
		t.right.left = new TreeNode(-2);
		
		t.left.left = new TreeNode(1);
		t.left.right = new TreeNode(3);
		
		t.left.left.left = new TreeNode(-1);
		
		

		
		System.out.println(p.hasPathSum(t, 2));
    }
}

/*

*/
