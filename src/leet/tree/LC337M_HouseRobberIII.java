package leet.tree;

public class LC337M_HouseRobberIII {
	    
	    // 328 .. 24 mins 61/124 TC
	    // post order traversal
	    // calculate the sum of children and if they're greater than the parent, then include children, else parents
	    
//	     3
	// 2       2
	    // sumOfChildren = 4
	    // parent = 3
	        
	    // empty
	    // 3
	    
	    //   3
	    // 4
	    
	    //   3
	    // 3
	    
	    //  4
	    //      5
	    
	    //       5
	    //   2       4
	    // 3   
	     
	    // calculateSumChildren  .. addToSet?
	    // 
	    //         5 .. [5, 6]
	    // [6,8] 2   4  [6,5]
	    // []  3
	    
	    
	    // in postorder traversal
	    // for every node .. calculate the children sum.. assign [itself, children]
	    
	    // if (root == null)    return 0,0;
	    // if (root.left != null) leftPair = getPair(root.left)
	    // if (root.right != null) rightPair = getPair(root.right);
	    
	    // return Pair (leftPair.excluded + rightPair.excluded + root.val  OR leftPair.included + rightPair.included);
	    
	
	    public int rob(TreeNode root) {
	        Pair pair = getValue(root);
	        return Math.max(pair.included, pair.excluded);
	    }
	    
	    public Pair getValue(TreeNode root) {
	        if(root == null) {
	            return new Pair(0, 0);
	        }
	        
	        Pair leftPair = new Pair(0,0), rightPair = new Pair(0,0);
	        
	        if(root.left != null) {
	            leftPair = getValue(root.left);    
	        }
	        if(root.right != null) {
	            rightPair = getValue(root.right);    
	        }
	        
	        return new Pair(leftPair.excluded + rightPair.excluded + root.val, 
	        		Math.max(leftPair.included, leftPair.excluded) + Math.max(rightPair.excluded, rightPair.included));
	    }
	}
//	    int maxValue = 0;
//	    public int rob(TreeNode root) {        
//	        return getValue(root);
//	    }
//	    
//	    public int getValue(TreeNode root) {
//	        if(root == null) {
//	            return 0;
//	        }
//	        
//	        int left = 0, right = 0;
//	        if(root.left != null) {
//	            left = getValue(root.left.left) + getValue(root.left.right);    
//	        }
//	        if(root.right != null) {
//	            right = getValue(root.right.left) + getValue(root.right.right);    
//	        }
//
//	        return Math.max(left+right+root.val, getValue(root.left) + getValue(root.right));
//	    }
//	}

	/*
	     3
	    / \
	   2   3
	    \   \ 
	     3   1


	     3
	    / \
	   4   5
	  / \   \ 
	 1   3   1

	*/

	class Pair{
	    int included;
	    int excluded;   
	    
	    Pair(int i, int e) {
	        included = i;
	        excluded = e;
	    }
	}

