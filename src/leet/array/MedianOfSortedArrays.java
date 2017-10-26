package leet.array;

public class MedianOfSortedArrays {
	// Is this that hard? We can find/know the size of the two arrays.
    // Median will be the middle element, in case of odd sum of arrays.
    // Or it will be the sum of two middle elements, in case of even sum of arrays.
    // Two pointers, basic idea is to increment them as you'd in a merge sort.

    // TCs
    // Both are empty, then median is 0.
    // One is empty, median is the middle (or middle two) of the non-empty array.
    // One array is greater elements, other is smaller.
    // Alternate or randomly sorted elements.
    // 
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    
        int len1 = nums1.length;
        int len2 = nums2.length;
        
		return 0.0;
        
    }
}
