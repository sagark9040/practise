package leet.tree;

public class LC742M_ClosestLeafInABinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	// APPROACH 1
	
	// Thoughts ... I'll do BFS and then keep a variable called nearest leaf if the child nodes of it are null
	// Either the k node is found before above or after above. The first time both are found, return the nearestLeaf.
	// What if k itself is a leaf? 
	
	// APPROACH 2
	
	// Do a DFS. Get a leaf node before the search node. If the search node itself is a leaf, then return that.
	// 
	
	// TCs
	// Root itself is a leaf and also k
	// k itself is a leaf, but not root
	// k on one side, closes leaf on the other side
	// k and closest both on one side.
	// close before k
	// k before closest

	class Leaf {
        int value;
        int counter;
        Leaf(int v, int c) {
            value = v;
            counter = c;
        }
    }
    
    Leaf prevLeaf;
    Leaf nearestLeaf;
    int counter = 0, kPos = Integer.MIN_VALUE;
    public int findClosestLeaf(TreeNode root, int k) {
        dfs(root, k);
        return nearestLeaf != null ? nearestLeaf.value : 0;
    }
    
    public void dfs(TreeNode root, int k) {
        if(root == null) return;

        
        counter++;
        if(root.val == k) {
            kPos = counter;
        }
        if(root.left == null && root.right == null) {
            prevLeaf = new Leaf(root.val, counter);
        }
        
        if(kPos != Integer.MIN_VALUE && prevLeaf != null) {
                int gap = Math.abs(kPos - prevLeaf.counter);
                if(nearestLeaf == null || nearestLeaf.counter > Math.abs(kPos - prevLeaf.counter)) { 
                    nearestLeaf = new Leaf(prevLeaf.value, gap);
                }
        }
        dfs(root.left, k);
        counter++;
        if(root.val == k) {
            kPos = counter;
        }
        if(root.left == null && root.right == null) {
            prevLeaf = new Leaf(root.val, counter);
        }
        
        if(kPos != Integer.MIN_VALUE && prevLeaf != null) {
                int gap = Math.abs(kPos - prevLeaf.counter);
                if(nearestLeaf == null || nearestLeaf.counter > Math.abs(kPos - prevLeaf.counter)) { 
                    nearestLeaf = new Leaf(prevLeaf.value, gap);
                }
        }
        
        dfs(root.right, k);
        
        
    }
    
    public static void main(String args[]) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.left.left = new TreeNode(7);
    	root.right = new TreeNode(2);
    	
    	LC742M_ClosestLeafInABinaryTree c = new LC742M_ClosestLeafInABinaryTree();
    	c.findClosestLeaf(root, 4);
    }
    
}

/*
Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The nearest leaf node is the root node itself.
Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
Note:
root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.
*/