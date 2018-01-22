package fb.se.trees;

import ctci.Chp4_TreesAndGraphs.TreeNode;

public class Incomplete_ConstructABinTreeFromPreAndInOrder {
	
	int preIndex = 0;
	
	TreeNode buildTree(int in[], int pre[], int inStrt, int inEnd) 
    {
        if (inStrt > inEnd) 
            return null;
  
        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        TreeNode tNode = new TreeNode(pre[preIndex++]);
  
        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;
  
        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.data);
  
        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
  
        return tNode;
    }
  
    /* UTILITY FUNCTIONS */
     
    /* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
    int search(int arr[], int strt, int end, int value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
	
    public int findIndexOfRoot(int[] inorder, int rootVal){
        
        int index=0;
        for(int val: inorder){
            if (val == rootVal)
                return index;
            index++;
        }  
        
        return -1;
    }
    
    public static void main(String args[]){
    	Incomplete_ConstructABinTreeFromPreAndInOrder constTree = new Incomplete_ConstructABinTreeFromPreAndInOrder();
    	int[] preorder = {1,2,4,5,3,6,7};
    	int[] inorder = {4,2,5,1,6,3,7};
    	constTree.buildTree(preorder, inorder, 0, preorder.length-1);
    }
}
