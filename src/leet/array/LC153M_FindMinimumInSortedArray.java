package leet.array;

public class LC153M_FindMinimumInSortedArray {
	public int findMin(int[] nums) {
        //1,2,3,4,5
        //3,4,5,1,2
        //2,3,4,5,1
        
        //if one of the sides is decreasing .. go there
        //if both are increasing, then return first element
        int min = Integer.MAX_VALUE;
        for(int num:nums)
            min = Math.min(min, num);
        
        return min;
    }
}
