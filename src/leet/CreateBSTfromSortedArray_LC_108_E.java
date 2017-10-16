package leet;

import ctci.Chp4_TreesAndGraphs.Tree;
import ctci.Chp4_TreesAndGraphs.TreeNode;

public class CreateBSTfromSortedArray_LC_108_E {
	public TreeNode sortedArrayToBST(int[] nums) {
		// TC nums is empty or just one element
        if(nums.length == 0)
            return null;
        
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        
        TreeNode root = createBST(nums, 0, nums.length-1);
        return root;
    }
    
    public TreeNode createBST(int[] nums, int start, int end){
        if(start > end)
        	return null;
    	
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, start, mid-1);
        root.right = createBST(nums, mid+1, end);
        
        return root;
    }
    
    public static void main(String args[]){
    	CreateBSTfromSortedArray_LC_108_E createBST = new CreateBSTfromSortedArray_LC_108_E();
    	
    	emptyArray(createBST);
    	singleElementArray(createBST);
    	multiElementArray(createBST);
    	
    }

	private static void multiElementArray(CreateBSTfromSortedArray_LC_108_E createBST) {
		 createBST = new CreateBSTfromSortedArray_LC_108_E();
		Tree.printBinaryTree(createBST.sortedArrayToBST(new int[]{}));		
	}

	private static void singleElementArray(CreateBSTfromSortedArray_LC_108_E createBST) {
		Tree.printBinaryTree(createBST.sortedArrayToBST(new int[]{1}));
		
	}

	private static void emptyArray(CreateBSTfromSortedArray_LC_108_E createBST) {
		Tree.printBinaryTree(createBST.sortedArrayToBST(new int[]{1,2}));
		
	}
}
