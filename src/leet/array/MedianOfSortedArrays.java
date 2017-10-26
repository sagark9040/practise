package leet.array;



////////////////////////////////////////
////////
////////		 INCOMPLETE
////////
////////////////////////////////////////

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
        
        if(nums1.length == 0 && nums2.length == 0)
        	return 0;
        
        int ptr1 = 0, ptr2 = 0;
        boolean oddNumOfElements = false;
        double stopperValA, stopperValB = 0;
        
        //sum is even
        if((nums1.length + nums2.length) % 2 == 0){
        	stopperValA = (nums1.length + nums2.length)/2 - 1;
        	stopperValB = (nums1.length + nums2.length)/2;
        }else{
        	stopperValA = (int) (nums1.length + nums2.length)/2;
        	stopperValB = stopperValA;
        	oddNumOfElements = true;
        }
        
        while(ptr1 < nums1.length && ptr2 < nums2.length){
    		if(oddNumOfElements && ptr1+ptr2 == stopperValA-1){
    			//display the next element
    			return nums1[ptr1] > nums2[ptr2] ? nums2[ptr2] : nums1[ptr1];
    		}else if(!oddNumOfElements && ptr1+ptr2 == stopperValB){
    			return ((double)nums1[ptr1] + nums2[ptr2]) / 2;
    		}
    		
    		if(nums1[ptr1] > nums2[ptr2])
    			ptr2++;
    		else
    			ptr1++;
        }
        
        // Handle the situation in nums2
        if(ptr1 == nums1.length){
        	
        }

        // Handle the situation in nums1
        if(ptr2 == nums2.length){
        	
        }

		return 0.0;
        
    }
    
    public static void main(String args[]){
    	MedianOfSortedArrays med = new MedianOfSortedArrays();
    	int[] nums1 = {1, 3}, nums2 = {2, 4};
    	System.out.println(med.findMedianSortedArrays(nums1, nums2));
    }
}
