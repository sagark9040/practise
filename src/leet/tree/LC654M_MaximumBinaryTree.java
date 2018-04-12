package leet.tree;

import java.util.ArrayList;
import java.util.List;

public class LC654M_MaximumBinaryTree {
    //1244 .. 9 min AC!
	
	//IMPROVEMENT:
	//COULD"VE USED CONSTANT SPACE WITH THIS
	//        return build(nums, 0, nums.length - 1);
//		}
//		
//		private TreeNode build(int[] nums, int start, int end) {
//		    if (start > end) return null;
	
    
    //if arr = empty            root = null
    //root = find the max of nums
    //root.left = arr till pos of root
    //root.right = arr from pos+1 of root
    //return root
    
    //root
    
    int findPositionOfMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pos = -1;
        int curPos = 0;
        
        for(int num:nums) {
            if(num > max) {
                max = num;
                pos = curPos;
            }
            curPos++;
        }
        return pos;
    }
    
    int[] leftArray(int[] nums, int pos) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<pos; i++) {
            list.add(nums[i]);
        }
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;            
    }
    
    int[] rightArray(int[] nums, int pos) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=pos+1; i<nums.length; i++) {
            list.add(nums[i]);
        }
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;           
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        
        int pos = findPositionOfMax(nums);
        TreeNode root = new TreeNode(nums[pos]);
        root.left = constructMaximumBinaryTree(leftArray(nums, pos));
        root.right = constructMaximumBinaryTree(rightArray(nums, pos));
        return root;
    }
}
